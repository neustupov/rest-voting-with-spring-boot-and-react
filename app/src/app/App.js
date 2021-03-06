import React, {Component} from 'react';
import './App.css';
import {
    Route,
    withRouter,
    Switch
} from 'react-router-dom';

import {getCurrentUser} from '../util/APIUtils';
import {ACCESS_TOKEN} from '../constants';

import Login from '../user/login/Login';
import Signup from '../user/signup/Signup';
import LoadingIndicator from '../common/LoadingIndicator';

import AppHeader from '../common/AppHeader';
import HomePage from '../common/Home';
import Profile from '../user/profile/Profile';
import UsersList from "../user/UsersList";

import {Layout, notification} from 'antd';
import RestaurantsList from "../restaurants/RestaurantsList";
import AppFooter from "../common/AppFooter";

const {Content} = Layout;

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            currentUser: null,
            isAuthenticated: false,
            isLoading: false
        };
        this.handleLogout = this.handleLogout.bind(this);
        this.loadCurrentUser = this.loadCurrentUser.bind(this);
        this.handleLogin = this.handleLogin.bind(this);

        notification.config({
            placement: 'topRight',
            top: 70,
            duration: 3,
        });
    }

    loadCurrentUser() {
        this.setState({
            isLoading: true
        });
        getCurrentUser()
            .then(response => {
                this.setState({
                    currentUser: response,
                    isAuthenticated: true,
                    isLoading: false
                });
            }).catch(error => {
            this.setState({
                isLoading: false
            });
        });
    }

    componentWillMount() {
        this.loadCurrentUser();
    }

    handleLogout(redirectTo = "/", notificationType = "success", description = "You're successfully logged out.") {
        localStorage.removeItem(ACCESS_TOKEN);

        this.setState({
            currentUser: null,
            isAuthenticated: false
        });

        this.props.history.push(redirectTo);

        notification[notificationType]({
            message: 'Rest Voting App',
            description: description,
        });
    }

    handleLogin() {
        notification.success({
            message: 'Rest Voting App',
            description: "You're successfully logged in.",
        });
        this.loadCurrentUser();
        this.props.history.push("/");
    }

    render() {

        if (this.state.isLoading) {
            return <LoadingIndicator/>
        }

        return (
            <Layout className="app-container">
                <AppHeader isAuthenticated={this.state.isAuthenticated}
                           currentUser={this.state.currentUser}
                           onLogout={this.handleLogout}/>

                <Content className="app-content">
                    <div className="container">
                        <Switch>
                            <Route exact path="/"
                                   render={(props) =>
                                       this.state.isAuthenticated === true ?
                                           <RestaurantsList isAuthenticated={this.state.isAuthenticated}
                                                            currentUser={this.state.currentUser}
                                                            handleLogout={this.handleLogout} {...props}/>
                                           : <HomePage/>}>
                            </Route>
                            <Route path="/login"
                                   render={(props) =>
                                       <Login onLogin={this.handleLogin} {...props}/>}>
                            </Route>
                            <Route path="/signup" component={Signup}/>
                            <Route path="/users/:name"
                                   render={(props) => <Profile style={{margin: '32px 0'}}
                                                               isAuthenticated={this.state.isAuthenticated}
                                                               currentUser={this.state.currentUser} {...props}  />}/>
                            <Route path="/users" component={UsersList}/>
                            {/*<PrivateRoute authenticated={this.state.isAuthenticated} path="/poll/new"
                                          component={NewPoll} handleLogout={this.handleLogout}></PrivateRoute>*/}
                            {/*<Route component={NotFound}></Route>*/}
                        </Switch>
                    </div>
                </Content>
                <AppFooter/>
            </Layout>
        );
    }
}

export default withRouter(App);
