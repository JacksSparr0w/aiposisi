import React from 'react';
import './App.css';
import Home from './components/Home';
import LoginMy from './components/Login';
import Routes from './components/route/Routes';
import MyRoutes from './components/route/MyRoutes';
import TransportList from './components/transport/TransportList';
import InputTransport from './components/transport/InputTransport';
import InputRoute from './components/route/InputRoute';
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import AppHeader from './common/AppHeader';
import Login from './user/login/Login';
import Signup from './user/signup/Signup';
import Profile from './user/profile/Profile';
import OAuth2RedirectHandler from './user/oauth2/OAuth2RedirectHandler';
import NotFound from './common/NotFound';
import LoadingIndicator from './common/LoadingIndicator';
import { getCurrentUser } from './util/APIUtils';
import { ACCESS_TOKEN } from './constants';
import PrivateRoute from './common/PrivateRoute';
import Alert from 'react-s-alert';
import 'react-s-alert/dist/s-alert-default.css';
import 'react-s-alert/dist/s-alert-css-effects/slide.css';

class App extends React.Component {
    constructor(props) {
      super(props);
      this.state = {
        authenticated: false,
        currentUser: null,
        loading: false
      }
  
      this.loadCurrentlyLoggedInUser = this.loadCurrentlyLoggedInUser.bind(this);
      this.handleLogout = this.handleLogout.bind(this);
    }
  
    loadCurrentlyLoggedInUser() {
      this.setState({
        loading: true
      });
  
      getCurrentUser()
      .then(response => {
        this.setState({
          currentUser: response,
          authenticated: true,
          loading: false
        });
      }).catch(error => {
        this.setState({
          loading: false
        });  
      });    
    }
  
    handleLogout() {
      localStorage.removeItem(ACCESS_TOKEN);
      this.setState({
        authenticated: false,
        currentUser: null
      });
      Alert.success("You're safely logged out!");
    }
  
    componentDidMount() {
      this.loadCurrentlyLoggedInUser();
    }
  
    render() {
      if(this.state.loading) {
        return <LoadingIndicator />
      }
  
  return (
      <div className="App">
        <header className="App-header">
        <AppHeader authenticated={this.state.authenticated} onLogout={this.handleLogout} />
          <div className="d-flex justify-content-around">
            <Link type="button" to='/routes' className="btn btn-primary m-3">Routes</Link>
            <Link type="button" to='/transports' className="btn btn-primary m-3">Transports</Link>
            {/* <Link type="button" to='/users/login' className="btn btn-primary m-3">My Routes</Link> */}
          </div>
          <Switch>
          <Route path="/" exact component={Home} />
          <Route strict path="/routes" exact component={Routes} />
          <Route strict path="/transports" exact component={TransportList}/>
          <PrivateRoute path="/routes/add" authenticated={this.state.authenticated}  exact component={InputRoute}> </PrivateRoute>
          <PrivateRoute strict path="/routes/:id/join" authenticated={this.state.authenticated}  exact component={LoginMy} > </PrivateRoute>
          {/* <Route path="/users/login" exact component={LoginMy} />
          
          <Route path="/users/:login/watchRoutes" exact component={MyRoutes} /> */}
          <PrivateRoute path="/transports/add" authenticated={this.state.authenticated}  exact component={InputTransport}> </PrivateRoute>

          <PrivateRoute path="/transports/:id/update" authenticated={this.state.authenticated} exact component={InputTransport} > </PrivateRoute>
          <PrivateRoute path="/routes/:id/update" authenticated={this.state.authenticated} exact component={InputRoute} > </PrivateRoute>
            <PrivateRoute path="/profile" authenticated={this.state.authenticated} currentUser={this.state.currentUser}
              component={Profile}></PrivateRoute>
            <Route path="/login"
              render={(props) => <Login authenticated={this.state.authenticated} {...props} />}></Route>
            <Route path="/signup"
              render={(props) => <Signup authenticated={this.state.authenticated} {...props} />}></Route>
            <Route path="/oauth2/redirect" component={OAuth2RedirectHandler}></Route>  
            <Route component={NotFound}></Route>
            </Switch>
        </header>
        <Alert stack={{limit: 3}} 
          timeout = {3000}
          position='top-right' effect='slide' offset={65} />
      </div>
  )
    }
  ;
}

export default App;
