package com.test.AOPTest;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
@Aspect
@EnableAspectJAutoProxy
public class AdditionAspect {
	public AdditionAspect() {
		System.out.println("AdditionAspect.AdditionAspect()");
	}

	@After("execution(* Addition.add(..))")
	public void execute(Joinpoint jp) {
		System.out.println("excuting...");
	}
}
