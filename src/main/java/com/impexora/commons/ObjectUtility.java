/**
 * 
 */
package com.impexora.commons;
import java.lang.reflect.Field;

import org.apache.log4j.Logger;
/**
 * @author ashraf_sarhan
 *
 */
public final class ObjectUtility {
	
	private static Logger logger = Logger.getLogger(ObjectUtility.class.getSimpleName());
	
	public static final String componentVersion = "$Revision: 1.1 $";
	  
	  public static final String toStringFor(Object _object) {
	    StringBuilder result = new StringBuilder();
	    String newLine = System.getProperty("line.separator");
	    result.append(_object.getClass().getName());
	    result.append(" Object {");
	    result.append(newLine);
	    

	    Field[] fields = _object.getClass().getDeclaredFields();
	    for (Field field : fields) {
	      field.setAccessible(true);
	      result.append("  ");
	      try {
	        result.append(field.getName());
	        result.append(": ");
	        result.append(field.get(_object));
	      }
	      catch (IllegalAccessException ex) {
	    	  logger.error(ex);
	      }
	      result.append(newLine);
	    }
	    result.append("}");
	    return result.toString();
	  }

}
