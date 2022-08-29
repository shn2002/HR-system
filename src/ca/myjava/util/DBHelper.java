package ca.myjava.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBHelper {
	private static String url="jdbc:mysql://mymysql.senecacollege.ca/db_dwang145";
	private static String username="db_dwang145";
	private static String password ="+t0~m5RleF";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't get the driver. Please check driver jar");
			e.printStackTrace();
	}
	}
	
	public static Connection getConnection () {
		try {
			Connection connection =DriverManager.getConnection(url, username, password);
			return connection;
		} catch (SQLException e) {
			System.out.println("Can't get connection");
			throw new RuntimeException(e);
		}
	}
	
	public ResultSet executeQueryByStmt(String sql) {
		Connection conn = null;
		Statement stmt= null;
		ResultSet res = null;
		try {
			conn =getConnection();
			stmt=conn.createStatement();
			res=stmt.executeQuery(sql);
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			closeResources(res,stmt, conn);
		}
		return res;
	}
	
	public ResultSet executeQueryByPreStmt(String sql,List<Object> params) {
		Connection conn = null;
		PreparedStatement preStmt= null;
		ResultSet res = null;
		try {
			conn =getConnection();
			preStmt=conn.prepareStatement(sql);
			setParams(preStmt, params);
			res=preStmt.executeQuery();
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
			closeResources(res,preStmt, conn);
		}
		return res;
	}
	
	public int executeOperateByStmt(String sql) {
		int count =0;
		Connection conn = null;
		Statement stmt= null;
		try {
			conn =getConnection();
			stmt=conn.createStatement();
			count=stmt.executeUpdate(sql);
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
		}finally {
			closeResources(stmt, conn);
		}
		
		return count;
	
	}
	
	public int executeOperateByPreStmt(String sql,List<Object> params) {
		int count =0;
		Connection conn = null;
		PreparedStatement preStmt= null;
		
		try {
			conn =getConnection();
			preStmt=conn.prepareStatement(sql);
			setParams(preStmt, params);
			count=preStmt.executeUpdate();
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
		}finally {
			
			closeResources(preStmt, conn);
		}
		
		return count;
		
	}   
	
	public void closeResources(Statement stmt,Connection conn) {
		try {
			if(stmt!=null) {
				stmt.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException sqle) {
			// TODO Auto-generated catch block
			sqle.printStackTrace();
		}
	}
	public void closeResources(ResultSet res,Statement stmt,Connection conn) {
			try {
				if(res!=null) {
					res.close();
				}
				closeResources(stmt,conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	public void setParams(PreparedStatement preStmt,List<Object> params) throws SQLException {
		if (params!=null && params.size()>0) {
			
			for(int i=0;i<params.size();i++) {
				preStmt.setObject(i+1, params.get(i));
			}
		}
		
	}
	
	
}
