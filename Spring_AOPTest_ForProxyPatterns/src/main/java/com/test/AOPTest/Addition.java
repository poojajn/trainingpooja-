package com.test.AOPTest;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component("addition")
@Configuration
public class Addition {

	int add(int a, int b) {
		return a + b;
	}

	int sub(int a, int b) {
		return a - b;
	}

}
