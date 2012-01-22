package chikalov.model;

public class Salgrade {
	private int grade;
	private float minsal;
	private float hisal;
	public Salgrade() {
		
	}
	/**
	 * @param grade
	 * @param minsal
	 * @param hisal
	 */
	public Salgrade(int grade, float minsal, float hisal) {
		super();
		this.grade = grade;
		this.minsal = minsal;
		this.hisal = hisal;
	}
	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	/**
	 * @return the minsal
	 */
	public float getMinsal() {
		return minsal;
	}
	/**
	 * @param minsal the minsal to set
	 */
	public void setMinsal(float minsal) {
		this.minsal = minsal;
	}
	/**
	 * @return the hisal
	 */
	public float getHisal() {
		return hisal;
	}
	/**
	 * @param hisal the hisal to set
	 */
	public void setHisal(float hisal) {
		this.hisal = hisal;
	}
	
}
