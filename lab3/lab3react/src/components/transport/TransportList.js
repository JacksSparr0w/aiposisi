import React from 'react';
import Transport from './Transport';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

class TransportList extends React.Component {

    render() {
        return (
            <div className="container row">
                {/* список  транспорта*/}
                <Transport/>
                <Transport/>

                <div className="card addCard">
                    <FontAwesomeIcon icon={faPlus} size="8x" />
                </div>

            </div>
        );
    }
}

export default TransportList;