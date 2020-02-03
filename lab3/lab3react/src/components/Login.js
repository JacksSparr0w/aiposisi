import React from 'react';
import CommonRequests from '../requests/commonRequests';

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            login: null,
        }
    }

    loginChange(event) {
        this.setState({ login: event.target.value })
    }

    onclick() {
        CommonRequests.existByLogin(this.state.login)
        .then(res => {
            if (res == true) {
                window.location.assign('/users/' + this.state.login + '/watchRoutes');
            } else {
                window.location.assign('/');
            }
          });
        
    }

    render() {
        return (
            <div className="container">
                <form method="post">
                    <div>
                        <div className="input-group mb-3">
                            <div className="input-group-prepend">
                                <span className="input-group-text" id="name">Login</span>
                            </div>
                            <input type="text" onInput={this.loginChange.bind(this)} className="form-control" placeholder="Name" aria-label="Name" aria-describedby="name" />
                        </div>
                    </div>
                    <button className="btn btn-outline-success p-2" onClick={(e) => {this.onclick()} } type="button">Watch</button>
                </form>
            </div>
        );
    }
}

export default Login;