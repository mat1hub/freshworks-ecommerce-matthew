package dao.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import control.ConnectionUtility;

public class ShopDaoImpl implements ShopDao,Cloneable{
	public ShopDaoImpl() {
		System.out.println("ShoppingCart DAO impl object created...");
		
	}
	
	private static ShopDaoImpl cs;
	
	synchronized public static ShopDaoImpl getServiceImpl() {
		if(cs==null) {
			cs=new ShopDaoImpl();
			return cs;
		}
		else {
			return cs.createClone();
		}
	}
	private ShopDaoImpl createClone() {
		try {
			return (ShopDaoImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ShopDTO findbyShopid(int shopid) {
		PreparedStatement ps;
		try {
			
//			String url ="jdbc:mysql://localhost:3306/vastpro";
//			String username ="root";
//			String password ="vastpro";
//			Connection con=DriverManager.getConnection(url,username,password);
		Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("select "
					+ "shopid,"
					+ "shopOwner,"
					+ "shopType,"
					+ "address,"
					+ "city,"
					+ "pincode,"
					+ "active,"
					+ "last_updated_date"
					+ " from shop where shopid=?");
			ps.setInt(1, shopid);
			ResultSet rs=ps.executeQuery();
			ShopDTO dto=new ShopDTO();
			if(rs.next()) {
				dto.setShopid(rs.getInt(1));
				dto.setShopOwner(rs.getString(2));
				dto.setShopType(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setCity(rs.getString(5));
				dto.setPincode(rs.getString(6));				
				dto.setActive(rs.getInt(7));
				dto.setLastUpdatedDateTime(new java.util.Date(rs.getDate(8).getTime()));
				
			}
			ConnectionUtility.closeConnection(null, null);
			return dto;			
		}catch(Exception e) {
			ConnectionUtility.closeConnection(e, null);
			return null;
		}
		
	}

	@Override
	public int insertShop(ShopDTO shop) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("insert into shop("
					+ "shopOwner,"
					+ "shopType,"
					+ "address,"
					+ "city,"
					+ "pincode,"
					+ "active,"
					+ "last_updated_date"
					+ ") values (?,?,?,?,?,?,?)");
			
			ps.setString(1,shop.getShopOwner());
			ps.setString(2, shop.getShopType());
			ps.setString(3, shop.getAddress());
			ps.setString(4, shop.getCity());
			ps.setString(5, shop.getPincode());
			ps.setInt(6, 1);
			ps.setDate(7, new java.sql.Date(System.currentTimeMillis()));
			
			
			ps.executeUpdate();
			ConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			ConnectionUtility.closeConnection(e, null);
			return 0;
		}
		return 1;
	}
	
	@Override
	public int editShop(ShopDTO shop) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("update shop set"
					+ "shopOwner=?"
					+ "shopType=?"
					+ "address=?"
					+ "city=?"
					+ "pincode=?"
					+ "active=?"
					+ "last_updated_date=?");
			
			ps.setString(1,shop.getShopOwner());
			ps.setString(2, shop.getShopType());
			ps.setString(3, shop.getAddress());
			ps.setString(4, shop.getCity());
			ps.setString(5, shop.getPincode());
			ps.setInt(6, shop.getActive());
			ps.setDate(7, new java.sql.Date(shop.getLastUpdatedDateTime().getTime()));
			ps.executeUpdate();
			ConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			ConnectionUtility.closeConnection(e, null);
			return 0;
		}
		return 1;
	}

	@Override
	public int deleteShop(int shopid) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("delete from shop where shopid=?");
			ps.setInt(1,shopid);
			ps.executeUpdate();
			ConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			ConnectionUtility.closeConnection(e, null);
			return 0;
		}
		return 1;
	
	}
	public List<ShopDTO> findAll(){
		PreparedStatement ps;
		try {
		Connection con=ConnectionUtility.getConnection();
			
		 ps=con.prepareStatement("select * from shop");
			
			ResultSet rs=ps.executeQuery();
			List<ShopDTO> list =new ArrayList<>();
			while(rs.next()) {
				ShopDTO dto=new ShopDTO();
				dto.setShopid(rs.getInt(1));
				dto.setShopOwner(rs.getString(2));
				dto.setShopType(rs.getString(3));
				dto.setAddress(rs.getString(4));
				dto.setCity(rs.getString(5));
				dto.setPincode(rs.getString(6));				
				dto.setActive(rs.getInt(7));
				dto.setLastUpdatedDateTime(new java.util.Date(rs.getDate(8).getTime()));
				
			     list.add(dto);
			}
			ConnectionUtility.closeConnection(null, null);
			return list;			
		}catch(Exception e) {
			ConnectionUtility.closeConnection(e, null);
			return null;
		}
	}
	public static void main(String[] args) throws Exception{
		ShopDao sdao =new ShopDaoImpl();
		//Shop1DTO sto= new Shop1DTO();
		List<ShopDTO> list =sdao.findAll();
//		System.out.println(list);
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	
	}

}
