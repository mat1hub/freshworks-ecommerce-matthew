  
package dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import control.ConnectionUtility;
import dao.product.ProductDto;

public class ProductDaoImpl implements ProductDao,Cloneable {
	private ProductDaoImpl() {
//		ConnectionUtility.url="jdbc:mysql://localhost:3306/vastpro";
//		ConnectionUtility.username="root";
//		ConnectionUtility.password="root";
		System.out.println("customer dao impl object created...");
	}
	private static ProductDaoImpl cs;
	synchronized public static ProductDaoImpl getServiceImpl() {
		if(cs==null) {
			cs=new ProductDaoImpl();
			return cs;
		}
		else {
			return cs.createClone();
		}
	}
	private ProductDaoImpl createClone() {
		try {
			return (ProductDaoImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
public static void main(String[] args) {
	ProductDao pdo =new ProductDaoImpl();
	ProductDto pto =new ProductDto();
	pto.setProductCode("ID1");
	pto.setProductName("product 1");
	pto.setProductDescription("children toy");
	pto.setQuantityInStock(3);
	pto.setBuyPrice(500.00);
	pto.setMsrp(500);
	
}


@Override
public ProductDto findByProductCode(String pcode) {
	PreparedStatement ps;
	try {
		Connection con=ConnectionUtility.getConnection();
		ps=con.prepareStatement("select * from products where productCode=?");
		ps.setString(1, pcode);
		ResultSet rs=ps.executeQuery();
		ProductDto dto=new ProductDto();
		if(rs.next()) {
			dto.setProductCode(rs.getString(1));
			dto.setProductName(rs.getString(2));
			dto.setProductDescription(rs.getString(3));
			dto.setQuantityInStock(rs.getInt(4));
			dto.setBuyPrice(rs.getDouble(5));
			dto.setMsrp(rs.getDouble(6));
		}
		ConnectionUtility.closeConnection(null, null);
		return dto;			
	}catch(Exception e) {
		ConnectionUtility.closeConnection(e, null);
		return null;
	}
}

@Override
public List<ProductDto> findAll() {
	PreparedStatement ps;
	try {
		Connection con=ConnectionUtility.getConnection();
		ps=con.prepareStatement("select productCode,productName,productDescription,quantityInStock,buyPrice,MSRP,productImage,shopid from products");
		
		ResultSet rs=ps.executeQuery();
		List<ProductDto> list=new ArrayList<ProductDto>();
		while(rs.next()) {
			ProductDto dto=new ProductDto();
			dto.setProductCode(rs.getString(1));
			dto.setProductName(rs.getString(2));
			dto.setProductDescription(rs.getString(3));
			dto.setQuantityInStock(rs.getInt(4));
			dto.setBuyPrice(rs.getDouble(5));
			dto.setMsrp(rs.getDouble(6));
			dto.setProductImage(rs.getString(7));
			dto.setShopid(rs.getInt(8));
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
public ProductDto findByproductName(String pname) {
	PreparedStatement ps;
	try {
		Connection con=ConnectionUtility.getConnection();
		ps=con.prepareStatement("select * from products where productName=?");
		ps.setString(1, pname);
		ResultSet rs=ps.executeQuery();
		ProductDto dto=new ProductDto();
		if(rs.next()) {
			dto.setProductCode(rs.getString(1));
			dto.setProductName(rs.getString(2));
			dto.setProductDescription(rs.getString(3));
			dto.setQuantityInStock(rs.getInt(4));
			dto.setBuyPrice(rs.getDouble(5));
			dto.setMsrp(rs.getDouble(6));

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
public List<ProductDto> showProductByShopId(int shopid) {
	PreparedStatement ps;
	try {
		Connection con=ConnectionUtility.getConnection();
		ps=con.prepareStatement("select * from products where shopid=?");
		ps.setInt(1, shopid);
		ResultSet rs=ps.executeQuery();
		List<ProductDto> list=new ArrayList<ProductDto>();

		if(rs.next()) {
			ProductDto dto=new ProductDto();

			dto.setProductCode(rs.getString(1));
			dto.setProductName(rs.getString(2));
			dto.setProductDescription(rs.getString(3));
			dto.setQuantityInStock(rs.getInt(4));
			dto.setBuyPrice(rs.getDouble(5));
			dto.setMsrp(rs.getDouble(6));
			
			list.add(dto);
		}
		else {
			return null;
		}
		ConnectionUtility.closeConnection(null, null);
		return list;			
	}catch(Exception e) {
		ConnectionUtility.closeConnection(e, null);
		return null;
	}
	
}

@Override
public int insertProduct(ProductDto pto) {
	PreparedStatement ps;
	try {
		Connection con=ConnectionUtility.getConnection();
		ps=con.prepareStatement("insert into products(productCode,productImage,productName,productDescription,quantityInStock,buyPrice,MSRP,shopid)"
				+ "  values (?,?,?,?,?,?,?,?)");
		ps.setString(1, pto.getProductCode());
		ps.setString(2, pto.getProductImage());
		ps.setString(3, pto.getProductName());
		ps.setString(4, pto.getProductDescription());
		ps.setInt(5, pto.getQuantityInStock());
		ps.setDouble(6, pto.getBuyPrice());
		ps.setDouble(7, pto.getMsrp());
		ps.setInt(8, pto.getShopid());
		ps.executeUpdate();
		ConnectionUtility.closeConnection(null, null);
	}catch(Exception e) {
		System.out.print(e);
		ConnectionUtility.closeConnection(e, null);
		return 0;
	}
	return 1;
	
}

@Override
public int updateProduct(ProductDto pto) {
	PreparedStatement ps;
	try {
		Connection con=ConnectionUtility.getConnection();
		ps=con.prepareStatement("select * from products where productCode=?");
		ps.setString(1, pto.getProductCode());
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			ps=con.prepareStatement("update products set productName=?, productDescription=?, quantityInStock=?,buyPrice=?,msrp=?, where productCode=?");
			ps.setString(1, pto.getProductCode());
			ps.setString(2, pto.getProductName());
			ps.setString(3, pto.getProductDescription());
			ps.setInt(4, pto.getQuantityInStock());
			ps.setDouble(5, pto.getBuyPrice());
			ps.setDouble(6, pto.getMsrp());
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
public int deleteProduct(String productCode) {
	PreparedStatement ps;
	try {
		Connection con=ConnectionUtility.getConnection();
		ps=con.prepareStatement("delete from products where productCode=?");
		ps.setString(1, productCode);
		ps.executeUpdate();
		ConnectionUtility.closeConnection(null, null);
	}catch(Exception e) {
		ConnectionUtility.closeConnection(e, null);
		return 0;
	}
	return 1;
}
}
