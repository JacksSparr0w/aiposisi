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
        this.setState({ routes: res})
      });
  }

  componentWillUpdate() {
    CommonRequests.getAllRoutes()
      .then(res => {
        this.setState({ routes: res})
      });
  }

  //передавать функцию для удаления и апдейта

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
        join />);
    }
  }


  render() {
    if (this.state.routes) {
      var { routes } = this.state;
    }
    return (
      <div className="container row">
        {this.getArr(routes)}
        {/* {routes.map(el => (
                   <Route
                    key={el.id}
                    departureAddress={el.departureAddress.country + ' ' + el.departureAddress.city}
                    arrivalAddress={el.arrivalAddress.country + ' ' + el.arrivalAddress.city}
                    id={el.id}
                    depDateTime={el.departureDateTime}
                    arrDateTime={el.arrivalDateTime}
                    freeSeats={el.freeSeats}
                    transportName={el.transport.name}
                    transportType={el.transport.type.description}
                    join
                  />
                ))} */}
        <div onClick={(e) => { window.location.assign('/routes/add'); }} className="card addCard">
          <FontAwesomeIcon icon={faPlus} size="8x" />
        </div>
      </div>
    );
  }
}

export default Routes;