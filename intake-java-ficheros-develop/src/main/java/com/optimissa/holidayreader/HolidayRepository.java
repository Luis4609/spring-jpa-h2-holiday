package com.optimissa.holidayreader;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HolidayRepository extends CrudRepository<To_Trade_Holidays, Long> {

    List<To_Trade_Holidays> findAll();

    To_Trade_Holidays findById(int id);
}
