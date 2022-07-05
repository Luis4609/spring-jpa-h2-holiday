/**
 * 
 */
package com.optimissa.holidayreader.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.optimissa.holidayreader.entity.Calendario;

/**
 * @author luis.monzon
 *
 */
@Repository
public interface CalendarRepository extends CrudRepository<Calendario, Long> {

	// Find by id
	Calendario findById(int id);

	// Find by name
	Calendario findByName(String string);

	// Find all
	List<Calendario> findAll();

}
