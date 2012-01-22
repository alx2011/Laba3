package chikalov.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chikalov.model.DAOManager;
import chikalov.model.IDeptDAO;
import chikalov.model.ModelException;
import chikalov.model.Dept;
import chikalov.model.DeptDAO;

public class ActionDeptEdit implements IAction {

	private IDeptDAO daoDept;
	private ServletRequest req;
	private ServletResponse resp;
	private List<Dept> list;	


	public ActionDeptEdit() {

	}

	@Override
	public String doGet(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoDept = DAOManager.getDeptDAO();
		editDept();		
		return "DeptEd";
		
	}

	@Override
	public String doPost(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoDept = DAOManager.getDeptDAO();
		updateDept();		
		return "redirect:ShowDept";
	}
	
	
	private void editDept() throws ModelException, ActionException {
		
		if (req.getParameter("id") != null) {
			int id = (new Integer((req.getParameter("id")))).intValue();
			getDept(id);			
		} else {
			throw new ActionException("no id"+ req.getParameter("id"));
		}

	}

	private void updateDept() throws ModelException, ActionException {
		if (req.getParameter("id") == null) {
			throw new ActionException("no id");
		}
		int id = (new Integer((req.getParameter("id")))).intValue();		
		Dept oldtype = daoDept.find(id);
		Dept newtype = new Dept(oldtype.getDeptno(),req.getParameter("dname"), 
				req.getParameter("loc"));
		daoDept.update(oldtype, newtype);		
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

	private void getDept(int id) throws ModelException {		
		setObj(daoDept.find(id));		
	}

	public void setList(List<Dept> list) {
		req.setAttribute("datalist", list);
	}

	
	public void setObj(Dept type) {
		req.setAttribute("dataobj", type);
	}

	
}
