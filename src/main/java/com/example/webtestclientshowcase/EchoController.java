package com.example.webtestclientshowcase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

	@GetMapping("/echo/{value}")
	public String echo(@PathVariable String value) {
		return value;
	}
	
}
