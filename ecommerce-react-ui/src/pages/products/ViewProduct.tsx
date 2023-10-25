import React from 'react';
import { useEffect, useState } from "react";
import { post_api_call,get_api_call} from '../../api';
import "./product.css";
// Importing toastify module
//import {toast} from 'react-toastify'; 
 
// Import toastify css file
//import 'react-toastify/dist/ReactToastify.css';
type Props = {};

export interface product{

  productCode:string;
   productName:string;
  productDescription:string;
  quantityInStock:number;
  buyPrice:number;
  msrp:number;
  productImage:string;
  shopid:number;

}

const ViewProduct = (props: Props) => {


  const addItemtoCart=(productCode:string,shop_id:number)=>{

   
    
      get_api_call('rest/mat/additemtocart/'+productCode+"/"+shop_id,'application/json')
    .then(values=>{
        console.log("values: ", values) //just checking values
        if(values['msg']){
         setMessage(values['msg']);
         //toast(values['msg']);

     }
       }
    );

  }; 
  const [data, setData] = React.useState<product[]>([]);
  
  const [message, setMessage] = useState("");

  useEffect(() => {
    
    get_api_call('rest/mat/showproduct','application/json')
    .then(values=>{
       

        setData(values);
      
        
    });
  }, []);

 


  return (
    
    <div  >
       {message&&(<p>{message}</p>)}
       <div className="row">
        {data && 
      data.map(product => 
        <div className="card">


        <img src={product.productImage}  alt={product.productName} className='productimage' />
        <h5>{product.productName}</h5>
        <p className="price">{product.buyPrice}</p>
        <p>{product.productDescription}</p>
        <p><button   onClick={() => addItemtoCart(product.productCode,product.shopid)} >Add to Cart</button></p>
      </div>
      )
      }
     </div>
    </div>
  );
};

export default ViewProduct;