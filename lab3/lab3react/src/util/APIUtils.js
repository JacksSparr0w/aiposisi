import { API_BASE_URL, ACCESS_TOKEN } from '../constants';

const request = (options) => {
    const headers = new Headers({
        'Content-Type': 'application/json',
    })
    
    if(localStorage.getItem(ACCESS_TOKEN)) {
        headers.append('Authorization', 'Bearer ' + localStorage.getItem(ACCESS_TOKEN))
    }

    const defaults = {headers: headers};
    options = Object.assign({}, defaults, options);

    return fetch(options.url, options)
    .then(response => 
        response.json().then(json => {
            if(!response.ok) {
                return Promise.reject(json);
            }
            return json;
        })
    );
};

export function getCurrentUser() {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }

    return request({
        url: API_BASE_URL + "/users/me",
        method: 'GET'
    });
}

export function login(loginRequest) {
    return request({
        url: API_BASE_URL + "/auth/login",
        method: 'POST',
        body: JSON.stringify(loginRequest)
    });
}

export function addTransport(transportRequest) {
    return request({
        url: API_BASE_URL + "/transports/add",
        method: 'POST',
        body: JSON.stringify(transportRequest)
    });
}

export function addRoute(routeRequest) {
    return request({
        url: API_BASE_URL + "/routes/add",
        method: 'POST',
        body: JSON.stringify(routeRequest)
    });
}

export function joinRoute(route_id, user_id) {
    return request({
        url: API_BASE_URL + "/routes/" + route_id + "/join/" + user_id,
        method: 'POST',
        // body: JSON.stringify(user)
    });
}

export function updateRoute(input_id, routeRequest) {
    return request({
        url: API_BASE_URL + "/routes/" + input_id + "/update",
        method: 'POST',
        body: JSON.stringify(routeRequest)
    });
}

export function updateTransport(input_id, transportRequest) {
    return request({
        url: API_BASE_URL + "/transports/" + input_id + "/update",
        method: 'POST',
        body: JSON.stringify(transportRequest)
    });
}

export function deleteRoute(input_id) {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }
    return request({
        url: API_BASE_URL + "/routes/" + input_id + "/delete",
        method: 'DELETE'
        // body: JSON.stringify(routeRequest)
    });
}

export function deleteTransport(input_id) {
    if(!localStorage.getItem(ACCESS_TOKEN)) {
        return Promise.reject("No access token set.");
    }
    return request({
        url: API_BASE_URL + "/transports/" + input_id + "/delete",
        method: 'DELETE'
        // body: JSON.stringify(routeRequest)
    });
}

export function signup(signupRequest) {
    return request({
        url: API_BASE_URL + "/auth/signup",
        method: 'POST',
        body: JSON.stringify(signupRequest)
    });
}


export function getTransport() {
    return request({
        url: API_BASE_URL + "/transports/all",
        method: 'GET'
    });
}

export function getCurrentTransport(input_id) {
    return request({
        url: API_BASE_URL + "/transports/" + input_id,
        method: 'GET'
    });
}

export function getCurrentRoute(input_id) {
    return request({
        url: API_BASE_URL + "/routes/" + input_id,
        method: 'GET'
    });
}

export function getTypes() {
    return request({
        url: API_BASE_URL + "/types/all",
        method: 'GET'
    });
}

export function getType(input_id) {
    return request({
        url: API_BASE_URL + "/types/" + input_id,
        method: 'GET'
    });
}