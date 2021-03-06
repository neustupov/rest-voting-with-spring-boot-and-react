import React, {Component} from 'react';
import {getAllRestaurantsWithTodaysMenus, voting} from '../util/APIUtils';
import {List, Avatar, Icon} from "antd";

import MealsList from '../meal/MealsList.js';

class RestaurantsList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            restaurants: [],
            isLoading: false
        };
        this.voting=this.voting.bind(this)
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
    
    voting(restId){
        const voteTo = {
            usrId: this.props.currentUser.getId,
            date: new Date(),
            restId: restId
        };

        voting(voteTo)
    }

    render() {
        const {restaurants} = this.state;

        const IconText = ({type, text, restId}) => (
            <div>
                <Icon type={type} style={{fontSize: 24, marginRight: 8}} onClick={this.voting(restId)}/>
                {text}
            </div>
        );

        return (
            <List style={{margin: '0 0 55px'}}
                  header={<div><h1>Choose your restaurant</h1></div>}
                  itemLayout="vertical"
                  size="small"
                  pagination={{
                      onChange: (page) => {
                          this.setState({
                              restaurants: this.loadRestaurantsList()
                          });
                      },
                      pageSize: 2,
                  }}

                  dataSource={restaurants}

                  renderItem={item => (

                      <List.Item
                          key={item.id}
                          actions={[<IconText type="star-o" text={item.numberOfVotes} restId={item.id}/>]}
                          extra={<img width={272} alt="logo"
                                      src="http://saltonlineordering.com/uploads/7/3/8/9/73898955/editor/sogbu-restaurant-logo-5.png?1497391256"/>}
                      >

                          <List.Item.Meta avatar={<Avatar src={item.avatar}/>}
                                          title={<a href={item.href}><h2>{item.name}</h2></a>}
                                          description="Menu for today"
                          />

                          <MealsList meals={item.mealsFromTodaysMenu}/>

                      </List.Item>
                  )}/>)
    }
}

export default RestaurantsList;