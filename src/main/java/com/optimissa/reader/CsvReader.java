package com.optimissa.reader;

import java.io.FileReader;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.optimissa.holidayreader.entity.Calendario;
import com.optimissa.holidayreader.entity.Holiday;
import com.optimissa.holidayreader.repository.CalendarRepository;
import com.optimissa.holidayreader.repository.HolidayRepository;

public class CsvReader {

    //public String fileName = "C:\\Users\\luis.monzon\\Desktop\\CSVFileJava\\festivity_currencies_YYYYMMDD.csv";
    // String fileName =
    // "C:\Users\luis.monzon\Documents\workspace-spring-tool-suite-4-4.13.1.RELEASE\intake-java-ficheros-develop\files\festivity_currencies_YYYYMMDD.csv"


    /**
     * @param fileName            : directtion of the CSV file
     * @param calendarRepository: repository for the Entity Calendar
     * @param holidayRepository:  repository for the Entity Holiday
     */
    public static void readCsvWithSeparator(String fileName, CalendarRepository calendarRepository,
                                            HolidayRepository holidayRepository) {

        // Parse the CSV with the separator
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        // reader
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(fileName)).withCSVParser(csvParser).withSkipLines(1)
                .build()) {

            List<String[]> row = reader.readAll();

            // Build HOLIDAY to save it into the database
            row.forEach(x -> {
                for (int i = 0; i < x[3].length(); i++) {
                    if (x[3].charAt(i) == '1') {
                        
                        Calendar calendarJava = Calendar.getInstance();

                        calendarJava.set(Integer.parseInt(x[1]), Integer.parseInt(x[2]), i);

                        Date date = calendarJava.getTime();

                        // Get the calendar by name
                        Calendario calendar = calendarRepository.findByName(x[0]);

                        // Build the Holiday to save into the DB
                        holidayRepository.save(new Holiday(calendar.getId(), date));
                    }
                }
            });

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}