package chikalov.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBManager {
	
	
	
	
	private DataSource dataSource;
	
		
	protected Connection connect; 	
 	protected PreparedStatement stat;
 	protected ResultSet result;
 		
 	public void getConnection() throws ModelException  { 		
 		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:comp/env");
			dataSource = (DataSource) envContext.lookup("jdbc/myoracle");
			this.stat = null;
			connect = dataSource.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			throw new ModelException(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ModelException(e);
		}
 	}
		
 	public void releaseConnection() throws ModelException  {
 		try  {
			if (result != null) {
				result.close();
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		}  finally {
			try {
				if (stat != null) {
					stat.close();
				}
			} catch (SQLException e) {
				throw new ModelException(e);
			} finally {
				if (connect != null) {
					try {
						connect.close();
					} catch (SQLException e) {
						throw new ModelException(e);
					}
				}
			}
		} 		
 	}
	public void release() {
		try {result.close();} catch (Exception e) {}
		try {stat.close();} catch (Exception e) {}
		try {connect.close();} catch (Exception e) {}
	}

	private void prepareStatement(String sql, String[] params)
	throws SQLException {
		try {result.close();} catch (Exception e) {}
		try {stat.close();} catch (Exception e) {}

		stat = connect.prepareStatement(sql);
		if(params != null) {
			for(int i = 0; i < params.length; i++) {
				stat.setString(i+1, params[i]);
			}
		}
		System.out.println("stat"+ stat);
	}
	public ResultSet querySql(String sql) throws SQLException {
		prepareStatement(sql, null);
		result = stat.executeQuery();
		return result;
	}

	public ResultSet querySql(String sql, String[] params) throws SQLException {
		prepareStatement(sql, params);
		result = stat.executeQuery();
		return result;
	}

	public int execSql(String sql, String[] params) throws SQLException {
		prepareStatement(sql, params);
		return stat.executeUpdate();
	}
}
