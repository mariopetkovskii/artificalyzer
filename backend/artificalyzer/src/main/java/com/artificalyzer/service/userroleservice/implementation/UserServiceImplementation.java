package com.artificalyzer.service.userroleservice.implementation;

import com.artificalyzer.models.userroles.entity.Role;
import com.artificalyzer.models.userroles.entity.Token;
import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.models.userroles.entity.UserRole;
import com.artificalyzer.models.userroles.exceptions.*;
import com.artificalyzer.models.userroles.helpers.*;
import com.artificalyzer.repository.userrolerepository.RoleRepository;
import com.artificalyzer.repository.userrolerepository.UserRepository;
import com.artificalyzer.repository.userrolerepository.UserRoleRepository;
import com.artificalyzer.service.userroleservice.interfaces.TokenService;
import com.artificalyzer.service.userroleservice.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JavaMailSender javaMailSender;
    private final RoleRepository roleRepository;

    private final TokenService tokenService;

    private final UserRoleRepository userRoleRepository;


    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static boolean validatePassword(String emailStr) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(emailStr);
        return matcher.find();
    }


    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Boolean passwordMatches(User user, String password) {
        return this.passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public Optional<User> register(UserHelper userHelper) {
        if(!validateEmail(userHelper.getEmail())){
            throw new MailNotValidException();
        }

        if (!validatePassword(userHelper.getPassword())){
            throw new PasswordNotValidException();
        }

        User user = this.userRepository.findByEmail(userHelper.getEmail());

        if(user != null){
            throw new UserAlreadyExistsException();
        }

        if(!userHelper.getPassword().equals(userHelper.getConfirmPassword())){
            throw new PasswordsDoNotMatchException();
        }
        User newUser = new User(
                userHelper.getFirstName(),
                userHelper.getLastName(),
                userHelper.getEmail(),
                passwordEncoder.encode(userHelper.getPassword()));
        Role role = this.roleRepository.findByName("ROLE_ADMIN");
        UserRole userRole = new UserRole(newUser, role);
        this.userRoleRepository.save(userRole);

        Token token = new Token();
        String tokenValue = UUID.randomUUID().toString();
        token.setToken(tokenValue);
        token.setExpirationDate(OffsetDateTime.now().plusMinutes(300));
        token.setUser(newUser);
        tokenService.create(token);

        sendMailConfirmation(userHelper.getEmail(), tokenValue);

        return Optional.of(newUser);
    }

    @Override
    public Optional<Boolean> recoverAccount(AccountRecoveryHelper accountRecoveryHelper){
        User user = this.userRepository.findByEmail(accountRecoveryHelper.getEmail());
        Token token = new Token();
        String tokenValue = UUID.randomUUID().toString();
        token.setToken(tokenValue);
        token.setExpirationDate(OffsetDateTime.now().plusMinutes(3));
        token.setUser(user);
        tokenService.create(token);
        return Optional.of(sendMailRecoveryAccount(accountRecoveryHelper.getEmail(), tokenValue));
    }

    @Override
    public void deleteUserByEmail(String email) {
        User user = this.userRepository.findByEmail(email);
        this.userRepository.deleteById(user.getId());
    }

    @Override
    public Optional<User> editAccount(UserHelper userHelper) {
        User user = this.userRepository.findByEmail(userHelper.getEmail());
        user.setFirstName(userHelper.getFirstName());
        user.setLastName(userHelper.getLastName());
        user.setEmail(userHelper.getEmail());
        this.userRepository.save(user);
        return Optional.of(user);
    }


    @Transactional
    @Override
    public Optional<User> changePassword(ChangePasswordHelper changePasswordHelper) {
        User user = this.userRepository.findByEmail(changePasswordHelper.getEmail());
        if(!passwordEncoder.matches(changePasswordHelper.getOldPassword(), user.getPassword())){
            throw new OldPasswordDoNotMatchException();
        }
        if(!changePasswordHelper.getNewPassword().equals(changePasswordHelper.getConfirmNewPassword())){
            throw new PasswordsDoNotMatchException();
        }
        user.setPassword(passwordEncoder.encode(changePasswordHelper.getNewPassword()));
        user.setDateModified(OffsetDateTime.now());
        return Optional.of(user);
    }

    @Override
    public User enableAccount(User user) {
        user.setIsEnabled(true);
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> addRoleToUser(AddRoleToUserHelper addRoleToUserHelper) {
        User user = this.userRepository.findByEmail(addRoleToUserHelper.getEmail());
        Role role = this.roleRepository.findByName(addRoleToUserHelper.getRole());
        UserRole userRole = new UserRole(user, role);
        this.userRoleRepository.save(userRole);
        return Optional.of(user);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void deleteUser(DeleteUserHelper deleteUserHelper) {
        User user = this.userRepository.findByEmail(deleteUserHelper.getEmail());
        this.userRepository.deleteById(user.getId());
    }

    @Override
    public Optional<User> getUserDetails(UserHelper userHelper) {
        return Optional.of(this.userRepository.findByEmail(userHelper.getEmail()));
    }

    @Override
    public Optional<User> recoveryAccountChangePassword(AccountRecoveryChangePasswordHelper accountRecoveryChangePasswordHelper) {
        User user = this.userRepository.findByEmail(accountRecoveryChangePasswordHelper.getEmail());
        if(!accountRecoveryChangePasswordHelper.getNewPassword().equals(accountRecoveryChangePasswordHelper.getConfirmNewPassword())){
            throw new PasswordsDoNotMatchException();
        }
        Token token = this.tokenService.findByToken(accountRecoveryChangePasswordHelper.getToken());
        if(!token.getUser().equals(user))
        {
            throw new TokenDoesNotMatchUserException();
        }
        user.setPassword(passwordEncoder.encode(accountRecoveryChangePasswordHelper.getNewPassword()));
        return Optional.of(this.userRepository.save(user));
    }


    private void sendMailConfirmation(String email, String token){
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setTo(email);
            mailMessage.setSubject("Confirmation email!");
            mailMessage.setFrom("artificalyzermk@outlook.com");
            mailMessage.setText("Click here to confirm your account : "
                    +"http://localhost:8080/rest/user/confirm-account?token="+token);

            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Boolean sendMailRecoveryAccount(String email, String token){
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(email);
        mailMessage.setSubject("Account Recovery!");
        mailMessage.setFrom("artificalyzermk@outlook.com");
        mailMessage.setText("Click here to change your password : "
                +"http://localhost:8080/rest/user/recovery-password?token="+token);

        javaMailSender.send(mailMessage);

        return true;
    }


}