package chikalov.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chikalov.model.DAOManager;
import chikalov.model.ISalgradeDAO;
import chikalov.model.ModelException;
import chikalov.model.Salgrade;
import chikalov.model.SalgradeDAO;

public class ActionSalgradeShow implements IAction {

	private ISalgradeDAO daoSalgrade;
	private ServletRequest req;
	private ServletResponse resp;	
	private List<Salgrade> list;
	
	public ActionSalgradeShow() {
	}
	
	
	@Override
	public String doGet(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoSalgrade = DAOManager.getSalgradeDAO();
		showSalgrade();
		return "Salgr";
	}
	
	@Override
	public String doPost(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		
		return null;
	}

	
	private void showSalgrade() throws ModelException {		
		if ((req.getParameter("search") == null)
				&& (req.getParameter("sortfield") == null)) {
			setList( daoSalgrade.findAll());
		} else {
			setList(daoSalgrade.findAll(req.getParameter("search"),
					req.getParameter("sortfield"), req.getParameter("orderby")));
		}			
	}
	
	public void setList(List<Salgrade> list) {
		req.setAttribute("datalist", list);
	}	
}
