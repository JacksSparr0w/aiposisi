import React from 'react';
import Transport from './Transport';

class TransportList extends React.Component {

    render() {
        return (
            <div className="container row">
                {/* список  транспорта*/}
                <Transport/>
                <Transport/>
            </div>
        );
    }
}

export default TransportList;