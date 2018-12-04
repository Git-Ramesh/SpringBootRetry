package com.rs.app.service;

import org.springframework.stereotype.Service;

@Service
public class RetryService {

	public String getName() {
		System.out.println("getName");
		try {
			Integer.parseInt("Ramesh");
		}catch (Exception ex) {
			System.out.println("catch...");
			throw ex;
		}
		
		return "Ramesh";
	}

	private static final void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
