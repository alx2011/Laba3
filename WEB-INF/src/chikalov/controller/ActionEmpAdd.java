package chikalov.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chikalov.model.DAOManager;
import chikalov.model.Dept;
import chikalov.model.DeptDAO;
import chikalov.model.IEmpDAO;
import chikalov.model.ModelException;
import chikalov.model.Emp;
import chikalov.model.EmpDAO;

public class ActionEmpAdd implements IAction {

	private IEmpDAO daoEmp;
	private ServletRequest req;
	private ServletResponse resp;
	private List<Emp> list;	

	public ActionEmpAdd() {

	}
	
	@Override
	public String doGet(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoEmp = DAOManager.getEmpDAO();
		prepareData();		
		return "EmpAdd";
	}

	@Override
	public String doPost(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoEmp = DAOManager.getEmpDAO();
		createEmp();
		return "redirect:ShowEmp";
	}

	private void createEmp() throws ModelException, ActionException {
		if (req.getParameter("ename") == null) {
			throw new ActionException("no name");
		}
		DateFormat formatter ; 
		Date date ; 
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = new Date( (formatter.parse(req.getParameter("hiredate")).getTime()));
		} catch (ParseException e) {
			throw new ActionException("wrong date use dd-mm-yy format");
		}
				
		Emp newemp = new Emp();
		newemp.setEname(req.getParameter("ename"));
		newemp.setJob(req.getParameter("job"));
		newemp.setMgr((new Integer((req.getParameter("mgr")))).intValue());
		newemp.setHiredate(date);
		newemp.setSal((new Float((req.getParameter("sal")))).floatValue());
		newemp.setComm((new Float((req.getParameter("comm")))).floatValue());
		newemp.setDeptno((new Integer((req.getParameter("deptno")))).intValue());
		daoEmp.create(newemp);		
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

	private void prepareData() throws ModelException{
		EmpDAO empDAO = new EmpDAO();
		DeptDAO deptDAO = new DeptDAO();
		req.setAttribute("mgrlist", empDAO.findAll());
		req.setAttribute("deptlist", deptDAO.findAll());
	}
	public void setList(List<Emp> list) {
		req.setAttribute("datalist", list);
	}

	public void setObj(Emp obj) {
		req.setAttribute("dataobj", obj);
	}
	
}
