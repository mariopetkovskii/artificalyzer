import userRepository from '../../repository/UserRepository/UserRepository';

const userService = {
    register: (firstname, lastname, email, password, confirmPassword) => {
        return userRepository.register(firstname, lastname, email, password, confirmPassword);
    },

    login: (email, password) => {
        return userRepository.login(email, password);
    },

    logout: () => {
        return userRepository.logout()
    }
}

export default userService;

