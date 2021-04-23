import React from 'react';
import DocsComponent from "./DocsComponent";
import { Button } from '@material-ui/core';



class UploadComponent extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            showComponent: false,
            value : false
        };
        this._onButtonClick = this._onButtonClick.bind(this);
    }

    _onButtonClick() {
        this.setState({
            showComponent: true,
            value : !this.state.value
        });
    }




    render (){

       return (
           <div>
            <Button onClick={this._onButtonClick}>
               Upload data
            </Button>
                 {this.state.showComponent ?
                   <DocsComponent update ={this.state.value} /> :
                   null
               }
           </div>
        );
    }
}

export  default UploadComponent