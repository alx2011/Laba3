package chikalov.model;

/**
 * Model exception
 */
@SuppressWarnings("serial")
public class ModelException extends Exception {

	public ModelException() {
		super();		
	}

	public ModelException(String arg0, Throwable arg1) {
		super(arg0, arg1);		
	}

	public ModelException(String arg0) {
		super(arg0);		
	}

	public ModelException(Throwable arg0) {
		super(arg0);		
	}

}
