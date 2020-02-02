import React from 'react';

class InputTransport extends React.Component {
  render() {
    return (
    <div className="container">
    <form method="post">
        <div className="container p-2">
            <div className="input-group mb-3">
                <div className="input-group-prepend">
                    <label className="input-group-text" for="inputType">Type</label>
                </div>
                <select className="custom-select" id="inputType">
                    <option selected>Choose...</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </select>
            </div>

            <div className="input-group mb-3">
                <div className="input-group-prepend">
                    <span className="input-group-text" id="name">Name</span>
                </div>
                    <input type="text" className="form-control" aria-label="Name" aria-describedby="name" value="name"/>
            </div>
            <div className="input-group mb-3">
                <div className="input-group-prepend">
                    <span className="input-group-text" id="capacity">Capacity</span>
                </div>
                    <input type="number" min="0" className="form-control" aria-label="Capacity" aria-describedby="capacity" value="capacity"/>
            </div>
            <button className="btn btn-outline-success p-2" type="submit">Save</button>
        </div>
    </form>
    </div>
    );
  }
}

export default InputTransport;