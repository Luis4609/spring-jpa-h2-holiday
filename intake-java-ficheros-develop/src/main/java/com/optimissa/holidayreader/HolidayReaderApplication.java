package com.optimissa.holidayreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HolidayReaderApplication {

    private static final Logger log = LoggerFactory.getLogger(HolidayReaderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HolidayReaderApplication.class, args);

    }

    @Bean
    public CommandLineRunner demo(HolidayRepository holidayRepository, CalendarRepository calendarRepository) {
        return (args) -> {

            //Get calendar
            // fetch an individual calendar by ID
            To_Trade_Calendars calendar = calendarRepository.findById(10);
            log.info("Calendar found with findById(ID):");
            log.info("--------------------------------");
            log.info(calendar.toString());
            log.info("");

            // save a few customers
            //repository.save(new To_Trade_Calendars(99, "Bauer"));
            holidayRepository.save(new To_Trade_Holidays(1, "Vacaciones en el mar"));
            //holidayRepository.save(new To_Trade_Holidays(calendar, 2, "En el caribe" ));
            //holidayRepository.save(new To_Trade_Holidays(calendar, 3, "Montaña" ));

            //  To_Trade_Holidays holiday = holidayRepository.findById(1);
            log.warn("Holiday with ID = 1");
            //log.warn(holiday.toString());
            //repository.save(new To_Trade_Calendar(100, "Holr"));
            //repository.save(new To_Trade_Calendar(101, "Beer"));

            // fetch all calendars
            log.info("Calendars found with findAll():");
            log.info("-------------------------------");
            for (To_Trade_Calendars calendars : calendarRepository.findAll()) {
                log.info(calendars.toString());
            }
            log.info("");

            // fetch all holidays
            log.info("Holidays found with findAll():");
            log.info("-------------------------------");
            for (To_Trade_Holidays holidays : holidayRepository.findAll()) {
                log.info(holidays.toString());
            }
            log.info("");
        };
    }
}
