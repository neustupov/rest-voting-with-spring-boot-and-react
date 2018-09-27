import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
    state = {
        isLoading: true,
        restaurants: []
    };

    async componentDidMount() {
        const response = await fetch('/restaurants');
        const body = await response.json();
        this.setState({restaurants: body, isLoading: false});
    }

    render() {

        const {restaurants, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <h1 className="App-title">Welcome to React</h1>
                </header>
                <div className="App-intro">
                    <h2>Restaurants List</h2>
                    {restaurants.map(restaurant =>
                        <div key={restaurant.id}>
                            {restaurant.name}
                        </div>
                    )}
                </div>
            </div>
        );
    }
}

export default App;
