import React from 'react';
import RouteComponent from './RouteComponent';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlus } from '@fortawesome/free-solid-svg-icons';
import CommonRequests from '../../requests/commonRequests';

class Routes extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      routes: null,
    }
  }

  componentDidMount() {
    CommonRequests.getAllRoutes()
      .then(res => {
        this.setState({ routes: res })
      });
  }

  componentWillMount() {
    CommonRequests.getAllRoutes()
      .then(res => {
        this.setState({ routes: res })
      });
  }

  update = (input_id) => {
    CommonRequests.deleteRoute(input_id)
      .then(res => {
        this.setState({ routes: res})
      });
  }

  getArr(arr) {
    if (arr) {
      return arr.map((el) => <RouteComponent
        departureAddress={el.departureAddress.country + ' ' + el.departureAddress.city}
        arrivalAddress={el.arrivalAddress.country + ' ' + el.arrivalAddress.city}
        id={el.id} depDateTime={el.departureDateTime}
        arrDateTime={el.arrivalDateTime}
        freeSeats={el.freeSeats}
        transportName={el.transport.name}
        transportType={el.transport.type.description}
        update={this.update}
        {...this.props}
        join/>);
    }
  }


  render() {
    if (this.state.routes) {
      var { routes } = this.state;
    }
    return (
      <div className="container row">
        {this.getArr(routes)}
     
        <div onClick={(e) => { this.props.history.push('/routes/add'); }} className="card addCard">
          <FontAwesomeIcon icon={faPlus} size="8x" />
        </div>
      </div>
    );
  }
}

export default Routes;