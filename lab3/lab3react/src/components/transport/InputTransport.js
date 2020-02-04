import React from 'react';
import CommonRequests from '../../requests/commonRequests';
import { BrowserRouter as Link } from "react-router-dom";


class InputTransport extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            types: null,
            capacity: null,
            type: null,
            name: null,
            transport: null,
        }
    }

    componentDidMount() {
        CommonRequests.getAllTypes()
            .then(res => {
                if (this.props.match.params.id) {
                    CommonRequests.getTransport(this.props.match.params.id)
                        .then(result => {
                            this.setState({ types: res, transport: result, capacity: result.capacity, type: result.type, name: result.name })
                        })
                } else this.setState({ types: res })
            });
    }


    typeChange(event) {
        CommonRequests.getType(event.target.value)
            .then(res => {
                this.setState({ type: res })
            })
    }


    nameChange(event) {
        this.setState({ name: event.target.value })
    }

    capacityChange(event) {
        this.setState({ capacity: event.target.value })
    }

    getArr(arr) {
        if (arr) {
            return arr.map((el) => <option value={el.id}>{el.description}</option>
            );
        }
    }

    onclick() {
        if (this.props.match.params.id != null) {
            CommonRequests.updateTransport(this.props.match.params.id, this.state.type, this.state.capacity, this.state.name);

        } else CommonRequests.addTransport(this.state.type, this.state.capacity, this.state.name);

       // window.location.assign('/transports');
    }

    render() {
        if (this.state.types) {
            var { types } = this.state;
        }
        return (
            <div className="container">
                <form method="post">
                    <div className="container p-2">
                        <div className="input-group mb-3">
                            <div className="input-group-prepend">
                                <label className="input-group-text" htmlFor="inputType">Type</label>
                            </div>
                            <select onInput={this.typeChange.bind(this)} className="custom-select" id="inputType">
                                <option selected>Choose...</option>
                                {this.getArr(types)}
                            </select>
                        </div>

                        <div className="input-group mb-3">
                            <div className="input-group-prepend">
                                <span className="input-group-text" id="name">Name</span>
                            </div>
                            <input onInput={this.nameChange.bind(this)} type="text" className="form-control" aria-label="Name" aria-describedby="name" />
                        </div>
                        <div className="input-group mb-3">
                            <div className="input-group-prepend">
                                <span className="input-group-text" id="capacity">Capacity</span>
                            </div>
                            <input type="number" min="0" onInput={this.capacityChange.bind(this)} className="form-control" aria-label="Capacity" aria-describedby="capacity" />
                        </div>
                        {/* <Link type="button" to='/transports' className="btn btn-outline-success p-2" onClick={this.onclick()} > Save </Link> */}

                        <button className="btn btn-outline-success p-2" onClick={(e) => { this.onclick(); }} type="button">Save</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default InputTransport;