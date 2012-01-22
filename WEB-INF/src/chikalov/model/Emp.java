package chikalov.model;

import java.sql.Date;



public class Emp {
	/**
	 * @param empno
	 * @param ename
	 * @param job
	 * @param mgr
	 * @param hiredate
	 * @param sal
	 * @param comm
	 * @param deptno
	 */
	public Emp(int empno, String ename, String job, int mgr, Date hiredate,
			float sal, float comm, int deptno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}

	private int empno;
	private String ename;
	private String job;
	private int mgr;
	private Date hiredate;
	private float sal;
	private float comm;
	private int deptno;
	private Dept dept;
	private Salgrade salgrade;
	
	public Emp() {
	}

	/**
	 * @return the empno
	 */
	public int getEmpno() {
		return empno;
	}

	/**
	 * @param empno the empno to set
	 */
	public void setEmpno(int empno) {
		this.empno = empno;
	}

	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the mgr
	 */
	public int getMgr() {
		return mgr;
	}

	/**
	 * @param mgr the mgr to set
	 */
	public void setMgr(int mgr) {
		this.mgr = mgr;
	}

	/**
	 * @return the hiredate
	 */
	public Date getHiredate() {
		return hiredate;
	}

	/**
	 * @param hiredate the hiredate to set
	 */
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	/**
	 * @return the sal
	 */
	public float getSal() {
		return sal;
	}

	/**
	 * @param sal the sal to set
	 */
	public void setSal(float sal) {
		this.sal = sal;
	}

	/**
	 * @return the comm
	 */
	public float getComm() {
		return comm;
	}

	/**
	 * @param comm the comm to set
	 */
	public void setComm(float comm) {
		this.comm = comm;
	}

	/**
	 * @return the deptno
	 */
	public int getDeptno() {
		return deptno;
	}

	/**
	 * @param deptno the deptno to set
	 */
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	/**
	 * @return the dept
	 */
	public Dept getDept() {
		return dept;
	}

	/**
	 * @param dept the dept to set
	 */
	public void setDept(Dept dept) {
		this.dept = dept;
	}

	/**
	 * @return the salgrade
	 */
	public Salgrade getSalgrade() {
		return salgrade;
	}

	/**
	 * @param salgrade the salgrade to set
	 */
	public void setSalgrade(Salgrade salgrade) {
		this.salgrade = salgrade;
	}
}
