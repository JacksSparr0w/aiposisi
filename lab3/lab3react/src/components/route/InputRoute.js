import React from 'react';
import InputAddress from './InputAddress'

class InputRoute extends React.Component {
    render() {
        return (
            <div className="container">
                <form method="post">
                    <div className="container p-2">
                        <div className="input-group mb-3">
                            <div className="input-group-prepend">
                                <label className="input-group-text" for="inputType">Transport</label>
                            </div>
                            <select className="custom-select" id="inputType">
                                <option selected>Choose...</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>

                        <div classNameName="row">
                            <div classNameName="col-6">
                                <InputAddress/>
                            </div>
                            <div classNameName="col-6">
                                <InputAddress/>
                            </div>
                        </div>
                        <div className="input-group mb-3">
                            <label>Choose date...</label>
                        </div>
                        <button className="btn btn-outline-success p-2" type="submit">Save</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default InputRoute;