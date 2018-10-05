import React, {Component} from 'react';
import {getAllTodaysMenus} from '../util/APIUtils';
import LoadingIndicator from '../common/LoadingIndicator';
import {Card, Col, Row} from 'antd';
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
        )

    }

    render() {
        <div style={{background: '#ECECEC', padding: '30px'}}>
            <Row gutter={16}>
                <Col span={8}>
                    <Card title="Card title" bordered={false}>Card content</Card>
                </Col>
                <Col span={8}>
                    <Card title="Card title" bordered={false}>Card content</Card>
                </Col>
                <Col span={8}>
                    <Card title="Card title" bordered={false}>Card content</Card>
                </Col>
            </Row>
        </div>
    }
}

export default withRouter(MenusList)