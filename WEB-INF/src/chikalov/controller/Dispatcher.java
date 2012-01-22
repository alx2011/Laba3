/**
 * 
 */
package chikalov.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import chikalov.model.ModelException;

/**
 * Controller. Processes events from a views passes information in a model
 * Co-operates through interfaces
 */
public class Dispatcher extends HttpServlet {
	public static final Logger LOG = Logger.getLogger(Dispatcher.class);

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		LOG.info("Ends of init controller");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		LOG.info("Recieve GET " + req.getParameter("action"));
		LOG.info("Recieve GET id " + req.getParameter("id"));
		getActionName(req);
		try {			
			ActionConcreteFactory factory = new ActionConcreteFactory();
			//IAction action = factory.create(req.getParameter("action"));
			IAction action = factory.create(getActionName(req));
			String URL = action.doGet( req, resp);
			if (URL.contains("redirect:")) {
				resp.sendRedirect(URL.substring(9, URL.length()));
				LOG.info("get redirect" + route(URL.substring(9, URL.length())));
			} else {
			req.getRequestDispatcher(route(URL)).forward(req, resp);	
			}
			LOG.info("END of GET " + req.getParameter("action"));

		} catch (ModelException e) {
			req.setAttribute("data", "/Error.jsp");
			req.setAttribute("error", e.getMessage());
			req.getRequestDispatcher("View.jsp").forward(req, resp);
		} catch (ActionException e) {
			req.setAttribute("data", "/Error.jsp");
			req.setAttribute("error", e.getMessage());
			req.getRequestDispatcher("View.jsp").forward(req, resp);
		}		
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		LOG.info("Recieve POST " + req.getParameter("action"));		
		getActionName(req);
		try {			
			ActionConcreteFactory factory = new ActionConcreteFactory();
			//IAction action = factory.create(req.getParameter("action"));
			IAction action = factory.create(getActionName(req));
			String URL = action.doPost(req, resp);			
			if (URL.contains("redirect")) {
				LOG.info("post redirect" + route(URL.substring(9, URL.length())));
				resp.sendRedirect(URL.substring(9, URL.length()));
			} else {
			req.getRequestDispatcher(route(URL)).forward(req, resp);	
			}			
			LOG.info("END of POST " + req.getParameter("action"));

		} catch (ModelException e) {
			req.setAttribute("data", "/Error.jsp");
			req.setAttribute("error", e.getMessage());
			req.getRequestDispatcher("View.jsp").forward(req, resp);
		} catch (ActionException e) {
			req.setAttribute("data", "/Error.jsp");
			req.setAttribute("error", e.getMessage());
			req.getRequestDispatcher("View.jsp").forward(req, resp);
		}		
	}

	private String getActionName(HttpServletRequest request) {
        String path = request.getServletPath();
        String rpath;
        LOG.info("Recieve " + path);	
        LOG.info("Recieve " + path.substring(1, path.length()));
        if (path.indexOf("&") >0) {
        	rpath=path.substring(1, path.indexOf("?"));
        } else rpath = path.substring(1, path.length());
        return rpath;

    }
	
	private String route (String rt) {
		return "/"+rt+".jsp";
	}


}
