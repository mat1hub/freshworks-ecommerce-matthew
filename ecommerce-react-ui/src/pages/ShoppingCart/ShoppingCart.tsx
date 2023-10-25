import React from 'react';
import { useEffect, useState } from "react";
import { get_api_call} from '../../api';
import "./shoppingcartitem.css";
import { useNavigate } from "react-router-dom";

type Props = {};

export interface shoppingcartitem{
  shoppingcartitemid:number;
  shoppingcartid:number;
  productcode:string;
  quantity:number;
  isactive:number;
  lastupdateddate:string;
  shopid:number;
  productName:string;
  productImage:string;
  price:number;
  
}

const ShoppingCart = (props: Props) => {

    const navigate = useNavigate();

  const [data, setData] = React.useState<shoppingcartitem[]>([]);
  
  const [message, setMessage] = useState("");

  useEffect(() => {
    
    get_api_call('rest/mat/listItemsInCart','application/json')
    .then(values=>{
       

        setData(values);

      
        
    });
  }, []);

 const placeOrder=()=>{

    get_api_call('rest/mat/placeOrder','application/json')
    .then(values=>{
       
        if(values['msg']){
            
            navigate("/Orders");
        }
        
    });

 };



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
        <th>Shopping cart Item id</th><th>Product code</th> <th>Product  Name</th><th>Product Image</th><th> Price</th><th>Last updated date</th>
        </tr>
        {data && 
      data.map(item => 
        <tr>
            <td>{item.shoppingcartitemid}</td>
          <td>{item.productcode}</td>
          <td>{item.productName}</td>
          <td><img className="itemimage" src={item.productImage}/></td>
          <td>{item.price}</td>
          <td>{item.lastupdateddate}</td>
          
        </tr>
      )
      }
      </table>

      <button  onClick={() => placeOrder()}>Place Order</button>
    </div>
  );
};

export default ShoppingCart;