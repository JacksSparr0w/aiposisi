import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faEdit } from '@fortawesome/free-solid-svg-icons';

class Transport extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
        }
      }

    render() {
        return (
            <div className="card d-flex justify-content-around">
                <p>{this.props.name}</p>
                <p>{this.props.type}</p>
                <p>{this.props.capacity}</p>

                <div className="d-flex justify-content-around mb-2">
                <FontAwesomeIcon icon={faTrash} />
                <FontAwesomeIcon icon={faEdit} />
                </div>
            </div>
        );
    }
}

export default Transport;