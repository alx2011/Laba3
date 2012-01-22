package chikalov.model;

import java.util.List;

public interface ISalgradeDAO {

	public Salgrade create (Salgrade salgr) throws ModelException;
	public Salgrade find (int id) throws  ModelException;
	public void delete(int id) throws ModelException;
	public void update(Salgrade oldsalgr, Salgrade newsalgr) throws ModelException;
	public List<Salgrade> findAll() throws ModelException;	
	public List<Salgrade> findAll(String search, String field, String order)
			throws ModelException;	
}
