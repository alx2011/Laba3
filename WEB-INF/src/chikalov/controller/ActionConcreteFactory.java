package chikalov.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

import chikalov.model.ModelException;

/**
 * Create concrete view object
 * 
 * @author Admin
 * 
 */
public class ActionConcreteFactory {	

	
	protected Map listActions = getDefaultMap();
	
	@SuppressWarnings("unchecked")
	private Map<String,Class> getDefaultMap() {
        Map<String,Class> map = new HashMap();        
        map.put("ShowDept", ActionDeptShow.class);        
        map.put("AddDept", ActionDeptAdd.class);
        map.put("CreateDept", ActionDeptAdd.class);
        map.put("UpdateDept", ActionDeptEdit.class);
        map.put("EditDept", ActionDeptEdit.class);
        map.put("DeleteDept", ActionDeptDelete.class);
        map.put("ShowSalgrade", ActionSalgradeShow.class);        
        map.put("AddSalgrade", ActionSalgradeAdd.class);
        map.put("CreateSalgrade", ActionSalgradeAdd.class);
        map.put("UpdateSalgrade", ActionSalgradeEdit.class);
        map.put("EditSalgrade", ActionSalgradeEdit.class);
        map.put("DeleteSalgrade", ActionSalgradeDelete.class);
        map.put("ShowEmp", ActionEmpShow.class);        
        map.put("AddEmp", ActionEmpAdd.class);
        map.put("CreateEmp", ActionEmpAdd.class);
        map.put("UpdateEmp", ActionEmpEdit.class);
        map.put("EditEmp", ActionEmpEdit.class);
        map.put("DeleteEmp", ActionEmpDelete.class);
        return map;
    }
	 public IAction create(String actionName) {
	        Class klass = (Class)listActions.get(actionName);;
	        
	        IAction actionInstance = null;
	        try {
	            actionInstance = (IAction) klass.newInstance();
	        } catch (InstantiationException ex) {
	            
	        } catch (IllegalAccessException ex) {
	            
	        }
	        return actionInstance;
	    }

}
