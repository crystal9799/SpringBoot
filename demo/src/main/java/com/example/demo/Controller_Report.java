package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@RestController
public class Controller_Report {
	private Service_Report service;
	
    public Controller_Report(Service_Report service) {
        this.service = service;
    }
	
	@GetMapping("/getSum")
	public Map<String, Integer> getSum(HttpServletRequest request) throws InterruptedException {
		HttpSession session = request.getSession();
		return service.getSum(session);
	}
	
	@GetMapping("/getSumCancel")
	public Map<String,Integer> getSumCancel(HttpSession session)throws InterruptedException {
		return service.getSumCancel(session);
	}
	
}
