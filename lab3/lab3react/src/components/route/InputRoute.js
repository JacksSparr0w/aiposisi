import React from 'react';
import 'moment/locale/it.js';
import { DatePicker, DatePickerInput } from 'rc-datepicker';
import 'rc-datepicker/lib/style.css';
import CommonRequests from '../../requests/commonRequests';

class InputRoute extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            transports: null,
            transport: null,
            depCountry: null,
            depCity: null,
            depStreet: null,
            depNumber: null,
            arrCountry: null,
            arrCity: null,
            arrStreet: null,
            arrNumber: null,
            depDateTime: null,
            arrDateTime: null,
        }
    }

    componentDidMount() {
        CommonRequests.getAllTransports()
            .then(res => {
                if (this.props.match.params.id) {
                CommonRequests.getRoute(this.props.match.params.id)
                .then(result => {
                    this.setState({ transports: res, route: result, transport: result.transport, 
                        depCountry: result.departureAddress.country, depCity: result.departureAddress.city, 
                        depStreet: result.departureAddress.street, depNumber: result.departureAddress.number, 
                        arrCountry: result.arrivalAddress.country, arrCity: result.arrivalAddress.city,
                        arrStreet: result.arrivalAddress.street, arrNumber: result.arrivalAddress.number, 
                        depDateTime: result.departureDateTime, arrDateTime: result.arrivalDateTime})
                })
            } else this.setState({ transports: res })
            });
    }

    getArr(arr) {
        if (arr) {
            return arr.map((el) => <option value={el.id}>{el.name}, {el.type.description}</option>
            );
        }
    }


    depCountryChange(event) {
        this.setState({ depCountry: event.target.value })
    }
    arrCountryChange(event) {
        this.setState({ arrCountry: event.target.value })
    }

    depCityChange(event) {
        this.setState({ depCity: event.target.value })
    }
    arrCityChange(event) {
        this.setState({ arrCity: event.target.value })
    }

    depStreetChange(event) {
        this.setState({ depStreet: event.target.value })
    }
    arrStreetChange(event) {
        this.setState({ arrStreet: event.target.value })
    }

    depNumberChange(event) {
        this.setState({ depNumber: event.target.value })
    }
    arrNumberChange(event) {
        this.setState({ arrNumber: event.target.value })
    }

    depDateChange = (date) => {
        this.setState({ depDateTime: date })
    }
    arrDateChange = (date) => {
        this.setState({ arrDateTime: date })
    }

    transportChange(event) {
        CommonRequests.getTransport(event.target.value)
            .then(res => {
                this.setState({ transport: res })
            })
    }

    onclick() {
        if (this.props.match.params.id) {
            CommonRequests.updateRoute(this.props.match.params.id, this.state.depCountry, this.state.depCity, this.state.depStreet, this.state.depNumber, this.state.arrCountry, this.state.arrCity, this.state.arrStreet, this.state.arrNumber, this.state.depDateTime, this.state.arrDateTime, this.state.transport);
        } else CommonRequests.addRoute(this.state.depCountry, this.state.depCity, this.state.depStreet, this.state.depNumber, this.state.arrCountry, this.state.arrCity, this.state.arrStreet, this.state.arrNumber, this.state.depDateTime, this.state.arrDateTime, this.state.transport);
        window.location.assign('/routes');
    }

    render() {
        if (this.state.transports) {
            var { transports } = this.state;
        }
        return (
            <div className="container">
                <form method="post">
                    <div className="container p-2">
                        <div className="input-group mb-3">
                            <div className="input-group-prepend">
                                <label className="input-group-text" for="inputType">Transport</label>
                            </div>
                            <select onInput={this.transportChange.bind(this)} className="custom-select" id="inputType">
                                <option selected>Choose...</option>
                                {this.getArr(transports)}
                            </select>
                        </div>

                        <div className="row">
                            <div className="col-6">
                                <div className="container">
                                    <label>Departure address</label>
                                    <div className="input-group mb-3">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text" id="country">Country</span>
                                        </div>
                                        <input type="text" onInput={this.depCountryChange.bind(this)} className="form-control" aria-label="Country" aria-describedby="country" />
                                    </div>
                                    <div className="input-group mb-3">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text" id="city">City</span>
                                        </div>
                                        <input type="text" onInput={this.depCityChange.bind(this)} className="form-control" aria-label="city" aria-describedby="city" />
                                    </div>
                                    <div className="input-group mb-3">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text" id="street">Street</span>
                                        </div>
                                        <input type="text" onInput={this.depStreetChange.bind(this)} className="form-control" aria-label="street" aria-describedby="street" />
                                    </div>
                                    <div className="input-group mb-3">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text" id="number">Number</span>
                                        </div>
                                        <input type="text" onInput={this.depNumberChange.bind(this)} className="form-control" aria-label="number" aria-describedby="number" />
                                    </div>
                                </div>
                                <div className="input-group mb-3 ml-3">
                                    <DatePickerInput
                                        onChange={this.depDateChange.bind(this)}
                                        minDate={new Date()}
                                        className='my-custom-datepicker-component'
                                    />
                                </div>

                            </div>
                            <div className="col-6">
                                <div className="container">
                                    <label>Arrival address</label>
                                    <div className="input-group mb-3">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text" id="arrcountry">Country</span>
                                        </div>
                                        <input type="text" onInput={this.arrCountryChange.bind(this)} className="form-control" aria-label="Country" aria-describedby="arrcountry" />
                                    </div>
                                    <div className="input-group mb-3">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text" id="arrcity">City</span>
                                        </div>
                                        <input type="text" onInput={this.arrCityChange.bind(this)} className="form-control" aria-label="city" aria-describedby="arrcity" />
                                    </div>
                                    <div className="input-group mb-3">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text" id="arrstreet">Street</span>
                                        </div>
                                        <input type="text" onInput={this.arrStreetChange.bind(this)} className="form-control" aria-label="street" aria-describedby="arrstreet" />
                                    </div>
                                    <div className="input-group mb-3">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text" id="arrnumber">Number</span>
                                        </div>
                                        <input type="text" onInput={this.arrNumberChange.bind(this)} className="form-control" aria-label="number" aria-describedby="arrnumber" />
                                    </div>
                                </div>
                                <div className="input-group mb-3 ml-3">
                                    <DatePickerInput
                                        onChange={this.arrDateChange.bind(this)}
                                        minDate={new Date()}
                                        className='my-custom-datepicker-component'
                                    />
                                </div>
                            </div>
                        </div>


                        <button className="btn btn-outline-success p-2"  onClick={(e) => { this.onclick(); }} type="button">Save</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default InputRoute;