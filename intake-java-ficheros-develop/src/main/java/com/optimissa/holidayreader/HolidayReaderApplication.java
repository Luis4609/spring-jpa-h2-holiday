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
    public CommandLineRunner demo(CalendarRepository repository) {
        return (args) -> {

            // save a few customers
             repository.save(new To_Trade_Calendars(99, "Bauer"));
//             repository.save(new To_Trade_Calendar(100, "Holr"));
//             repository.save(new To_Trade_Calendar(101, "Beer"));


            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (To_Trade_Calendars customer : repository.findAll()) {
                log.info(customer.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            To_Trade_Calendars customer = repository.findById(1);
            log.info("Customer found with findById(1L):");
            log.info("--------------------------------");
            log.info(customer.toString());
            log.info("");

            log.info("");
        };
    }

}
