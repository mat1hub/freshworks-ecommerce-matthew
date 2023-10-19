import React from 'react';
import { useEffect, useState } from "react";
import { Navigate } from "react-router-dom";
import { get_api_call } from '../../api';

type Props = {};

const Logout = (props: Props) => {

  
  
  useEffect(() => {
    
    get_api_call('rest/mat/logout','application/json')
    .then(values=>{
       
        if(values['msg'] ==="success"){
         
            const loggedInUser = localStorage.getItem("authenticated");
            console.log("loggedinuser",loggedInUser);
            localStorage.removeItem("authenticated");
       }
    });
  }, []);
  return (
    

    <Navigate replace to="/login" />
  );
};

export default Logout;