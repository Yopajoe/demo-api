package com.demo.demo_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class DemoApiApplication {

	@Autowired
	private ResourceLoader resourceLoader;

	@Autowired
	Environment env;


	public static void main(String[] args) {
		SpringApplication.run(DemoApiApplication.class, args);
	}

	@RestController
	@RequestMapping("/demo")
	class DemoController{

		@GetMapping
		public String get() throws IOException {
			Resource resource = resourceLoader.getResource("classpath:static/demo");
			String content = new String(Files.readAllBytes(Paths.get(resource.getURI())));
			return content.replace("{xxxxx}", env.getProperty("demo"));
		}
	}

}
