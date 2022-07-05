/**
 *
 */
package com.optimissa.holidayreader.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.optimissa.holidayreader.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.optimissa.holidayreader.entity.Holiday;
import com.optimissa.holidayreader.repository.HolidayRepository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author luis.monzon
 */
@RestController
@RequestMapping(value = "/holiday")
public class HolidayController {

    @Autowired
    private HolidayRepository repo;

    @Autowired
    private HolidayService service;


    @GetMapping(value = "/test", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String test() {
        return "<html>\n" + "<header><title>Welcome</title></header>\n" + "<body>\n" + "Hello world 323232\n" + "</body>\n"
                + "</html>";
    }


    @GetMapping("/{id}")
    public Holiday getHoliday(@PathVariable String id) {
        return service.find(id);
    }


    @GetMapping("/all")
    public List<Holiday> getAllHoliday() {
        return service.getAll();
    }

    @PostMapping("/")
    public ResponseEntity<Holiday> create(@RequestBody Holiday holiday)
            throws URISyntaxException {
        Holiday createHoliday = service.create(holiday);
        if (createHoliday == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createHoliday.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createHoliday);
        }
    }
}
