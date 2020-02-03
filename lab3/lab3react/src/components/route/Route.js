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

    getOpportunities() {
        if (this.props.join == true) {
            return <div>
                <button type="button" onClick={(e) => { window.location.assign('/routes/' + this.props.id + '/join'); }} className="btn btn-primary m-3">Join</button>

                <div className="d-flex justify-content-around mb-2">
                    <FontAwesomeIcon icon={faTrash} onClick={(e) => { CommonRequests.deleteRoute(this.props.id) }} />
                    <FontAwesomeIcon icon={faEdit} onClick={(e) => {window.location.assign('/routes/' + this.props.id + '/update');  }}/>
                </div>
                </div>
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

                {this.getOpportunities()}

            </div>
        );
    }
}

export default Route;