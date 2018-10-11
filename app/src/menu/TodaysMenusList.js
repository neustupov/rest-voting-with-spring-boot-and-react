import React, {Component} from 'react';
import {getAllTodaysMenus} from '../util/APIUtils';
import Menu from './Menu';
import LoadingIndicator from '../common/LoadingIndicator';
import {Col, Row} from 'antd';
import {withRouter} from 'react-router-dom';

class MenusList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            menus: [],
            isLoading: false
        }
    }

    loadMenusList() {
        let promise = getAllTodaysMenus();

        this.setState({
                isLoading: true
            }
        );

        if(!promise) {
            return;
        }

        promise
            .then(response => {

                this.setState({
                    menus: response,
                    isLoading: false
                })
            }).catch(error => {
            this.setState({
                isLoading: false
            })
        });

    }

    componentDidMount() {
        this.loadMenusList();
    }

    render() {
        const menusCards = [];

        this.state.menus.forEach((menu, menuIndex) => {
            menusCards.push(<Menu
                key={menu.id}
                menu={menu}/>)
        });

        return (
            <Row type="flex" justify="space-around">
                {menusCards}
                {/*<Col span={4}>col-4</Col>
                <Col span={4}>col-4</Col>
                <Col span={4}>col-4</Col>
                <Col span={4}>col-4</Col>*/}
            </Row>)
    }
}

export default withRouter(MenusList)