import React,{useState} from 'react' ;
import { useNavigate } from "react-router-dom";
import "./Register.css";
import { post_api_call,get_api_call} from '../../api';


const Register = () => {
  const navigate = useNavigate();
  const [username, setusername] = useState("");
  const [password, setpassword] = useState("");
  const [mobile, setMobile] = useState("");
  const [email, setEmail] = useState("");
  const [authenticated, setauthenticated] = useState(
    localStorage.getItem(localStorage.getItem("authenticated") || "false")
  );
  const users = [{ username: "Jane", password: "testpassword" }];
  var smsg='';
  const handleSubmit = (e: any) => {
    e.preventDefault();
    
    const object = { uname: username,uPass:password ,mobileNo:mobile,email:email};
   post_api_call('rest/mat/register',JSON.stringify(object),'application/json')
    .then(values=>{
        console.log("values: ", values) //just checking values
        smsg=values['msg'];
        if(values['msg'] ==="success"){

            localStorage.setItem("authenticated", "true");
            navigate("/");
       }
    });

    
    
    

   
    
  };
  return (
   
    <div className="App">
        <h1>Matthew Ecommerce Site</h1>
      <form onSubmit={handleSubmit} className="form__container" method="post">
      <div className="form__controls">
      {smsg}
<label htmlFor="Username">Username</label>
 <input
 type="text"
 name="Username"
 value={username}
 onChange={(e) => setusername(e.target.value)}
 />
 </div>
 <div className="form__controls">
<label htmlFor="Password">Password</label>
 <input
 type="password"
 name="Password"
 onChange={(e) => setpassword(e.target.value)}
 />
 </div>
 <div className="form__controls">
<label htmlFor="email">Email</label>
 <input
 type="text"
 name="email"
 onChange={(e) => setEmail(e.target.value)}
 />
 </div>
 <div className="form__controls">
<label htmlFor="mobile">Mobile Number</label>
 <input
 type="text"
 name="mobile"
 onChange={(e) => setMobile(e.target.value)}
 />
 </div>
 <div className="form__controls">
 <button type="submit" value="Submit" className="button" >Register</button>
 
 </div>
 </form>
    </div>
  );
};
export default Register;