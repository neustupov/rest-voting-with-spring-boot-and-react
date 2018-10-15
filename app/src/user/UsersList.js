import React, {Component} from 'react';
import {getAllUsers, setEnabled, deleteUser} from '../util/APIUtils';

import './UsersList.css';

import {Table, Button, Checkbox, notification} from 'antd';

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
        setEnabled(e.target.value, e.target.checked).then(this.loadUsersList());
        notification.success({
            message: 'Successfully',
            description: "Enabled field of " + e.target.value + " change to " + e.target.checked,
        });
    }

    handleDelete(e){
        deleteUser(e.target.value)
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
                <Checkbox checked={record.enabled}
                          onChange={this.onChange}
                          value={record.name}/>
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
                    <Button shape="circle" icon="delete" onClick={this.handleDelete} value={record.name}/>
                </div>
            ),
        }];

        return (
            <Table rowClassName={(row) => row.enabled ? '' : 'disabled'}
                   rowKey='id' columns={columns}
                   dataSource={this.state.users}
                   loading={this.state.isLoading}/>
        )
    }
}

export default UsersList;