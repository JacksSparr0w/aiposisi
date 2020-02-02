import React from 'react';

class Transport extends React.Component {

    render() {
        return (
            <div className="card d-flex justify-content-around">
                <p>Transport name</p>
                <p> Transport type</p>
                <p>Capacity</p>
                <p>actions</p>
            </div>
        );
    }
}

export default Transport;