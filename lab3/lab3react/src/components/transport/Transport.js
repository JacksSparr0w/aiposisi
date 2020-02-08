import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faEdit } from '@fortawesome/free-solid-svg-icons';
import CommonRequests from '../../requests/commonRequests';

class Transport extends React.Component {
    constructor(props) {
        super(props);
        this.state = {}
      }

    render() {
        const { update } = this.props;
        return (
            <div className="card d-flex justify-content-around">
                <h4>{this.props.name}</h4>
                <h6>{this.props.type}</h6>
                <strong>Capacity: {this.props.capacity}</strong>

                <div className="d-flex justify-content-around mb-2">
                <FontAwesomeIcon icon={faTrash}  onClick={() => {
                    update(this.props.id);
                }}/>

                <FontAwesomeIcon icon={faEdit} onClick={() => {this.props.history.push('/transports/' + this.props.id + '/update');  }}/>
                </div>
            </div>
        );
    }
}

export default Transport;