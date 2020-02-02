import React from 'react';

class Login extends React.Component {
  render() {
    return (
    <div className="container">
    <form method="post">
        <div>
            <div className="input-group mb-3">
                <div className="input-group-prepend">
                    <span className="input-group-text" id="name">Name</span>
                </div>
                    <input type="text" className="form-control" placeholder="Name" aria-label="Name" aria-describedby="name" value="name"/>
            </div>
        </div>
        <button className="btn btn-outline-success p-2" type="submit">Сохранить</button>
    </form>
    </div>
    );
  }
}

export default Login;