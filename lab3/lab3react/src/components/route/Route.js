import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faEdit } from '@fortawesome/free-solid-svg-icons';
import CommonRequests from '../../requests/commonRequests';

class Route extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
        }
      }
      
    render() {
        return (
            <div className="card d-flex justify-content-around">
                <p>{this.props.transportName}</p>
                <p>{this.props.transportType}</p>
                <p>{this.props.departureAddress}, {this.props.depDateTime}</p>
                <p>{this.props.arrivalAddress}, {this.props.arrDateTime}</p>
                <p>{this.props.freeSeats}</p>


                <div className="d-flex justify-content-around mb-2">
                <FontAwesomeIcon icon={faTrash}  onClick={(e) => {CommonRequests.deleteRoute(this.props.id) }}/>
                <FontAwesomeIcon icon={faEdit} />
                </div>
            </div>
        );
    }
}

export default Route;