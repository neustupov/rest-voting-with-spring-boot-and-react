import React, {Component} from 'react';
import {getAllRestaurantsWithTodaysMenus} from '../util/APIUtils';
import Restaurant from "../restaurants/Restaurant";
import {Row, List, Avatar, Icon} from "antd";

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
        const {restaurants} = this.state;

        /*this.state.restaurants.forEach((restaurant, restIndex) => {
            restaurantsCards.push(<Restaurant
                key={restaurant.id}
                name={restaurant.name}
                votes={restaurant.numberOfVotes}
                meals={restaurant.mealsFromTodaysMenu}/>)
        });*/

        /*return (
            <div style={{background: '#ECECEC', padding: '30px'}}>
                <Row type="flex" justify="space-around" gutter={32}>
                    {restaurantsCards}
                </Row>
            </div>)*/
        return (
            <List style={{ margin: '16px 0 50px' }}
                  header={<div><h1>Choose your restaurant</h1></div>}
                itemLayout="vertical"
                  size="small"
                  pagination={{
                      onChange: (page) => {
                          console.log(page);
                      },
                      pageSize: 5,
                  }}
                  dataSource={restaurants}

                  renderItem={item => (
                      <List.Item
                          key={item.name}
                          actions={<Icon type="star-o" text="156"/>}
                          extra={<img width={272} alt="logo"
                                      src="http://saltonlineordering.com/uploads/7/3/8/9/73898955/editor/sogbu-restaurant-logo-5.png?1497391256"/>}
                      >
                          <List.Item.Meta avatar={<Avatar src={item.avatar}/>}
                                          title={<a href={item.href}>{item.name}</a>}
                                          description={item.name}
                          />
                          {item.name}
                      </List.Item>
                  )}/>)
    }
}

export default RestaurantsList;