package chikalov.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chikalov.model.DAOManager;
import chikalov.model.IDeptDAO;
import chikalov.model.ModelException;
import chikalov.model.Dept;
import chikalov.model.DeptDAO;

public class ActionDeptShow implements IAction {

	private IDeptDAO daoDept;
	private ServletRequest req;
	private ServletResponse resp;	
	private List<Dept> list;
	
	public ActionDeptShow() {
	}
	
	
	@Override
	public String doGet(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoDept = DAOManager.getDeptDAO();
		showDept();
		return "Dept";
	}
	
	@Override
	public String doPost(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		
		return null;
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
}
