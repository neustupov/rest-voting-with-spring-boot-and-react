import React, {Component} from 'react';
import './App.css';
import Home from './components/Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import RestaurantsList from './components/RestaurantsList';

class App extends Component {

    render() {

        return (
            <Router>
                <Switch>
                    <Route path='/' exact={true} component={Home}/>
                    <Route path='/restaurants' exact={true} component={RestaurantsList}/>
                </Switch>
            </Router>
        );
    }
}

export default App;
