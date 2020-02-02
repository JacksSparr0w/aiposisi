import React from 'react';
import Transport from './Transport';
import CommonRequests from '../../requests/commonRequests';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faPlus } from '@fortawesome/free-solid-svg-icons';

class TransportList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
          transports: null,
        }
      }
    
      componentDidMount() {
        CommonRequests.getAllTransports()
          .then(res => {
            this.setState({ transports: res})
          });
      }
    
      getArr(arr) {
        if (arr) {
          return arr.map((el) => <Transport name={el.name} capacity={el.capacity} id={el.id} type={el.type.description} />);
        }
      }


    render() {
        if (this.state.transports){
			var {transports} = this.state;
		}
        return (
            <div className="container row">
                {this.getArr(transports)}

                <div className="card addCard">
                    <FontAwesomeIcon icon={faPlus} size="8x" />
                </div>

            </div>
        );
    }
}

export default TransportList;