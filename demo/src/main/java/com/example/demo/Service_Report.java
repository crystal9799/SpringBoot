package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@Service
public class Service_Report {
	//유일성
	//System.nanoTime()
	public Map<String, Integer> getSum(HttpSession session) {
		String uuid = UUID.randomUUID().toString();
		
		Map<String, Integer> map = new HashMap<>();
		int sum = 0;
		session.setAttribute("loop", true);
		System.out.println("sessionID = " + session.getId());
		for (int i = 1; i <= 100; i++) {
			if (!(boolean) session.getAttribute("loop")) {
				System.out.println("정지완료");
				map.put("Result", sum);
				System.out.println("sessionID = "+session.getId()+"sum = "+sum);
				return map;
			}

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			sum += i;
//			System.out.println("sessionID = "+session.getId()+"sum = "+sum);
		}

		map.put("Result", sum);
		return map;
	}

	public Map<String, Integer> getSumCancel(HttpSession session) {
		session.setAttribute("loop", false);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("status", 1);
		return map;
	}
}