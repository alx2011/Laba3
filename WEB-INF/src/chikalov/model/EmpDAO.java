package chikalov.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DBManager implements IEmpDAO {

	private List<Emp> list = new ArrayList<Emp>();

	public EmpDAO() throws ModelException {

	}

	@Override
	public Emp create(Emp emp) throws ModelException {

		String sql = "INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno ) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
		// Date sqldate = new Date(emp.getHiredate().getTime());
		// String[] params = { emp.getEname(), emp.getJob(),
		// String.valueOf(emp.getMgr()),
		// emp.getHiredate().toString(), String.valueOf(emp.getSal()),
		// String.valueOf(emp.getComm()), String.valueOf(emp.getDeptno()) };
		final String GET_NEW_ID = " SELECT EMPNO_SEQ.NEXTVAL as id FROM Dual ";
		try {

			getConnection();
			ResultSet res = querySql(GET_NEW_ID);
			if (res.next()) {
				emp.setEmpno(res.getInt("id"));
			} else {
				throw new ModelException("Can't get id of new emp.");
			}

			stat = connect.prepareStatement(sql);
			stat.setInt(1, emp.getEmpno());
			stat.setString(2, emp.getEname());
			stat.setString(3, emp.getJob());
			stat.setInt(4, emp.getMgr());
			stat.setDate(5, new java.sql.Date(emp.getHiredate().getTime()));
			// stat.setString(4, formatter.format(sqldate));
			stat.setFloat(6, emp.getSal());
			stat.setFloat(7, emp.getComm());
			stat.setInt(8, emp.getDeptno());
			// execSql(sql, params);
			stat.executeUpdate();
			return emp;

		} catch (SQLException e) {
			System.out.println(e);
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}

	}

	@Override
	public Emp find(int id) throws ModelException {
		try {
			getConnection();			
			String sql = "SELECT t1.empno, t1.ename, t1.job, t1.mgr, t1.hiredate, "
				+ "t1.sal, t1.comm, t1.deptno, t2.dname, t2.loc FROM emp t1 "
				+ "INNER JOIN dept t2 ON t1.deptno=t2.deptno WHERE empno = ?";
			String[] params = { String.valueOf(id) };
			ResultSet res = querySql(sql, params);
			while (res.next()) {
				Emp emp = new Emp(res.getInt("empno"), res.getString("ename"),
						res.getString("job"), res.getInt("mgr"),
						res.getDate("hiredate"), res.getFloat("sal"),
						res.getFloat("comm"), res.getInt("deptno"));
				emp.setDept(new Dept(emp.getDeptno(), res.getString("dname"),
						res.getString("loc")));
				return emp;
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
		String sql = " DELETE FROM emp WHERE empno = ? ";
		String[] params = { String.valueOf(id) };
		try {
			getConnection();
			;
			execSql(sql, params);
		} catch (SQLException e) {
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}
	}

	@Override
	public void update(Emp oldemp, Emp newemp) throws ModelException {
		String sql = " UPDATE emp "
				+ " SET ename = ?, job = ?, mgr = ?, hiredate = ?, sal = ?, comm = ?, deptno = ? "
				+ " WHERE empno = ? ";
		// SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
		// Date sqldate = new java.sql.Date(newemp.getHiredate().getTime());
		// System.out.println("Date is : " + formatter.format(sqldate));
		// String testDate= " TO_DATE('"+ formatter.format(sqldate)
		// +"', 'YYYY-MM-DD') ";

		// String[] params = { newemp.getEname(), newemp.getJob(),
		// String.valueOf(newemp.getMgr()),
		// testDate, String.valueOf(newemp.getSal()),
		// String.valueOf(newemp.getComm()), String.valueOf(newemp.getDeptno()),
		// String.valueOf(oldemp.getEmpno()) };

		try {
			getConnection();
			;
			stat = connect.prepareStatement(sql);
			stat.setString(1, newemp.getEname());
			stat.setString(2, newemp.getJob());
			stat.setInt(3, newemp.getMgr());
			stat.setDate(4, newemp.getHiredate());
			// stat.setString(4, formatter.format(sqldate));
			// stat.setString(4, testDate);
			// stat.setDate(4,new
			// java.sql.Date(newemp.getHiredate().getTime()));
			stat.setFloat(5, newemp.getSal());
			stat.setFloat(6, newemp.getComm());
			stat.setInt(7, newemp.getDeptno());
			stat.setInt(8, oldemp.getEmpno());
			stat.executeUpdate();
			// execSql(sql, params);
		} catch (SQLException e) {
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}

	}

	@Override
	public List<Emp> findAll() throws ModelException {
		String sql = "SELECT t1.empno, t1.ename, t1.job, t1.mgr, t1.hiredate, "
				+ "t1.sal, t1.comm, t1.deptno, t2.dname, t2.loc FROM emp t1 "
				+ "INNER JOIN dept t2 ON t1.deptno=t2.deptno";
		try {
			getConnection();
			;
			ResultSet res = querySql(sql);
			list = new ArrayList<Emp>();
			while (res.next()) {
				Emp emp = new Emp(res.getInt("empno"), res.getString("ename"),
						res.getString("job"), res.getInt("mgr"),
						res.getDate("hiredate"), res.getFloat("sal"),
						res.getFloat("comm"), res.getInt("deptno"));
				emp.setDept(new Dept(emp.getDeptno(), res.getString("dname"),
						res.getString("loc")));
				list.add(emp);
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}
		return list;
	}

	@Override
	public List<Emp> findAll(String search, String field, String order)
			throws ModelException {

		String sql;
		String[] params = {};
		sql = "SELECT t1.empno, t1.ename, t1.job, t1.mgr, t1.hiredate, "
				+ "t1.sal, t1.comm, t1.deptno, t2.dname, t2.loc FROM emp t1 "
				+ "INNER JOIN dept t2 ON t1.deptno=t2.deptno";
		if ((search != null) && (field != null)) {
			sql += " WHERE ename  = ? " + " ORDER BY " + field + " " + order;
			params = new String[] { search };
		}
		if ((search != null) && (field == null)) {
			sql += " WHERE ename  = ? ";
			params = new String[] { search };
		}
		if ((search == null) && (field != null)) {
			sql += " ORDER BY " + field + " " + order;
		}
		System.out.println(sql);
		try {
			getConnection();			
			ResultSet res = querySql(sql, params);
			list = new ArrayList<Emp>();
			while (res.next()) {
				Emp emp = new Emp(res.getInt("empno"), res.getString("ename"),
						res.getString("job"), res.getInt("mgr"),
						res.getDate("hiredate"), res.getFloat("sal"),
						res.getFloat("comm"), res.getInt("deptno"));
				emp.setDept(new Dept(emp.getDeptno(), res.getString("dname"),
						res.getString("loc")));
				list.add(emp);
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		} finally {
			releaseConnection();
		}
		return list;
	}

}
