import React from 'react';
import Route from './Route';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

class Routes extends React.Component {

    render() {
        return (
            <div className="container row">
                {/* список маршрутов */}
                <Route />
                <Route />
                <div className="card addCard">
                    <FontAwesomeIcon icon={faPlus} size="8x" />
                </div>
            </div>
        );
    }
}

export default Routes;