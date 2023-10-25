import React from 'react';
import { useEffect, useState } from "react";

import { post_api_call,get_api_call} from '../../api';
import "./Profile.css";

type Props = {};

interface customer {
 customerid:number;
 customername:string;
 password:string;
 mobileno:string;
 emailId:string;

};

const Profile = (props: Props) => {

  
    
  const [data, setData] = React.useState<customer>();
  const [username, setusername] = useState("");
  const [password, setpassword] = useState("");
  const [email, setEmail] = useState("");
  const [mobile, setMobile] = useState("");
  const [message, setMessage] = useState("");


  const handleSubmit = (e: any) => {
    e.preventDefault();
    
    const object = { uname: data?.customername,uPass:data?.password,mobileNo:mobile,email:email };
   post_api_call('rest/mat/editProfile',JSON.stringify(object),'application/json')
    .then(values=>{
        console.log("values: ", values) //just checking values
        if(values['msg']){
         setMessage(values['msg']);
     }
       }
    );
  }

  useEffect(() => {
    
        get_api_call('rest/mat/profile','application/json')
        .then(values=>{
           
          
            setData(values);
          
            
        });
      }, []);
  return (

    <div className='content'>

        {message && (<div>
          <p >{message}</p>
          <br/>
        </div>)}
        Edit  Profile:
       <br/>
       <br/>
       

        {data &&
                (
                <form onSubmit={handleSubmit}>
                
                  <label htmlFor="customername">Customer Name</label>
                  <input value={data.customername} onChange={(e) => setusername(e.target.value)}  type="text" name="name"  id="customername"  placeholder="Enter Name" disabled />
               

                  <label htmlFor="mobileno">Mobile Number</label>
                  <input value={data.mobileno} onChange={(e) => setMobile(e.target.value)} type="text" name="mobileno"  id="mobileno"  placeholder="Enter Mobile" />

                
                  <label htmlFor="email">Email Address</label>
                  <input value={data.emailId} onChange={(e) => setEmail(e.target.value)} type="text" name="email"  id="email" aria-describedby="emailHelp" placeholder="Enter Email" />
               
               
                  <label htmlFor="exampleInputPassword1">Password</label>
                  <input value={data.password}  onChange={(e) => setpassword(e.target.value)} type="password" name="password"  id="exampleInputPassword1" placeholder="Password" />
                 
                  <input type="submit" value="Edit Profile"/>
               
              </form>
                 
                )
            }

        
        
    </div>
  );
};

export default Profile;