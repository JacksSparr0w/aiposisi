import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'

class Route extends React.Component {

    render() {
        return (
            <div className="d-flex justify-content-around">
                <p>Transport name</p>
                <p> Transport type</p>
                <p>Departure address, date</p>
                <p>Arrival address, date</p>
                <p>actions</p>
                <i class="fas fa-trash-alt"></i>
                <FontAwesomeIcon icon={['fab', 'apple']} />
                <FontAwesomeIcon icon="check-square" />
                <FontAwesomeIcon icon="coffee" />
            </div>
        );
    }
}

export default Route;