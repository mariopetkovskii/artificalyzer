import React, {Component} from "react";
import './App.css';
import Header from "../Header/header"
import {Navigate, Route, Routes} from "react-router-dom";
import Register from "../User/register";
import Login from "../User/login";
import userService from "../../service/UserService/userService";
import Home from "../Home/home";

const AUTH_TOKEN = 'auth_token';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isUserLoggedIn: localStorage.getItem(AUTH_TOKEN) !== null,

        }
    }

    componentDidMount() {
    }


    render() {
        return (
            <div>
                <Header logout={this.logout}
                        isUserLoggedIn={this.state.isUserLoggedIn}/>
                <Routes>
                    <Route path='/home' exact element={<Home/>}/>
                    <Route path='/register' exact element={<Register/>}/>
                    <Route path='/login' exact element={<Login onLogin={() => this.changeLoginStateIfLoggedIn()}/>}/>
                    <Route path="/" element={<Navigate to={"/home"}/>}/>
                </Routes>
            </div>
        )
    }

    logout = () => {
        userService.logout()
        window.location.href = "/login"
    }

    changeLoginStateIfLoggedIn(){
        let checkIfLoggedIn = localStorage.getItem(AUTH_TOKEN) !== null

        this.setState({
            isUserLoggedIn: checkIfLoggedIn
        })

        return checkIfLoggedIn;
    }

}

export default App;