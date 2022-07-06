package com.optimissa.holidayreader.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarController {


	@Autowired
	private CalendarService service;

	@GetMapping(value = "/welcome", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String welcomeAsHTML() {
		return "<html>\n" + "<header><title>Welcome</title></header>\n" + "<body>\n" + "Hello world\n" + "</body>\n"
				+ "</html>";
	}

	//Get calendar by ID
 	 @GetMapping("/{id}")
    public Calendario getCalendar(@PathVariable String id) {
        return service.getById(id);
    }
	//Get all calendars
   @GetMapping("/all")
    public List<Calendario> getAllCalendars() {
        return service.getAll();
    }

	//Order Calendars by name

	//Create a new calendar
	 @PostMapping("/")
    public ResponseEntity<Calendario> create(@RequestBody Calendario calendar)
            throws URISyntaxException {
        Calendario createdCalendar = service.create(calendar);
        if (createdCalendar == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdCalendar.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdCalendar);
        }
    }
}
