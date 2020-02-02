import React from 'react';
import InputAddress from './InputAddress'
// import 'moment/locale/it.js';
// import { DatePicker, DatePickerInput } from 'rc-datepicker';
// import 'rc-datepicker/lib/style.css';

class InputRoute extends React.Component {
    render() {
        return (
            <div className="container">
                <form method="post">
                    <div className="container p-2">
                        <div className="input-group mb-3">
                            <div className="input-group-prepend">
                                <label className="input-group-text" for="inputType">Transport</label>
                            </div>
                            <select className="custom-select" id="inputType">
                                <option selected>Choose...</option>
                                <option value="1">One</option>
                                <option value="2">Two</option>
                                <option value="3">Three</option>
                            </select>
                        </div>

                        <div className="row">
                            <div className="col-6">
                                <InputAddress/>
                                {/* <DatePickerInput
                                onChange={this.dateChange.bind(this)}
                                minDate={new Date()}
                                className='my-custom-datepicker-component'
                            /> */}
                            </div>
                            <div className="col-6">
                                <InputAddress/>
                            </div>
                        </div>
                        <div className="input-group mb-3">
                            <label>Choose date...</label>
                        </div>
                        <button className="btn btn-outline-success p-2" type="submit">Save</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default InputRoute;