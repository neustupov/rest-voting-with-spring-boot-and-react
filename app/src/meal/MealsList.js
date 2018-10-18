import React, {Component} from 'react';
import Meal from '../meal/Meal.js';

class MealsList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            meals: []
        }
    }

    loadMeals(mealList) {
        const me = [];

        this.props.meals.map(meal => {
            me.push(<Meal key={meal.id} name={meal.name} price={meal.price}/>)
        });

        this.setState({
            meals: me
        })
    }

    componentDidMount() {
        this.loadMeals(this.props.meals);
    }

    render() {

        const mealsList = this.state.meals;

        return (
            <div>
                {mealsList}
            </div>
        )
    }
}

export default MealsList;