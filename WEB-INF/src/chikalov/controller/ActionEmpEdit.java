package chikalov.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chikalov.model.DAOManager;
import chikalov.model.DeptDAO;
import chikalov.model.IEmpDAO;
import chikalov.model.ModelException;
import chikalov.model.Emp;
import chikalov.model.EmpDAO;

public class ActionEmpEdit implements IAction {

	private IEmpDAO daoEmp;
	private ServletRequest req;
	private ServletResponse resp;
	private List<Emp> list;

	public ActionEmpEdit() {

	}

	@Override
	public String doGet(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoEmp = DAOManager.getEmpDAO();
		editEmp();
		prepareData();		
		return "EmpEd";

	}

	@Override
	public String doPost(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoEmp = DAOManager.getEmpDAO();
		updateEmp();
		return "redirect:ShowEmp";
	}

	private void editEmp() throws ModelException, ActionException {

		if (req.getParameter("id") != null) {
			int id = (new Integer((req.getParameter("id")))).intValue();
			getEmp(id);
		} else {
			throw new ActionException("no id");
		}

	}

	private void updateEmp() throws ModelException, ActionException {
		if (req.getParameter("id") == null) {
			throw new ActionException("no id");
		}
		DateFormat formatter;
		Date date;
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = new Date( (formatter.parse(req.getParameter("hiredate")).getTime()));
		} catch (ParseException e) {
			throw new ActionException("wrong date use dd-mm-yy format");
		}
		int id = (new Integer((req.getParameter("id")))).intValue();
		Emp oldemp = daoEmp.find(id);
		Emp newemp = new Emp(oldemp.getEmpno(), req.getParameter("ename"),
				req.getParameter("job"),
				(new Integer((req.getParameter("mgr")))).intValue(), date,
				(new Float((req.getParameter("sal")))).floatValue(),
				(new Float((req.getParameter("comm")))).floatValue(),
				(new Integer((req.getParameter("deptno")))).intValue());
		daoEmp.update(oldemp, newemp);
		showEmp();
	}
 
	private void showEmp() throws ModelException {
		if ((req.getParameter("search") == null)
				&& (req.getParameter("sortfield") == null)) {
			setList(daoEmp.findAll());
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

	private void getEmp(int id) throws ModelException {
		setObj(daoEmp.find(id));
	}

	public void setList(List<Emp> list) {
		req.setAttribute("datalist", list);
	}

	public void setObj(Emp obj) {
		req.setAttribute("dataobj", obj);
	}

}
