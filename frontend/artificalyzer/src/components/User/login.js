import React, {useState, setState} from 'react';
import './login.css';
import {useNavigate} from "react-router-dom";
import userService from "../../service/UserService/userService";

function Login(props) {

    const [email, setEmail] = useState(null);
    const [password, setPassword] = useState(null);

    const [errorMessage, updateErrorMessage] = React.useState()

    const handleInputChange = (e) => {
        const {id, value} = e.target;
        if (id === "email") {
            setEmail(value);
        }
        if (id === "password") {
            setPassword(value);
        }
    }

    const history = useNavigate();

    const handleSubmit = async () => {
        const term = await userService.login(email, password)
            .then(() => {
                if (props.onLogin()) {
                    history('/')
                } else {
                    updateErrorMessage(term)
                }
            })
    }

    return (
        <section className="text-center text-lg-start">
            <div className="container py-4">
                <div className="row g-0 align-items-center">
                    <div className="col-lg-6 mb-5 mb-lg-0">
                        <img src="https://i.imgur.com/roU4fxw.jpg"
                             className="w-100 rounded-4 shadow-4"
                             alt=""/>
                    </div>
                    <div className="col-lg-6 mb-5 mb-lg-0">
                        <div className="card cascading-right style-cdd">
                            <div className="card-body p-5 shadow-5 text-center">
                                <h2 className="fw-bold mb-5">Log in</h2>
                                <div className="form-outline mb-4">
                                    <input type="email" id="email" className="form-control"
                                           htmlFor="email" onChange={(e) => handleInputChange(e)}/>
                                    <label className="form-label" htmlFor="email">Email address</label>
                                </div>
                                <div className="form-outline mb-4">
                                    <input type="password" id="password" className="form-control"
                                           htmlFor="password" onChange={(e) => handleInputChange(e)}/>
                                    <label className="form-label" htmlFor="password">Password</label>
                                </div>
                                <button type="submit" className="btn btn-primary btn-block mb-4"
                                        onClick={() => handleSubmit()}>
                                    Log in
                                </button>
                                <div>
                                    <a href="/register" className="link-primary">No account? Register here!</a>
                                </div>
                                <div>
                                    {errorMessage}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    )
}

export default Login;


