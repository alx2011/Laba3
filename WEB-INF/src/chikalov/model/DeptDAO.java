package chikalov.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DeptDAO extends DBManager implements IDeptDAO {

	private List<Dept> list = new ArrayList<Dept>();
	

	public DeptDAO() throws ModelException {
		
	}
	
	@Override
	public Dept create(Dept dept) throws ModelException {
		
		final String GET_NEW_ID = " SELECT DEPTNO_SEQ.NEXTVAL as id FROM Dual ";
		try {
			getConnection();
			ResultSet res =querySql(GET_NEW_ID);
			if (res.next()) {
				dept.setDeptno(res.getInt("id"));				
            } else {
            	throw new ModelException("Can't get id of new dept.");
            }
		String sql = "INSERT INTO dept (deptno, dname, loc) "
				+ " VALUES (?, ?, ?) ";
		String[] params = { String.valueOf(dept.getDeptno()), dept.getDname(),
				dept.getLoc() };
			execSql(sql, params);
			return dept;
		} catch (SQLException e) {
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}
		
	}

	@Override
	public Dept find(int id) throws ModelException {		
		try {
			getConnection();;
			String sql = "SELECT deptno, dname, loc FROM dept WHERE deptno = ?";
			String[] params = { String.valueOf(id) };
			ResultSet res = querySql(sql, params);
			while (res.next()) {
				return new Dept(res.getInt("deptno"),
						res.getString("dname"), res.getString("loc"));
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}
		throw new ModelException("No Such ID");
	}

	@Override
	public void delete(int id) throws ModelException {	
		String sql = " DELETE FROM dept WHERE deptno = ? ";
		String[] params = { String.valueOf(id) };
		try {
			getConnection();;
			execSql(sql, params);
		} catch (SQLException e) {
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}
	}

	@Override
	public void update(Dept olddept, Dept newdept) throws ModelException {
		String sql = " UPDATE dept " + " SET dname = ?, loc = ? "
				+ " WHERE deptno = ? ";
		String[] params = { newdept.getDname(), newdept.getLoc(),
				String.valueOf(olddept.getDeptno()) };
		try {
			getConnection();;
			execSql(sql, params);
		} catch (SQLException e) {
			throw new ModelException("Can't update dept");
		} finally {
			releaseConnection();
		}

	}

	@Override
	public List<Dept> findAll() throws ModelException {		
		String sql = "SELECT deptno, dname, loc FROM dept";
		try {
			getConnection();;
			ResultSet res = querySql(sql);
			list = new ArrayList<Dept>();
			while (res.next()) {
				list.add(new Dept(res.getInt("deptno"), res
						.getString("dname"), res.getString("loc")));
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}
		return list;
	}
	@Override
	public List<Dept> findAll(String search, String field, String order) throws ModelException {
		// TODO Auto-generated method stub
		
		String sql;
		String[] params= {};
		sql =
			" SELECT deptno, dname, loc FROM dept ";			
		if ((search!= null)&& (field!= null)) {
			sql+=" WHERE dname  = ? " + " ORDER BY " + field + " " + order;
			params = new String[]{search};
		}
		if ((search!= null)&& (field== null)) {
			sql+=" WHERE dname  = ? ";
			params = new String[]{search};
		}
		if ((search== null)&& (field!= null)) {
			sql+=" ORDER BY " + field + " " + order;
		}
		System.out.println(sql);
		try {
			getConnection();;
			ResultSet res = querySql(sql,params);
			list = new ArrayList<Dept>();
			while (res.next()) {
				list.add(new Dept(res.getInt("deptno"), res
						.getString("dname"), res.getString("loc")));
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}
		return list;
	}

	
}
