import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faTrash } from '@fortawesome/free-solid-svg-icons';
import { faEdit } from '@fortawesome/free-solid-svg-icons';
import CommonRequests from '../../requests/commonRequests';
import { BrowserRouter as Link } from "react-router-dom";

class RouteComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {}
    }

    // onclick(){
    //     CommonRequests.getAllRoutes()
    //     .then(res => {
    //       this.setState({ routes: res})
    //     });
    // }

    getOpportunities() {
        if (this.props.join == true) {
            return <div>

                <div className="d-flex justify-content-around mb-4">
                    <FontAwesomeIcon className="m-2" icon={faTrash} onClick={(e) => { 
                        CommonRequests.deleteRoute(this.props.id);
                        this.props.update();
                    }} />
                    <button type="button" onClick={(e) => { window.location.assign('/routes/' + this.props.id + '/join'); }} className="btn btn-primary">Join</button>
                    
                    {/* <Link type="button" to="/routes/${this.props.id}/join" className="btn btn-primary m-3">Join</Link> */}
                    <FontAwesomeIcon className="m-2" icon={faEdit} onClick={(e) => {window.location.assign('/routes/' + this.props.id + '/update');  }}/>
                </div>
                </div>
        }
    }

    formatDate(date) {
		if (date != null) {
			var monthNames = [
				"January", "February", "March",
				"April", "May", "June", "July",
				"August", "September", "October",
				"November", "December"
			];

			var day = date.getDate();
			var monthIndex = date.getMonth();
			var year = date.getFullYear();

			return day + ' ' + monthNames[monthIndex] + ' ' + year;
		}
	}

    render() {
        return (
            <div className="card d-flex justify-content-around">
                <h4>{this.props.transportName}</h4>
                <h6>{this.props.transportType}</h6>
                <h4>From: {this.props.departureAddress}</h4> 
                <h6>{this.formatDate(new Date(this.props.depDateTime))}</h6>
                <h4>To: {this.props.arrivalAddress}</h4>
                <h6>{this.formatDate(new Date(this.props.arrDateTime))}</h6>
                <strong>Free seats: {this.props.freeSeats}</strong>

                {this.getOpportunities()}

            </div>
        );
    }
}

export default RouteComponent;