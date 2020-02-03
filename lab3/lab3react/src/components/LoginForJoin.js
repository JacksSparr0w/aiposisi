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

  render() {
    return (
    <div className="container">
    <form method="post">
        <div>
            <div className="input-group mb-3">
                <div className="input-group-prepend">
                    <span className="input-group-text" id="name">Login</span>
                </div>
                    <input type="text"  onInput={this.loginChange.bind(this)} className="form-control" placeholder="Name" aria-label="Name" aria-describedby="name"/>
            </div>
        </div>
        <button className="btn btn-outline-success p-2" onClick={(e) => {CommonRequests.joinRoute(this.props.match.params.id, this.state.login); window.location.assign('/routes'); }} type="button">Сохранить</button>
    </form>
    </div>
    );
  }
}

export default Login;