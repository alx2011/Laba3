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

import chikalov.controller.ActionDeptDelete;


public class SalgradeDAO extends DBManager implements ISalgradeDAO {

	private List<Salgrade> list = new ArrayList<Salgrade>();
	

	public SalgradeDAO() throws ModelException {
		
	}	
	
	@Override
	public Salgrade create(Salgrade salgr) throws ModelException {

		final String GET_NEW_ID = " SELECT SAL_SEQ.NEXTVAL as id FROM Dual ";
		try {
			getConnection();
			ResultSet res =querySql(GET_NEW_ID);
			if (res.next()) {
				salgr.setGrade(res.getInt("id"));				
            } else {
            	throw new ModelException("Can't get id of new dept.");
            }
			String sql = "INSERT INTO salgrade (grade, minsal, hisal) "
				+ " VALUES (?, ?, ?) ";
			String[] params = { String.valueOf(salgr.getGrade()), String.valueOf(salgr.getMinsal()),
				String.valueOf(salgr.getHisal()) };
			execSql(sql, params);
			return salgr;
		} catch (SQLException e) {
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}
		
	}

	@Override
	public Salgrade find(int id) throws ModelException {		
		try {
			getConnection();;
			String sql = "SELECT grade, minsal, hisal FROM salgrade WHERE grade = ?";
			String[] params = { String.valueOf(id) };
			ResultSet res = querySql(sql, params);
			while (res.next()) {
				return new Salgrade(res.getInt("grade"), res.getFloat("minsal"),
						res.getFloat("hisal"));
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
		String sql = " DELETE FROM salgrade WHERE grade = ? ";
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
	public void update(Salgrade oldsalgr, Salgrade newsalgr) throws ModelException {
		String sql = " UPDATE salgrade " + " SET minsal = ?, hisal = ? "
				+ " WHERE grade = ? ";
		String[] params = { String.valueOf(newsalgr.getMinsal()),
				String.valueOf(newsalgr.getHisal()),
				String.valueOf(oldsalgr.getGrade()) };
		System.out.println(String.valueOf(newsalgr.getMinsal())+" " +String.valueOf(newsalgr.getHisal()) +" " );
		try {
			getConnection();;
			execSql(sql, params);
		} catch (SQLException e) {
			throw new ModelException("Can't update salgrade");
		} finally {
			releaseConnection();
		}

	}

	@Override
	public List<Salgrade> findAll() throws ModelException {		
		String sql = "SELECT grade, minsal, hisal FROM salgrade";
		try {
			getConnection();;
			ResultSet res = querySql(sql);
			list = new ArrayList<Salgrade>();
			while (res.next()) {
				list.add(new Salgrade(res.getInt("grade"), res.getFloat("minsal"),
						res.getFloat("hisal")));
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}
		return list;
	}
	@Override
	public List<Salgrade> findAll(String search, String field, String order) throws ModelException {
		// TODO Auto-generated method stub
		
		String sql;
		String[] params= {};
		sql =
			" SELECT grade, minsal, hisal FROM salgrade ";			
		if ((search!= null)&& (field!= null)) {
			sql+=" WHERE minsal  = ? " + " ORDER BY " + field + " " + order;
			params = new String[]{search};
		}
		if ((search!= null)&& (field== null)) {
			sql+=" WHERE minsal  = ? ";
			params = new String[]{search};
		}
		if ((search== null)&& (field!= null)) {
			sql+=" ORDER BY " + field + " " + order;
		}
		System.out.println(sql);
		try {
			getConnection();;
			ResultSet res = querySql(sql,params);
			list = new ArrayList<Salgrade>();
			while (res.next()) {
				list.add(new Salgrade(res.getInt("grade"), res.getFloat("minsal"),
						res.getFloat("hisal")));
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}
		return list;
	}

	
}
