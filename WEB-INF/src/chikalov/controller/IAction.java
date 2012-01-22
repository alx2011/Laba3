package chikalov.controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import chikalov.model.ModelException;

public interface IAction {	
	public String doGet( ServletRequest req,
			ServletResponse resp) throws ModelException, ActionException;
	public String doPost( ServletRequest req,
			ServletResponse resp) throws ModelException, ActionException;
}
