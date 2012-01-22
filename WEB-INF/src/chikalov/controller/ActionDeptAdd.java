package chikalov.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chikalov.model.DAOManager;
import chikalov.model.IDeptDAO;
import chikalov.model.ModelException;
import chikalov.model.Dept;
import chikalov.model.DeptDAO;

public class ActionDeptAdd implements IAction {

	private IDeptDAO daoDept;
	private ServletRequest req;
	private ServletResponse resp;
	private List<Dept> list;	

	public ActionDeptAdd() {

	}
	
	@Override
	public String doGet(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoDept = DAOManager.getDeptDAO();		
		return "DeptAdd";
	}

	@Override
	public String doPost(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoDept = DAOManager.getDeptDAO();
		createDept();
		return "redirect:ShowDept";
	}

	private void createDept() throws ModelException, ActionException {
		if (req.getParameter("dname") == null) {
			throw new ActionException("no name");
		}
		if (req.getParameter("loc") == null) {
			throw new ActionException("no location");
		}
		
		Dept newdept = new Dept();
		newdept.setDname(req.getParameter("dname"));
		newdept.setLoc(req.getParameter("loc"));
		daoDept.create(newdept);		
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
