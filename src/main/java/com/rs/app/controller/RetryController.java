package com.rs.app.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.app.aspect.Retry;
import com.rs.app.service.RetryService;

@RestController
@RequestMapping(value = RetryController.RETRY_CONTROLLER_BASE_URI)
public class RetryController {
	protected static final String RETRY_CONTROLLER_BASE_URI = "/retry";

	@Autowired
	private RetryService retryService;

	@Autowired
	private RetryTemplate retryTemplate;

//	@Retryable(maxAttempts = 3, backoff = @Backoff(delay = 3000), value = Exception.class)
	@GetMapping("/name")
	@Retry
	public String name() throws InterruptedException, ExecutionException {
		System.out.println("name...");
//		CompletableFuture<String> future = CompletableFuture.supplyAsync(retryService::getName);
//		future.thenRun(() -> System.out.println("Success")).exceptionally(th -> {
//			System.out.println("Exception...");
//			//throw new RuntimeException(th.getMessage());
//			throw new NumberFormatException(th.getMessage());
//		});
//		future.join();
//		return future.get();
		
		
//		String name = retryTemplate.execute(retryContext -> {
//			return retryService.getName();
//		});
//		return name;
		
		
		return retryService.getName();
	}

//	@Recover
	public String recover(NumberFormatException nfex) {
		System.out.println("recover NumberFormatException ");
		return nfex.getMessage();
	}

	@Recover
	public String recover(Exception ex) {
		System.out.println("recover Exception");
		return ex.getMessage();
	}
}
