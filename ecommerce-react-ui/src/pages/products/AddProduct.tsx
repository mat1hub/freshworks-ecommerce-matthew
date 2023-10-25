import React from 'react';
import { useEffect, useState } from "react";
import { post_api_call,get_api_call} from '../../api';
import { shop } from '../shop/AddShop';

type Props = {};

export interface product{

  productCode:string;
   productName:string;
  productDescription:string;
  quantityInStock:number;
  buyPrice:number;
  msrp:number;
  productImage:number;
  shopid:number;

}

const AddProduct = (props: Props) => {
 

  const [data, setData] = React.useState<product>();
  const [shops, setShops] = React.useState<shop[]>([]);
  const [productCode, setProductCode] = useState("");
  const [productName, setProductName] = useState("");
  const [productDescription, setProductDescription] = useState("");
  const [quantityInStock, setQuantityInStock] = useState("");
  const [buyPrice, setBuyPrice] = useState("");
  const [msrp, setMsrp] = useState("");
  const [productImage, setProductImage] = useState("");
  const [shop_id, setShop_id] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = (e: any) => {
    e.preventDefault();
    
    const object = {productCode:productCode,productName:productName,productDescription:productDescription,
      quantityInStock:quantityInStock,buyPrice:buyPrice,msrp:msrp,productImage:productImage,shopid:shop_id};
   post_api_call('rest/mat/addProduct',JSON.stringify(object),'application/json')
    .then(values=>{
        console.log("values: ", values) //just checking values
        if(values['msg']){
         setMessage(values['msg']);
     }
       }
    );
  }

  const handleChange = (e:any) => {
    console.log(e.target.value);
    setShop_id(e.target.value);
  };

  useEffect(() => {
    
    get_api_call('rest/mat/shop','application/json')
    .then(values=>{
       
      
        setShops(values);
      
        
    });
  }, []);


  return (
    <div className='content'>
       {message && (<div>
          <p >{message}</p>
          <br/>
        </div>)}
      <h4>Add a Product </h4>
      <form onSubmit={handleSubmit} >
    <label htmlFor="productCode">Product Code</label>
    <input type="text" id="productCode" onChange={(e) => setProductCode(e.target.value)} name="productCode" placeholder="Product Code"/>


    <label htmlFor="productName">Product Name</label>
    <input type="text" id="productName" onChange={(e) => setProductName(e.target.value)} name="productName" placeholder="Product Name"/>

    <label htmlFor="productDescription">Product Desc</label>
    <input type="text" id="productDescription" onChange={(e) => setProductDescription(e.target.value)} name="productDescription" placeholder="Product Description"/>

    <label htmlFor="quantityInStock">Quantity in stock</label>
    <input type="text" id="quantityInStock" onChange={(e) => setQuantityInStock(e.target.value)} name="quantityInStock" placeholder="Quantity in stock"/>

    <label htmlFor="buyPrice">Buy Price</label>
    <input type="text" id="buyPrice" onChange={(e) => setBuyPrice(e.target.value)} name="buyPrice" placeholder="Buy Price"/>

    <label htmlFor="msrp">Max Selling Retail Price</label>
    <input type="text" id="msrp" onChange={(e) => setMsrp(e.target.value)} name="msrp" placeholder="Max selling retail price"/>

    
    <label htmlFor="productImage">Product Image</label>
    <input type="text" id="productImage" onChange={(e) => setProductImage(e.target.value)} name="productImage" placeholder="Product Image"/>


    <label htmlFor="shopId">Shop</label>
    <select id="shopId" name="shopId"  onChange={handleChange}  >
      {shops && 
      shops.map(shop => 
        <option value={shop.shopid}>{shop.shopOwner}</option>
      )
      }
     
  
    </select>

   
  
    <input type="submit" value="Submit"/>
  </form>
    </div>
  );
};

export default AddProduct;