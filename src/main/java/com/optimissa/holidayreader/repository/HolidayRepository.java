/**
 * 
 */
package com.optimissa.holidayreader.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optimissa.holidayreader.entity.Holiday;

/**
 * @author luis.monzon
 *
 */
@Repository
public interface HolidayRepository extends CrudRepository<Holiday, Long> {

	// Find by id
	Holiday findById(long id);

	// Find all
	List<Holiday> findAll();

	//
	List<Holiday> findAllByIdCalendar(int id);

}
