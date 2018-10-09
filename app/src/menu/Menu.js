import React, {Component} from 'react';
import {Card} from 'antd';

import Meal from '../meal/Meal.js';

class Menu extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        const meals = [];

        this.props.menu.meals.forEach((meal) => {
            meals.push(<Meal
                key={meal.id}
                id={meal.id}
                name={meal.name}
                price={meal.price}/>)
        });

        return (
            <Card
                title={this.props.menu.nameOfRestaurant}
                extra={<a href="#">More</a>}
                style={{width: 300}}
            >
                <p>Menu id : {this.props.menu.id}</p>
                <p>Date of menu : {this.props.menu.date}</p>
                <p>Id of Restaurant : {this.props.menu.idOfRestaurant}</p>
                <p>Number of votes : {this.props.menu.numberOfVotes}</p>
                <div>{meals}</div>
            </Card>)
    }
}

export default Menu;