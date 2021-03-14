import React from 'react';

import PropTypes from 'prop-types';
import { withRouter } from 'react-router';
import axios from 'axios';

const Person = (props) => {

    const get = () => {
        return axios.get('/persons')
            .then(res => console.log(res));
    }
    
    const post = () => {
        
        return axios.post('/persons', {
            name :"asdga",
            age : 243
        }).then(res => console.log(res));
    }

    return (
        <div>
            <button onClick = {get}>get</button>
            <button onClick = {post}>post</button>
        </div> 
    );
}

export default Person;