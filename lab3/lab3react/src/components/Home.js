import React from 'react';

class Home extends React.Component {

    render() {
        return (
            <div>
            <label>Welcome!</label>
            <div className="d-flex justify-content-around">
                <button type="button" onClick={(e) => { window.location.assign('/routes'); }} className="btn btn-primary m-3">Routes</button>
                <button type="button" onClick={(e) => { window.location.assign('/transports'); }} className="btn btn-primary m-3">Transport</button>
            </div>
            </div>

        );
    }
}

export default Home;