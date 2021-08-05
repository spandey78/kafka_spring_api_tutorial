package com.npp.invokeapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InvokeapiApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(InvokeapiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InvokeapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running InvokeapiApplication");

		final String uri = "http://localhost:9080/event/publish?nBIC=XXX&eBIC=XXX&status=XXX";

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);
	}
}
