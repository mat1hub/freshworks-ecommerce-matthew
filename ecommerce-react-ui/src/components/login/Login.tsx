import React,{useState} from 'react' ;
import { useNavigate } from "react-router-dom";
import "./Login.css";
import { post_api_call,get_api_call} from '../../api';


const Login = () => {
  const navigate = useNavigate();
  const [username, setusername] = useState("");
  const [password, setpassword] = useState("");
  const [authenticated, setauthenticated] = useState(
    localStorage.getItem(localStorage.getItem("authenticated") || "false")
  );
  const users = [{ username: "Jane", password: "testpassword" }];
  const handleSubmit = (e: any) => {
    e.preventDefault();
    
    const object = { username: username,password:password };
   post_api_call('rest/mat/login',JSON.stringify(object),'application/json')
    .then(values=>{
        console.log("values: ", values) //just checking values
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
 <button type="submit" value="Submit" className="button" >Login</button>

 </div>

 <br/>
<br/>
 <a href='/register'>New User? Please  Register</a>
 </form>
    </div>
  );
};
export default Login;