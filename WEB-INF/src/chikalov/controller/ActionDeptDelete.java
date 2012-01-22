package chikalov.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chikalov.model.DAOManager;
import chikalov.model.IDeptDAO;
import chikalov.model.ModelException;
import chikalov.model.Dept;
import chikalov.model.DeptDAO;

public class ActionDeptDelete implements IAction {

	private IDeptDAO daoDept;
	private ServletRequest req;
	private ServletResponse resp;	
	private List<Dept> list;	

	public ActionDeptDelete() {

	}

	@Override
	public String doGet(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoDept = DAOManager.getDeptDAO();
		deleteDept();
		return "Dept";
	}

	@Override
	public String doPost(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void deleteDept() throws ModelException, ActionException {		
		if (req.getParameter("id") == null) {
			throw new ActionException("no id");
		}
		int id = (new Integer((req.getParameter("id")))).intValue();
		daoDept.delete(id);		
		showDept();
	}

	private void showDept() throws ModelException {		
		if ((req.getParameter("search") == null)
				&& (req.getParameter("sortfield") == null)) {
			setList( daoDept.findAll());
		} else {
			setList(daoDept.findAll(req.getParameter("search"),
					req.getParameter("sortfield"), req.getParameter("orderby")));
		}		
	}

	public void setList(List<Dept> list) {
		req.setAttribute("datalist", list);
	}

	
	public void setObj(Dept type) {
		req.setAttribute("dataobj", type);
	}

	
}
