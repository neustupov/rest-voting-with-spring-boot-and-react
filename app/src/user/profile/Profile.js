import React, {Component} from 'react';
import {Card, Checkbox, Row} from 'antd';
import {getCurrentUser} from '../../util/APIUtils';
import LoadingIndicator from '../../common/LoadingIndicator';
import './Profile.css';
import {withRouter} from 'react-router-dom';
import {formatDateTime} from '../../util/Helpers';


class Profile extends Component {

    constructor(props) {
        super(props);
        this.state = {
            user: null,
            isLoading: false
        };
        this.loadUserProfile = this.loadUserProfile.bind(this);
    }

    loadUserProfile(name) {
        this.setState({
            isLoading: true
        });

        getCurrentUser(name)
            .then(response => {
                this.setState({
                    user: response,
                    isLoading: false
                });
            }).catch(error => {
            if (error.status === 404) {
                this.setState({
                    notFound: true,
                    isLoading: false
                });
            } else {
                this.setState({
                    serverError: true,
                    isLoading: false
                });
            }
        });
    }

    componentDidMount() {
        const name = this.props.currentUser.name;
        this.loadUserProfile(name);
    }

    componentDidUpdate(nextProps) {
        if (this.props.match.params.name !== nextProps.match.params.name) {
            this.loadUserProfile(nextProps.match.params.name);
        }
    }

    render() {

        if (this.state.isLoading) {
            return <LoadingIndicator/>;
        }

        return (

            this.state.user ? (
                <Row type="flex" justify="space-around">
                    <Card
                        title={this.state.user.name}
                        extra={<a href="#">Update</a>}
                        style={{width: 300}}
                    >
                        <p>Id : {this.state.user.id}</p>
                        <p>Email : {this.state.user.email}</p>
                        <p>Password : XXX</p>
                    </Card>
                </Row>) : null);
    }
}

export default withRouter(Profile);