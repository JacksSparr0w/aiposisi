import React from 'react';
import Route from './Route';

class Routes extends React.Component {

    render() {
        return (
            <div className="container row">
                {/* список маршрутов */}
                <Route/>
                <Route/>
            </div>
        );
    }
}

export default Routes;