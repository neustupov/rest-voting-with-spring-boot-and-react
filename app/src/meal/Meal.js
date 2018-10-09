import React, {Component} from 'react';
import { Row, Col } from 'antd';

class Meal extends Component {

    constructor(props) {
        super(props);
    }

    render() {

        return (
            <div>
                <Row type="flex" justify="start">
                    <Col span={8}>
                    <div>{this.props.id}</div>
                    </Col>
                    <Col span={8}>
                        <div>{this.props.name}</div>
                    </Col>
                    <Col span={8}>
                        <div>{this.props.price}</div>
                    </Col>
                </Row>
            </div>
        )
    }
}

export default Meal;