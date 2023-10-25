package dao.shoppingcartitem;

	import java.sql.Connection;

	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

	import control.ConnectionUtility;
import dao.product.ProductDto;
import service.ShoppingCartServiceImpl;

	public class ShoppingCartItemDAOImp implements ShoppingCartItemDAO,Cloneable{
      
		private static ShoppingCartItemDAOImp cs;
		
		synchronized public static ShoppingCartItemDAOImp getServiceImpl() {
			if(cs==null) {
				cs=new ShoppingCartItemDAOImp();
				return cs;
			}
			else {
				return cs.createClone();
			}
		}
		private ShoppingCartItemDAOImp createClone() {
			try {
				return (ShoppingCartItemDAOImp)super.clone();
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		
		@Override
		public List<ShoppingCartItemDTO> findAll() {
			PreparedStatement ps;
			try {
				Connection con=ConnectionUtility.getConnection();
				ps=con.prepareStatement("select productCode,productName,productDescription,quantityInStock,buyPrice,MSRP,productImage from products");
				
				ResultSet rs=ps.executeQuery();
				List<ShoppingCartItemDTO> list=new ArrayList<ShoppingCartItemDTO>();
				while(rs.next()) {
					ShoppingCartItemDTO dto=new ShoppingCartItemDTO();
					dto.setShoppingcartitemid(rs.getInt(1));;
					dto.setShoppingcartid(rs.getInt(2));
					dto.setProductcode(rs.getString(3));
					dto.setQuantity(rs.getInt(4));
					dto.setIsactive(rs.getInt(5));
					dto.setLastupdateddate(rs.getDate(6));
					

					list.add(dto);
				}
				ConnectionUtility.closeConnection(null, null);
				return list;			
			}catch(Exception e) {
				ConnectionUtility.closeConnection(e, null);
				return null;
			}
		}

		@Override
		public int addItem(ShoppingCartItemDTO addProduct) {
			PreparedStatement ps;
			try {
				Connection con=ConnectionUtility.getConnection();
				ps=con.prepareStatement("insert into shoppingcartitem(shoppingcartid,is_active,last_updated_date,quantity,productCode) values (?,?,?,?,?)");
				//ps.setInt(1, addProduct.getShoppingcartitemid());
				ps.setInt(1, addProduct.getShoppingcartid());
				ps.setInt(2, 1);
				ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
				
				ps.setInt(4, addProduct.getQuantity());
				ps.setString(5, addProduct.getProductcode());
				
				
				ps.executeUpdate();
				ConnectionUtility.closeConnection(null, null);
			}catch(Exception e) {
				System.out.println(e);
				ConnectionUtility.closeConnection(e, null);
				return 0;
			}
			return 1;
		}

		@Override
		public int removeItem(ShoppingCartItemDTO removeProduct) {
			PreparedStatement ps;
			try {
				Connection con=ConnectionUtility.getConnection();
				ps=con.prepareStatement("delete from shoppingcartitem where productcode=? and shoppingcartid=?");
				ps.setString(1, removeProduct.getProductcode());
				ps.setInt(2, removeProduct.getShoppingcartid());
				
				ps.executeUpdate();
				ConnectionUtility.closeConnection(null, null);
			}catch(Exception e) {
				ConnectionUtility.closeConnection(e, null);
				return 0;
			}
			return 1;
		}

		@Override
		public int updateItem(ShoppingCartItemDTO updateItem) {
			PreparedStatement ps;
			try {
				Connection con=ConnectionUtility.getConnection();
				ps=con.prepareStatement("select * from shoppingcartitem where shoppingcartitemid=?");
				ps.setInt(1, updateItem.getShoppingcartitemid());
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					ps=con.prepareStatement("update shoppingcartitem set shoppingcartid=?, productcode=?, quantity=?,isactive=?,lastupdateddate=?, where shoppingcartitemid=?");
					ps.setInt(1, updateItem.getShoppingcartitemid());
					ps.setInt(2,updateItem.getShoppingcartid());
					ps.setString(3, updateItem.getProductcode());
					ps.setInt(4, updateItem.getQuantity());
					ps.setInt(5, updateItem.getIsactive());
					ps.setDate(6, updateItem.getLastupdateddate());
					ps.executeUpdate();
				}
				else {
					System.out.println("no record found to update....");
				}
				ConnectionUtility.closeConnection(null, null);
			}catch(Exception e) {
				ConnectionUtility.closeConnection(e, null);
				return 0;
			}
			return 1;
			
		}
		@Override
		public List<ShoppingCartItemDTO> getItemsinCart(int customerId) {
			PreparedStatement ps;
			try {
				Connection con=ConnectionUtility.getConnection();
				ps=con.prepareStatement("select sct.shoppingcartitemid,sct.shoppingcartid,sct.productCode,"
						+ " sct.quantity,sct.is_active,p.productName,p.productImage,p.buyPrice,sct.last_updated_date from "
						+ " shoppingcart sc "
						+ " join shoppingcartitem sct"
						+ " on sc.shoppingcartid=sct.shoppingcartid"						
						+ " join products p"
						+ " on p.productCode=sct.productCode"
						+ " where sc.customerid=? and sc.is_active=1");
				ps.setInt(1, customerId);
				ResultSet rs=ps.executeQuery();
				List<ShoppingCartItemDTO> list=new ArrayList<ShoppingCartItemDTO>();
				while(rs.next()) {
					ShoppingCartItemDTO dto=new ShoppingCartItemDTO();
					dto.setShoppingcartitemid(rs.getInt(1));;
					dto.setShoppingcartid(rs.getInt(2));
					dto.setProductcode(rs.getString(3));
					dto.setQuantity(rs.getInt(4));
					dto.setIsactive(rs.getInt(5));
					dto.setProductName(rs.getString(6));
					dto.setProductImage(rs.getString(7));
					dto.setPrice(rs.getDouble(8));
					dto.setLastupdateddate(rs.getDate(9));
					

					list.add(dto);
				}
				ConnectionUtility.closeConnection(null, null);
				return list;			
			}catch(Exception e) {
				ConnectionUtility.closeConnection(e, null);
				return null;
			}
		}


	}


