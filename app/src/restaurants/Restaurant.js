import React, {Component} from 'react';
import {Card, Col} from 'antd';

import Meal from '../meal/Meal.js';

class Restaurant extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        const meals = [];

        if (this.props.meals !== null) {
            this.props.meals.forEach((meal) => {
                meals.push(<Meal
                    key={meal.id}
                    id={meal.id}
                    name={meal.name}
                    price={meal.price}/>)
            })
        }

        return (
            <Col span={8}>
                <Card
                    title={this.props.name}
                    extra={<a href="#">Vote</a>}
                    style={{width: 300}}>
                    <p>Number of votes : {this.props.votes}</p>
                    <div>{meals}</div>
                </Card>
            </Col>)
    }
}

export default Restaurant;