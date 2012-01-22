package chikalov.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chikalov.model.DAOManager;
import chikalov.model.ISalgradeDAO;
import chikalov.model.ModelException;
import chikalov.model.Salgrade;
import chikalov.model.SalgradeDAO;

public class ActionSalgradeAdd implements IAction {

	private ISalgradeDAO daoSalgrade;
	private ServletRequest req;
	private ServletResponse resp;
	private List<Salgrade> list;	

	public ActionSalgradeAdd() {

	}
	
	@Override
	public String doGet(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoSalgrade = DAOManager.getSalgradeDAO();		
		return "SalgrAdd";
	}

	@Override
	public String doPost(ServletRequest req, ServletResponse resp)
			throws ModelException, ActionException {
		this.req = req;
		this.resp = resp;
		daoSalgrade = DAOManager.getSalgradeDAO();
		createSalgrade();
		return "redirect:ShowSalgrade";
	}

	private void createSalgrade() throws ModelException, ActionException {
		if (req.getParameter("minsal") == null) {
			throw new ActionException("no minimal salary");
		}
		if (req.getParameter("hisal") == null) {
			throw new ActionException("no hi salary");
		}
				
		Salgrade newsalgr = new Salgrade();
		newsalgr.setMinsal((new Float((req.getParameter("minsal")))).floatValue());
		newsalgr.setHisal((new Float((req.getParameter("hisal")))).floatValue());
		daoSalgrade.create(newsalgr);		
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

	public void setList(List<Salgrade> list) {
		req.setAttribute("datalist", list);
	}

	public void setObj(Salgrade obj) {
		req.setAttribute("dataobj", obj);
	}
	
}
