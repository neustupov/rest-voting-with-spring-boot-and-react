import React, {Component} from 'react';
import {getAllRestaurantsWithTodaysMenus} from '../util/APIUtils';
import Restaurant from "../restaurants/Restaurant";
import {Row} from "antd";

class RestaurantsList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            restaurants: [],
            isLoading: false
        }
    }

    loadRestaurantsList() {
        let promise = getAllRestaurantsWithTodaysMenus();

        this.setState({
                isLoading: true
            }
        );

        if (!promise) {
            return;
        }

        promise
            .then(response => {

                this.setState({
                    restaurants: response,
                    isLoading: false
                })
            }).catch(error => {
            this.setState({
                isLoading: false
            })
        });

    }

    componentDidMount() {
        this.loadRestaurantsList();
    }

    render() {
        const restaurantsCards = [];

        this.state.restaurants.forEach((restaurant, restIndex) => {
            restaurantsCards.push(<Restaurant
                key={restaurant.id}
                name={restaurant.name}
                votes={restaurant.numberOfVotes}
                meals={restaurant.mealsFromTodaysMenu}/>)
        });

        return (
            <div style={{background: '#ECECEC', padding: '30px'}}>
                <Row type="flex" justify="space-around" gutter={32}>
                    {restaurantsCards}
                </Row>
            </div>)

    }
}

export default RestaurantsList;