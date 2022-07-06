/**
 * 
 */
package com.optimissa.holidayreader;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author luis.monzon
 *
 */

@SpringBootTest
public class HolidayRestControllerIntegrationTest  {
	
	RestTemplate restTemplate = new RestTemplate();
	String fooResourceUrl
	  = "http://localhost:8080/spring-rest/foos";
	ResponseEntity<String> response
	  = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
	
//	Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);

}
