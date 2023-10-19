package control;

import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.util.Properties;

public class ConnectionUtility {
	private ConnectionUtility() {
		
	}
	private static ThreadLocal<Connection> tlocal=new ThreadLocal<Connection>();
	public static String url,username,password;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3306/vastpro";
			String username ="root";
			String password ="vastpro";
			System.out.println("connecting sucessfuly..!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	synchronized public static Connection getConnection()throws Exception {
		Connection con=tlocal.get();
		if(con==null) {		
			con=DriverManager.getConnection(url,username,password);
			con.setAutoCommit(false);
			tlocal.set(con);
			System.out.println(con);
			return con;
		}
		else {
			System.out.println(con);
			return con;
		}
	}
	
	synchronized public static void closeConnection(Exception ex,Savepoint sp) {
		Connection con=tlocal.get();
		if(con==null) {
			System.out.println("no connection available for closing...");
		}
		else {
			try {
			if(ex==null) {
				con.commit();
			}
			else {
				if(sp!=null) {
					con.rollback(sp);
					con.commit();
				}
				else {
					con.rollback();
				}
			}
			con.close();
			tlocal.remove();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws Exception {
		ConnectionUtility.getConnection();
	}
}
