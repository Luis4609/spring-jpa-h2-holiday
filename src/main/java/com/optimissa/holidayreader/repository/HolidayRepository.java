/**
 * 
 */
package com.optimissa.holidayreader.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.optimissa.holidayreader.entity.Holiday;

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
