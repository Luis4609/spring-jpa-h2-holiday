/**
 * 
 */
package com.optimissa.holidayreader.error;

/**
 * @author luis.monzon
 *
 */
public class HolidayNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HolidayNotFoundException(Long id) {
	    super("Could not find holiday " + id);
	  }
}
