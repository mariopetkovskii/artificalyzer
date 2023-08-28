package com.artificalyzer.xcontrollers.userrolecontrollers;

import com.artificalyzer.models.userroles.entity.Token;
import com.artificalyzer.models.userroles.entity.User;
import com.artificalyzer.models.userroles.helpers.AccountRecoveryChangePasswordHelper;
import com.artificalyzer.models.userroles.helpers.AccountRecoveryHelper;
import com.artificalyzer.models.userroles.helpers.ChangePasswordHelper;
import com.artificalyzer.models.userroles.helpers.UserHelper;
import com.artificalyzer.records.UserResponseDto;
import com.artificalyzer.service.userroleservice.interfaces.TokenService;
import com.artificalyzer.service.userroleservice.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Map;

@RestController
@RequestMapping("/rest/user")
@CrossOrigin("http://localhost:4200/")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> register(@RequestBody UserHelper userHelper){
        return this.userService.register(userHelper)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordHelper changePasswordHelper){
        return this.userService.changePassword(changePasswordHelper)
                .map(user -> ResponseEntity.ok().body("Password is changed successfully."))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/edit-account")
    public ResponseEntity<String> editAccount(@RequestBody UserHelper userHelper){
        return this.userService.editAccount(userHelper)
                .map(user -> ResponseEntity.ok().body("Account is changed successfully."))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @GetMapping("/confirm-account")
    public void confirmAccount(@RequestParam String token, HttpServletResponse response) throws IOException {
        Token tokenInDB = this.tokenService.findByToken(token);
        if(tokenInDB!=null){
            if(tokenInDB.getExpirationDate().isBefore(OffsetDateTime.now())){
                this.tokenService.deleteByToken(token);
                this.userService.deleteUserByEmail(tokenInDB.getUser().getEmail());
                response.sendRedirect("http://localhost:4200/login/tokenexpired?m=tokenexpired");
            }
            else {
                User user = tokenInDB.getUser();
                if(user.getIsEnabled()){
                    response.sendRedirect("http://localhost:4200/login?m=exists");
                }
                else {
                    this.userService.enableAccount(user);
                }
                this.tokenService.deleteByToken(token);
                response.sendRedirect("http://localhost:4200/login?m=success");
            }
        }
    }

    @GetMapping("/recovery-password")
    public void recoveryPassword(@RequestParam String token, HttpServletResponse response) throws IOException{
        Token tokenInDB = this.tokenService.findByToken(token);
        if(tokenInDB!=null){
            if(tokenInDB.getExpirationDate().isBefore(OffsetDateTime.now())){
                this.tokenService.deleteByToken(token);
            }
            else {
                response.sendRedirect("http://localhost:4200/forgot-change-password?token=" + token);
            }
        }
    }

    @PostMapping("/recovery-password/sendMail")
    public void sendMailForRecovery(@RequestBody AccountRecoveryHelper accountRecoveryHelper){
        this.userService.recoverAccount(accountRecoveryHelper);
    }

    @PostMapping("/recovery-password")
    public ResponseEntity<String> recoveryPassword(@RequestBody AccountRecoveryChangePasswordHelper accountRecoveryChangePasswordHelper){
        return this.userService.recoveryAccountChangePassword(accountRecoveryChangePasswordHelper)
                .map(user -> ResponseEntity.ok().body("Password reset."))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/details")
    public UserResponseDto userResponseDto(){
        return this.userService.getUserDetails();
    }

}