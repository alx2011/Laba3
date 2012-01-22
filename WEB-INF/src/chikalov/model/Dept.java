package chikalov.model;

public class Dept {
	public Dept() {
		
	}
	
	/**
	 * @param comp_id
	 * @param name
	 * @param description
	 */
	public Dept(int deptno, String dname, String loc) {		
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}

	private int deptno;
	private String dname;
	private String loc;
	
	/**
	 * @return the comp_id
	 */
	public int getDeptno() {
		return deptno;
	}
	/**
	 * @param comp_id the comp_id to set
	 */
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	/**
	 * @return the name
	 */
	public String getDname() {
		return dname;
	}
	/**
	 * @param name the name to set
	 */
	public void setDname(String name) {
		this.dname = name;
	}
	/**
	 * @return the description
	 */
	public String getLoc() {
		return loc;
	}
	/**
	 * @param description the description to set
	 */
	public void setLoc(String description) {
		this.loc = description;
	}
	
}
