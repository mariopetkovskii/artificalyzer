import React, {useState, setState} from 'react';
import './register.css';
import {useNavigate} from "react-router-dom";
import userService from "../../service/UserService/userService";

function Register() {

    const [firstName, setFirstName] = useState(null);
    const [lastName, setLastName] = useState(null);
    const [email, setEmail] = useState(null);
    const [password, setPassword] = useState(null);
    const [confirmPassword, setConfirmPassword] = useState(null);

    const [errorMessage, updateErrorMessage] = React.useState()

    const handleInputChange = (e) => {
        const {id, value} = e.target;
        if (id === "firstName") {
            setFirstName(value);
        }
        if (id === "lastName") {
            setLastName(value);
        }
        if (id === "email") {
            setEmail(value);
        }
        if (id === "password") {
            setPassword(value);
        }
        if (id === "confirmPassword") {
            setConfirmPassword(value);
        }
    }

    const history = useNavigate();

    const handleSubmit = async () => {
        const term = await userService.register(firstName, lastName, email, password, confirmPassword);

        updateErrorMessage(term);


    }


    return (
        <section className="text-center text-lg-start">
            <div className="container py-4">
                <div className="row g-0 align-items-center">
                    <div className="col-lg-6 mb-5 mb-lg-0">
                        <div className="card cascading-right style-cdd">
                            <div className="card-body p-5 shadow-5 text-center">
                                <h2 className="fw-bold mb-5">Sign up now</h2>
                                <div className="row">
                                    <div className="col-md-6 mb-4">
                                        <div className="form-outline">
                                            <input type="text" id="firstName" className="form-control"
                                                   htmlFor="firstName" onChange={(e) => handleInputChange(e)}/>
                                            <label className="form-label" htmlFor="firstName">First name</label>
                                        </div>
                                    </div>
                                    <div className="col-md-6 mb-4">
                                        <div className="form-outline">
                                            <input type="text" id="lastName" className="form-control"
                                                   htmlFor="lastName" onChange={(e) => handleInputChange(e)}/>
                                            <label className="form-label" htmlFor="lastName">Last name</label>
                                        </div>
                                    </div>
                                </div>

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

                                <div className="form-outline mb-4">
                                    <input type="password" id="confirmPassword" className="form-control"
                                           htmlFor="confirmPassword" onChange={(e) => handleInputChange(e)}/>
                                    <label className="form-label" htmlFor="form3Example4"
                                           htmlFor="confirmPassword">Confirm
                                        Password</label>
                                </div>

                                <button type="submit" className="btn btn-primary btn-block mb-4"
                                        onClick={() => handleSubmit()}>
                                    Sign up
                                </button>
                                <div>
                                    <a href="/login" className="link-primary">Already have account?</a>
                                </div>
                                <div>
                                    {errorMessage}
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="col-lg-6 mb-5 mb-lg-0">
                        <img src="https://i.imgur.com/roU4fxw.jpg"
                             className="w-100 rounded-4 shadow-4"
                             alt=""/>
                    </div>
                </div>
            </div>
        </section>
    )
}


export default Register;