package chikalov.controller;

/**
 * Model exception
 */
@SuppressWarnings("serial")
public class ActionException extends Exception {

	public ActionException() {
		super();		
	}

	public ActionException(String arg0, Throwable arg1) {
		super(arg0, arg1);		
	}

	public ActionException(String arg0) {
		super(arg0);		
	}

	public ActionException(Throwable arg0) {
		super(arg0);		
	}

}
