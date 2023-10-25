import React from 'react';
import { useEffect, useState } from "react";
import { post_api_call,get_api_call} from '../../api';

type Props = {};

export interface order{
orderid:number;
shoppingcartid:number;
lastupdatedDate:string;
  
}

const Orders = (props: Props) => {


  const [data, setData] = React.useState<order[]>([]);
  
  const [message, setMessage] = useState("");

  useEffect(() => {
    
    get_api_call('rest/mat/orders','application/json')
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
        <th>Order Id</th> <th>Shopping cart id</th><th>Last Updated date</th>    </tr>
        {data && 
      data.map(order => 
        <tr>
          <td>{order.orderid}</td>
          <td>{order.shoppingcartid}</td>
          <td>{order.lastupdatedDate}</td>
        
        </tr>
      )
      }
      </table>
    </div>
  );
};

export default Orders;