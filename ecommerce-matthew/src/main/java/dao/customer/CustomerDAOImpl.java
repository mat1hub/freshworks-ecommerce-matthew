package dao.customer;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import control.ConnectionUtility;
import service.CustomerServiceImpl;

public class CustomerDAOImpl implements CustomerDAO,Cloneable{
	
	public static void main(String[] args) {
		
		
		CustomerDAO cdao=new CustomerDAOImpl();
		CustomerDTO dto=new CustomerDTO();
		dto.setCustomerid(100);
		dto.setCustomername("somu");
		dto.setPassword("secret");
		dto.setActiveFlag(1);
		cdao.updateCustomer(dto);
//		dto=cdao.findByID(100);
//		System.out.println(dto);
//		List<CustomerDTO> list=cdao.findAll();
//		list.stream().forEach(System.out::println);
//		cdao.deleteCustomer(dto);
		
		
	}
	public CustomerDAOImpl() {
//		ConnectionUtility.url="jdbc:mysql://localhost:3306/vastpro";
//		ConnectionUtility.username="root";
//		ConnectionUtility.password="root";
		System.out.println("customer dao impl object created...");
	}
	
	private static CustomerDAOImpl cs;
	
	synchronized public static CustomerDAOImpl getServiceImpl() {
		if(cs==null) {
			cs=new CustomerDAOImpl();
			return cs;
		}
		else {
			return cs.createClone();
		}
	}
	private CustomerDAOImpl createClone() {
		try {
			return (CustomerDAOImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public CustomerDTO findByID(int uid) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("select * from customer where customerid=?");
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();
			CustomerDTO dto=new CustomerDTO();
			if(rs.next()) {
				dto.setCustomerid(rs.getInt(1));
				dto.setCustomername(rs.getString(2));
				dto.setPassword(rs.getString(3));
				dto.setMobileno(rs.getString(4));
				dto.setEmailId(rs.getString(5));
				dto.setActiveFlag(rs.getInt(7));
			}
			ConnectionUtility.closeConnection(null, null);
			return dto;			
		}catch(Exception e) {
			ConnectionUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public List<CustomerDTO> findAll() {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("select * from customer");
			
			ResultSet rs=ps.executeQuery();
			List<CustomerDTO> list=new ArrayList<CustomerDTO>();
			while(rs.next()) {
				CustomerDTO dto=new CustomerDTO();
				dto.setCustomerid(rs.getInt(1));
				dto.setCustomername(rs.getString(2));
				dto.setPassword(rs.getString(3));
				dto.setActiveFlag(rs.getInt(4));

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
	public CustomerDTO findByName(String customerName) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("select * from customer where customername=?");
			ps.setString(1, customerName);
			ResultSet rs=ps.executeQuery();
			CustomerDTO dto=new CustomerDTO();
			if(rs.next()) {
				dto.setCustomerid(rs.getInt(1));
				dto.setCustomername(rs.getString(2));
				dto.setPassword(rs.getString(3));
				dto.setMobileno(rs.getString(4));
				dto.setEmailId(rs.getString(5));
				dto.setActiveFlag(rs.getInt(7));

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
	public int insertCustomer(CustomerDTO dto) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("insert into customer(customername,password,mobileno,emailId,is_active) values (?,?,?)");			
			ps.setString(1, dto.getCustomername());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getMobileno());
			ps.setString(4, dto.getEmailId());
			ps.setInt(5, dto.getActiveFlag());
			ps.executeUpdate();
			ConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			ConnectionUtility.closeConnection(e, null);
			return 0;
		}
		return 1;
	}

	@Override
	public int updateCustomer(CustomerDTO dto) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("select * from customer where customerid=?");
			ps.setInt(1, dto.getCustomerid());
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ps=con.prepareStatement("update customer set customername=?, password=?, is_active=? , mobileno=? , emailId=? where customerid=?");
				
				ps.setString(1, dto.getCustomername());
				ps.setString(2, dto.getPassword());
				ps.setInt(3, dto.getActiveFlag());
				ps.setString(4, dto.getMobileno());
				ps.setString(5, dto.getEmailId());
				ps.setInt(6, dto.getCustomerid());
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
	public int deleteCustomer(CustomerDTO dto) {
		PreparedStatement ps;
		try {
			Connection con=ConnectionUtility.getConnection();
			ps=con.prepareStatement("delete from customer where cust_id=?");
			ps.setInt(1, dto.getCustomerid());
			ps.executeUpdate();
			ConnectionUtility.closeConnection(null, null);
		}catch(Exception e) {
			ConnectionUtility.closeConnection(e, null);
			return 0;
		}
		return 1;
		
	}

}
