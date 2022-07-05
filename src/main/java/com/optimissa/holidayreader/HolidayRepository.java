/**
 * 
 */
package com.optimissa.holidayreader;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author luis.monzon
 *
 */
public interface HolidayRepository extends CrudRepository<Holiday, Long> {

	//Find by id
	Holiday findById(int id);
	
	//Find all
	List<Holiday> findAll();
	
	//
	List<Holiday> findAllByIdCalendar(int id);
	
}
