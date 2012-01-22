package chikalov.model;

public class DAOManager {

	public static IDeptDAO getDeptDAO () throws ModelException{
		return new DeptDAO();
	}
	public static IEmpDAO getEmpDAO () throws ModelException{
		return new EmpDAO();
	}
	public static ISalgradeDAO getSalgradeDAO () throws ModelException{
		return new SalgradeDAO();
	}	
}
