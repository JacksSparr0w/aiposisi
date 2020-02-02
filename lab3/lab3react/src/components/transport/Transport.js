import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faEdit } from '@fortawesome/free-solid-svg-icons';

class Transport extends React.Component {

    render() {
        return (
            <div className="card d-flex justify-content-around">
                <p>Transport name</p>
                <p> Transport type</p>
                <p>Capacity</p>

                <div className="d-flex justify-content-around mb-2">
                <FontAwesomeIcon icon={faTrash} />
                <FontAwesomeIcon icon={faEdit} />
                </div>
            </div>
        );
    }
}

export default Transport;