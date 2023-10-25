package dao.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import control.ConnectionUtility;
import dao.customer.CustomerDAOImpl;
import dao.product.ProductDto;

public class OrderDAOImpl implements OrderDAO,Cloneable{
	
private static OrderDAOImpl cs;
	
	synchronized public static OrderDAOImpl getServiceImpl() {
		if(cs==null) {
			cs=new OrderDAOImpl();
			return cs;
		}
		else {
			return cs.createClone();
		}
	}
	private OrderDAOImpl createClone() {
		try {
			return (OrderDAOImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<OrderDTO> findAll(int customerid) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("select o.* from vastpro.order o join vastpro.shoppingcart sc "
					+ "on o.shoppingcartid=sc.shoppingcartid where sc.customerid=?");
			ps.setInt(1, customerid);
			ResultSet rs=ps.executeQuery();
			List<OrderDTO> list = new ArrayList<OrderDTO>();
			while(rs.next()) {
				OrderDTO dto=new OrderDTO();
				dto.setOrderid(rs.getInt(1));
				dto.setShoppingcartid(rs.getInt(2));
				dto.setLastupdatedDate(rs.getDate(3));
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
	public OrderDTO findByOrderId(int pname) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("select * from order where orderid=?");
			ps.setInt(1, pname);
			ResultSet rs=ps.executeQuery();
		      OrderDTO dto=new OrderDTO();
			if(rs.next()) {
				dto.setOrderid(rs.getInt(1));
				dto.setShoppingcartid(rs.getInt(2));
				dto.setLastupdatedDate(rs.getDate(3));
			}
			else {
				return null;
			}
			ConnectionUtility.closeConnection(null, null);
			return dto;			
		}catch(Exception e) {
			ConnectionUtility.closeConnection(e, null);
			return null;
		}
		
	}

	@Override
	public int addOrder(OrderDTO insert) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("insert into order values (?,?)");
			
			ps.setInt(1, insert.getShoppingcartid());
			ps.setDate(2, insert.getLastupdatedDate());
	
			ps.executeUpdate();
			//ps.execute();
			ConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			ConnectionUtility.closeConnection(e, null);
			return 0;
		}
		return 1;
	}

	@Override
	public int updateOrder(OrderDTO update) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("select * from order where orderid=?");
			ps.setInt(1, update.getOrderid());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ps=con.prepareStatement("update order set shoppingcartid=?, lastupdatedDate=?,  where orderid=?");
				ps.setInt(1, update.getOrderid());
				ps.setInt(2, update.getShoppingcartid());
				ps.setDate(3, update.getLastupdatedDate());
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
	public int deleteOrder(OrderDTO delete) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("delete from order where orderid=?");
			ps.setInt(1, delete.getOrderid());
			ps.executeUpdate();
			ConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			ConnectionUtility.closeConnection(e, null);
			return 0;
		}
		return 1;
	}
	@Override
	public int placeOrder(int shoppingCartId) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("insert into vastpro.order(shoppingcartid,last_updated_date) values (?,?)");
			
			ps.setInt(1, shoppingCartId);
			ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			
			ps.executeUpdate();
			ConnectionUtility.closeConnection(null, null);
		    con=ConnectionUtility.getConnection();
			
			
			ps=con.prepareStatement("update shoppingcart set is_active=0  where shoppingcartid=?");
			ps.setInt(1, shoppingCartId);
			ps.executeUpdate();
			//ps.execute();
			ConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			System.out.println(e);
			ConnectionUtility.closeConnection(e, null);
			return 0;
		}
		return 1;
	}

}
