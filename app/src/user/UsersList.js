import React, {Component} from 'react';
import {getAllUsers, setEnabled} from '../util/APIUtils';

import {Table, Icon, Checkbox, Divider} from 'antd';

class UsersList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            users: [],
            isLoading: false
        };

        this.onChange = this.onChange.bind(this);
    }

    loadUsersList() {
        let promise = getAllUsers();

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
                    users: response,
                    isLoading: false
                })
            }).catch(error => {
            this.setState({
                isLoading: false
            })
        });

    }

    componentDidMount() {
        this.loadUsersList();
    }

    onChange(e) {
        setEnabled(e.target.value, e.target.checked);
    }

    render() {

        const columns = [{
            title: 'Id',
            dataIndex: 'id',
            key: 'id'
        }, {
            title: 'Name',
            dataIndex: 'name',
            key: 'name'
        }, {
            title: 'Email',
            dataIndex: 'email',
            key: 'email'
        }, {
            title: 'Registered',
            dataIndex: 'registered',
            key: 'registered'
        }, {
            title: 'Enabled',
            dataIndex: 'enabled',
            key: 'enabled',
            render: (text, record) => (
                <Checkbox checked={record.enabled} onChange={this.onChange} value={record.name}/>
            )
        }, {
            title: 'Roles',
            dataIndex: 'roles',
            key: 'roles'
        }, {
            title: 'Action',
            key: 'action',
            render: (text, record) => (
                <div>
                    <a href="#">
                        <Icon type="edit" theme="outlined" style={{fontSize: '24px'}}/>
                    </a>
                    <Divider type="vertical"/>
                    <a href="#">
                        <Icon type="delete" theme="outlined" style={{fontSize: '24px'}}/>
                    </a>
                </div>
            ),
        }];

        return (
            <Table rowKey='id' columns={columns} dataSource={this.state.users}/>
        )
    }
}

export default UsersList;