

const { stringify } = JSON

const headers = {
    credentials: 'include',
    'Content-type': 'application/json',
    Accept: 'application/json;charset=UTF-8',
    'Access-Control-Allow-Origin': '*',
}

headers.Authorization = 'Basic '// + authdata

 const apiPathUrl = 'https://localhost:8443';

const getFullUrl = (url, params) =>
    apiPathUrl + (url || '') + (params ? '?' + queryParams(params) : '')

function queryParams(params) {
    return Object.keys(params)
        .map(k => encodeURIComponent(k) + '=' + encodeURIComponent(params[k]))
        .join('&')
}

const credentials = 'same-origin'

const async = {
    getJSON({ url, params}) {
        return fetch(getFullUrl(url, params), {
            headers,
            credentials,
        })
    },
    postJSON({ url, data, params, options = {} }) {
        console.log(stringify(data));
        return fetch(getFullUrl(url, params), {
            ...options,
            headers,
            credentials,
            method: 'POST',
            body: stringify(data),
            mode: 'cors',
        });
    },
    deleteJSON({ url, data, options = {} }) {
        return fetch(getFullUrl(url), {
            ...options,
            headers,
            credentials,
            method: 'DELETE',
            body: stringify(data),
        })
    },
}

export default (method, ...args) => {
    return async[method](...args)
        .then(response => {
            if (method === 'getJSON') {
                return response.json()
            }
            return response.json()
        })
        .catch(error => {
           // throwNotification('error', 'Серверная ошибка')
        })
}
