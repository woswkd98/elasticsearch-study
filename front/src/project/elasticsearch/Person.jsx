import React, {useState} from 'react';

import PropTypes from 'prop-types';
import { withRouter } from 'react-router';
import axios from 'axios';

const Person = (props) => {


    const [name, setName] = useState('');
    const [age, setAge] = useState('');
    const [inquiry, setInquiry] = useState('')
    const [area, setArea] = useState('');

    
    const get = () => {
        return axios.get('/persons')
            .then(res => console.log(res));
    }
    
    const post = () => {
        
        return axios.post('/persons', {
            name :name,
            age : age,
            inquiry : inquiry,
            area : area
        }).then(res => console.log(res));
    }

    const getByUserNameAndAge =()=> {
        return axios.get('/persons/'+ age)
            .then(res => console.log(res));
    }

    return (
        <div>
           
                이름: <input
                    type="name"
                    name="name"
                    value={name}
                    onChange={e => setName(e.target.value)}
                    required
                />
                <br></br>
               age: <input
                    type="age"
                    name="age"
                    value={age}
                    onChange={e => setAge(e.target.value)}
                    required
                />
                <br></br>
                  inquiry: <input
                    type="inquiry"
                    name="inquiry"
                    value={inquiry}
                    onChange={e => setInquiry(e.target.value)}
                    required
                />
                <br></br>
               area: <input
                    type="area"
                    name="area"
                    value={area}
                    onChange={e => setArea(e.target.value)}
                    required
                />
              
              <button onClick={post}>post </button>
            <button onClick = {get}>get</button>
            <button onClick = {getByUserNameAndAge}>getByUserNameAndAge</button>
        </div> 
    );
}

export default Person;