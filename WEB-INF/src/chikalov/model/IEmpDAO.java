package chikalov.model;

import java.util.List;

public interface IEmpDAO {

	public Emp create (Emp emp) throws ModelException;
	public Emp find (int id) throws  ModelException;
	public void delete(int id) throws ModelException;
	public void update(Emp oldemp, Emp newemp) throws ModelException;
	public List<Emp> findAll() throws ModelException;	
	public List<Emp> findAll(String search, String field, String order)
			throws ModelException;	
}
