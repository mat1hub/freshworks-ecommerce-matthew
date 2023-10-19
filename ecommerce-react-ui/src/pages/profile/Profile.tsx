import React from 'react';
import { useEffect, useState } from "react";
import { Navigate } from "react-router-dom";
import { get_api_call } from '../../api';
import Orders from '../orders/Orders';

type Props = {};

const Profile = (props: Props) => {

    let profile:any;
    useEffect(() => {
    
        get_api_call('rest/mat/user','application/json')
        .then(values=>{
           
            profile=values;
            
        });
      }, []);
  return (

    <div>
        User Profile:
        <br/>
        <br/>
        <br/>

        Name:
        <br/>
        Email:
        <br/>
        Mobile Number:
        <br/>
        Age:
        <Orders />

        
        
    </div>
  );
};

export default Profile;