import axios from '../../custom-axios/axios';

const AUTH_TOKEN = 'auth_token';
const loggedInEmail = 'email';

const userRepository = {
    register: (firstname, lastname, email, password, confirmPassword) => {
        return axios.post("/user/register", {
            "firstName": firstname,
            "lastName": lastname,
            "email": email,
            "password": password,
            "confirmPassword": confirmPassword
        }).then(res => res.message)
            .catch(res => res.response.data.message)
    },

    login: (email, password) => {
        return axios.post("/user/login", {}, {
            auth: {
                username: email,
                password: password
            }
        }).then(res => {
            localStorage.setItem(AUTH_TOKEN, res.data);
            localStorage.setItem(loggedInEmail, email);
            return res;

        }).catch(res => res.response.data.message);
    },

    logout: () =>{
        localStorage.removeItem(AUTH_TOKEN)
    }
}

export default userRepository;