import {API_BASE_URL, ACCESS_TOKEN} from '../constants';

const request = (options) => {
    const headers = new Headers({
        'Content-Type': 'application/json',
    });

    if (localStorage.getItem(ACCESS_TOKEN)) {
        headers.append('Authorization', 'Bearer ' + localStorage.getItem(ACCESS_TOKEN))
    }

    const defaults = {headers: headers};
    options = Object.assign({}, defaults, options);

    return fetch(options.url, options)
        .then(response =>
            response.json()
                .then(json => {
                    if (!response.ok) {
                        return Promise.reject(json);
                    }
                    return json;
                })
        );
};

export function login(loginRequest) {
    return request({
        url: API_BASE_URL + "/auth/signin",
        method: 'POST',
        body: JSON.stringify(loginRequest)
    });
}

export function signup(signupRequest) {
    return request({
        url: API_BASE_URL + "/auth/signup",
        method: 'POST',
        body: JSON.stringify(signupRequest)
    });
}

export function checkNameAvailability(name) {
    return request({
        url: API_BASE_URL + "/users/checkNameAvailability?name=" + name,
        method: 'GET'
    });
}

export function checkEmailAvailability(email) {
    return request({
        url: API_BASE_URL + "/users/checkEmailAvailability?email=" + email,
        method: 'GET'
    });
}

export function getAllUsers() {
    return request({
        url: API_BASE_URL + "/users",
        method: 'GET'
    })
}

export function getCurrentUser() {
    if (!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }

    return request({
        url: API_BASE_URL + "/users/me",
        method: 'GET'
    });
}

export function getUserProfile(name) {
    return request({
        url: API_BASE_URL + "/users/" + name,
        method: 'GET'
    });
}

export function getAllTodaysMenus() {
    return request({
        url: API_BASE_URL + "/menus",
        method: 'GET'
    })
}

export function getAllRestaurantsWithTodaysMenus() {
    return request({
        url: API_BASE_URL + "/restaurants",
        method: 'GET'
    })
}

export function setEnabled(name, enabled) {
    return request({
        url: API_BASE_URL + "/users/" + name + "?enabled=" + enabled,
        method: 'POST'
    })
}

export function deleteUser(nameOrEmail) {
    return request({
        url: API_BASE_URL + "/users/" + nameOrEmail,
        method: 'DELETE'
    })
}

export function voting(voteTo) {
    return request({
        url: API_BASE_URL + "/votes",
        method: 'POST',
        body: JSON.stringify(voteTo)
    })
}