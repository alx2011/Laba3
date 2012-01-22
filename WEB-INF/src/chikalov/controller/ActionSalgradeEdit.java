package chikalov.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chikalov.model.DAOManager;
import chikalov.model.ISalgradeDAO;
import chikalov.model.ModelException;
import chikalov.model.Salgrade;
import chikalov.model.SalgradeDAO;

public class ActionSalgradeEdit implements IAction {

	private ISalgradeDAO daoSalgrade;
	private ServletRequest req;
	private ServletResponse resp;
	private List<Salgrade> list;	


	public ActionSalgradeEdit() {

	}

	@Override
	public String doGet(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoSalgrade = DAOManager.getSalgradeDAO();
		editSalgrade();
		
		return "SalgrEd";
		
	}

	@Override
	public String doPost(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoSalgrade = DAOManager.getSalgradeDAO();
		updateSalgrade();		
		return "redirect:ShowSalgrade";
	}
	
	
	private void editSalgrade() throws ModelException, ActionException {
		
		if (req.getParameter("id") != null) {
			int id = (new Integer((req.getParameter("id")))).intValue();
			getSalgrade(id);			
		} else {
			throw new ActionException("no id");
		}

	}

	private void updateSalgrade() throws ModelException, ActionException {
		if (req.getParameter("id") == null) {
			throw new ActionException("no id");
		}
		int id = (new Integer((req.getParameter("id")))).intValue();		
		Salgrade oldsalgr = daoSalgrade.find(id);
		Salgrade newsalgr = new Salgrade(oldsalgr.getGrade(),(new Float((req.getParameter("minsal")))).floatValue(), 
				(new Float((req.getParameter("hisal")))).floatValue());
		daoSalgrade.update(oldsalgr, newsalgr);		
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
		
	}

	private void getSalgrade(int id) throws ModelException {		
		setObj(daoSalgrade.find(id));		
	}

	public void setList(List<Salgrade> list) {
		req.setAttribute("datalist", list);
	}

	
	public void setObj(Salgrade obj) {
		req.setAttribute("dataobj", obj);
	}

	
}
