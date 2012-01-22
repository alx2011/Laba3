package chikalov.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chikalov.model.DAOManager;
import chikalov.model.IEmpDAO;
import chikalov.model.ModelException;
import chikalov.model.Emp;
import chikalov.model.EmpDAO;

public class ActionEmpDelete implements IAction {

	private IEmpDAO daoEmp;
	private ServletRequest req;
	private ServletResponse resp;	
	private List<Emp> list;	

	public ActionEmpDelete() {

	}

	@Override
	public String doGet(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoEmp = DAOManager.getEmpDAO();
		deleteEmp();
		return "Emp";
	}

	@Override
	public String doPost(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void deleteEmp() throws ModelException, ActionException {		
		if (req.getParameter("id") == null) {
			throw new ActionException("no id");
		}
		int id = (new Integer((req.getParameter("id")))).intValue();
		daoEmp.delete(id);		
		showEmp();
	}

	private void showEmp() throws ModelException {		
		if ((req.getParameter("search") == null)
				&& (req.getParameter("sortfield") == null)) {
			setList( daoEmp.findAll());
		} else {
			setList(daoEmp.findAll(req.getParameter("search"),
					req.getParameter("sortfield"), req.getParameter("orderby")));
		}			
	}

	public void setList(List<Emp> list) {
		req.setAttribute("datalist", list);
	}

	
	public void setObj(Emp obj) {
		req.setAttribute("dataobj", obj);
	}

	
}
