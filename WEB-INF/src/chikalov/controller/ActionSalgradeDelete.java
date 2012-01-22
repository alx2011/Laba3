package chikalov.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chikalov.model.DAOManager;
import chikalov.model.ISalgradeDAO;
import chikalov.model.ModelException;
import chikalov.model.Salgrade;
import chikalov.model.SalgradeDAO;

public class ActionSalgradeDelete implements IAction {

	private ISalgradeDAO daoSalgrade;
	private ServletRequest req;
	private ServletResponse resp;	
	private List<Salgrade> list;	

	public ActionSalgradeDelete() {

	}

	@Override
	public String doGet(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoSalgrade = DAOManager.getSalgradeDAO();
		deleteSalgrade();
		return "ShowSalgrade";
	}

	@Override
	public String doPost(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void deleteSalgrade() throws ModelException, ActionException {		
		if (req.getParameter("id") == null) {
			throw new ActionException("no id");
		}
		int id = (new Integer((req.getParameter("id")))).intValue();
		daoSalgrade.delete(id);		
		showSalgrade();
	}

	private void showSalgrade() throws ModelException {		
		if ((req.getParameter("search") == null)
				&& (req.getParameter("sortfield") == null)) {
			setList( daoSalgrade.findAll());
		} else {
			setList(daoSalgrade.findAll(req.getParameter("search"),
					req.getParameter("sortfield"), req.getParameter("orderby")));
		}		
		setURL("Salgr.jsp");		
	}

	public void setURL(String URL) {
		req.setAttribute("data", URL);
	}


	public void setList(List<Salgrade> list) {
		req.setAttribute("datalist", list);
	}

	
	public void setObj(Salgrade obj) {
		req.setAttribute("dataobj", obj);
	}

	
}
