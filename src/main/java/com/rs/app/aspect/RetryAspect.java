package com.rs.app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RetryAspect {
	private @Autowired RetryTemplate retryTemplate;

	@Around("@annotation(com.rs.app.aspect.Retry)")
	public Object retry(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("pointCut");
		return retryTemplate.execute(retryContext -> joinPoint.proceed());
	}
}
