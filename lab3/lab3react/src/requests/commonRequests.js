import asyncAPI from '../api'

const getAllRoutes = () => {
    return asyncAPI('getJSON', {
        url: `/routes/all/`,
    })
}

const deleteRoute = (input_route_id) => {
    return asyncAPI('deleteJSON', {
        url: `/routes/` + input_route_id + `/delete`,
    })
}

const getAllTypes = () => {
    return asyncAPI('getJSON', {
        url: `/types/all/`,
    })
}

const getAllTransports = () => {
    return asyncAPI('getJSON', {
        url: `/transports/all/`,
    })
}

const deleteTransport = (input_transport_id) => {
    return asyncAPI('deleteJSON', {
        url: `/transports/` + input_transport_id + `/delete`,
    })
}

const updateTransport = (input_id, input_type, input_capacity, input_name) => {
    const action = {
        type: input_type,
        capacity: input_capacity,
        name: input_name,        
    }
    return asyncAPI('postJSON', {
        url: `/transports/`+ input_id + '/update',
        data: action,
    })
}

const addTransport = (input_type, input_capacity, input_name) => {
    const action = {
        type: input_type,
        capacity: input_capacity,
        name: input_name,        
    }
    return asyncAPI('postJSON', {
        url: `/transports/add`,
        data: action,
    })
}

const watchUserRoutes = (input_login) => {
    const action = {
        login: input_login,       
    }
    return asyncAPI('postJSON', {
        url: `/users/watchRoutes`,
        data: action,
    })
}

const addRoute = (input_d_country, input_d_city, input_d_street, input_d_number, input_country, input_city, input_street, input_number, input_d_date_time, input_date_time, input_transport) => {
    const action = {
        departureAddress: {
            country: input_d_country,
            city: input_d_city,
            street: input_d_street,
            number: input_d_number,
        },
        arrivalAddress: {
            country: input_country,
            city: input_city,
            street: input_street,
            number: input_number,
        },
        departureDateTime: input_d_date_time,
        arrivalDateTime: input_date_time,
        transport : input_transport       
    }
    return asyncAPI('postJSON', {
        url: `/transports/add`,
        data: action,
    })
}

const joinRoute = (input_route, input_login) => {
    const action = {
        login: input_login,       
    }
    return asyncAPI('postJSON', {
        url: `/routes/` + input_route + '/join',
        data: action,
    })
}


export default {
    watchUserRoutes,
    deleteRoute,
    deleteTransport, 
    getAllRoutes,
    getAllTransports, 
    getAllTypes, 
    addTransport, 
    addRoute, 
    updateTransport,
    joinRoute
}
