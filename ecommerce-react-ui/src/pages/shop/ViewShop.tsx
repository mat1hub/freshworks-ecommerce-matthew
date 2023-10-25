import React from 'react';
import { useEffect, useState } from "react";
import { post_api_call,get_api_call} from '../../api';
import "./shop.css";
type Props = {};

export interface shop{
  shopid:number;
  shopOwner:string;
  shopType:string;
  address:string;
  city:string;
  pincode:string;
  
}

const ViewShop = (props: Props) => {


  const [data, setData] = React.useState<shop[]>([]);
  
  const [message, setMessage] = useState("");

  useEffect(() => {
    
    get_api_call('rest/mat/shop','application/json')
    .then(values=>{
       

        setData(values);
      
        
    });
  }, []);

 


  return (
    
    <div className='content' >
       <style>{`
  table ,tbody , tr , td {
    border-right-width: 1px;
    border-top-width: 1px;
    border-bottom-width: 0px;
    border-left-width: 0px;
    border-style: solid;
    border-color: black;
  }
  `}</style>
      <table >
        <tr>
        <th>Shop ID</th> <th>Shop Name</th><th>Shop Type</th><th> Address</th><th>City</th><th>Pincode</th>
        </tr>
        {data && 
      data.map(shop => 
        <tr>
          <td>{shop.shopid}</td>
          <td>{shop.shopOwner}</td>
          <td>{shop.shopType}</td>
          <td>{shop.address}</td>
          <td>{shop.city}</td>
          <td>{shop.pincode}</td>
        </tr>
      )
      }
      </table>
    </div>
  );
};

export default ViewShop;