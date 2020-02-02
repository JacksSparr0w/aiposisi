import React from 'react';

class InputAddress extends React.Component {
    render() {
        return (
            <div className="container">
                <label>Departure address</label>

                <div className="input-group mb-3">
                    <div className="input-group-prepend">
                        <span className="input-group-text" id="country">Country</span>
                    </div>
                        <input type="text" className="form-control" aria-label="Country" aria-describedby="country" value="country"/>
                </div>
                <div className="input-group mb-3">
                    <div className="input-group-prepend">
                        <span className="input-group-text" id="city">City</span>
                    </div>
                        <input type="text" className="form-control" aria-label="city" aria-describedby="city" value="city"/>
                </div>
                <div className="input-group mb-3">
                    <div className="input-group-prepend">
                        <span className="input-group-text" id="street">Street</span>
                    </div>
                        <input type="text" className="form-control" aria-label="street" aria-describedby="street" value="street"/>
                </div>
                <div className="input-group mb-3">
                    <div className="input-group-prepend">
                        <span className="input-group-text" id="number">Number</span>
                    </div>
                        <input type="text" className="form-control" aria-label="number" aria-describedby="number" value="number"/>
                </div>
            </div>
        );
    }
}

export default InputAddress;