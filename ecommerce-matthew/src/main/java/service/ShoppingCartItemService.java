package service;

import java.util.ArrayList;
import java.util.List;

import dao.shoppingcart.ShoppingCartDAOImpl;
import dao.shoppingcartitem.ShoppingCartItemDAO;
import dao.shoppingcartitem.ShoppingCartItemDAOImp;
import dao.shoppingcartitem.ShoppingCartItemDTO;



	public interface ShoppingCartItemService {
		public List<ShoppingCartItemDTO> findAll();
		public int addItem(ShoppingCartItemDTO addProduct);
		public int removeItem(ShoppingCartItemDTO removeProduct);
		public int updateItem(ShoppingCartItemDTO updateItem);

       public List<ShoppingCartItemDTO> getItemsinCart(int customerId);
       
		}

