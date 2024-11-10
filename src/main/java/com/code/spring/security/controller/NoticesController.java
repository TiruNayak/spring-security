package com.code.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {
	
	@GetMapping("/notices")
	public String getNotices() {
		return "NoticesController :: Notice Details";
	}

}
