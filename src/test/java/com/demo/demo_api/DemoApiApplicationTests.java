package com.demo.demo_api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,classes = DemoApiApplication.class)
class DemoApiApplicationTests {

	@Autowired
	Environment env;

	@Test
	void contextLoads() {

		System.out.println(env.getProperty("demo")+":Demo test is completed!");
		//Assertions.fail("Test failed!");
	}
}
