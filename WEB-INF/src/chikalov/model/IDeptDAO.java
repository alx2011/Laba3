package chikalov.model;

import java.util.List;

public interface IDeptDAO {

	public Dept create (Dept dept) throws ModelException;
	public Dept find (int id) throws  ModelException;
	public void delete(int id) throws ModelException;
	public void update(Dept olddept, Dept newdept) throws ModelException;
	public List<Dept> findAll() throws ModelException;	
	public List<Dept> findAll(String search, String field, String order)
			throws ModelException;	
}
