import React from 'react';
import { useEffect, useState } from "react";
import { post_api_call,get_api_call} from '../../api';
type Props = {};

export interface shop{
  shopid:number;
  shopOwner:string;
  shopType:string;
  address:string;
  city:string;
  pincode:string;
  
}

const AddShop = (props: Props) => {


  const [data, setData] = React.useState<shop>();
  const [shopOwner, setShopOwner] = useState("");
  const [shopType, setShopType] = useState("");
  const [address, setAddress] = useState("");
  const [city, setCity] = useState("");
  const [pincode, setPincode] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = (e: any) => {
    e.preventDefault();
    
    const object = {shopOwner:shopOwner,shopType:shopType,address:address,city:city,pincode:pincode};
   post_api_call('rest/mat/addShop',JSON.stringify(object),'application/json')
    .then(values=>{
        console.log("values: ", values) //just checking values
        if(values['msg']){
         setMessage(values['msg']);
     }
       }
    );
  }

 


  return (
    <div className='content'>
       {message && (<div>
          <p >{message}</p>
          <br/>
        </div>)}
      <h4>Add a Shop </h4>
      <form onSubmit={handleSubmit} >
    <label htmlFor="shopOwner">Shop Name</label>
    <input type="text" id="shopOwner" onChange={(e) => setShopOwner(e.target.value)} name="shopOwner" placeholder="Shop name"/>

    
    <label htmlFor="shopType">Shop Type</label>
    <select id="shopType" name="shopType" onChange={(e) => setShopType(e.target.value)} >
      <option value="Textile">Textile</option>
      <option value="Electrical">Electrical</option>
      <option value="Hardwares">Hardwares</option>
    </select>

    <label htmlFor="address">Address</label>
    <input type="text" id="address" name="address" onChange={(e) => setAddress(e.target.value)} placeholder="Your Adsress"/>

    <label htmlFor="city">City</label>
    <input type="text" id="city" name="city" onChange={(e) => setCity(e.target.value)} placeholder="Your City"/>

    <label htmlFor="pincode">PinCode</label>
    <input type="text" id="pincode" name="pincode" onChange={(e) => setPincode(e.target.value)} placeholder="PinCode"/>

  
    <input type="submit" value="Submit"/>
  </form>
    </div>
  );
};

export default AddShop;