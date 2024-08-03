package com.baar.twiliosmsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwilioSmsAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(TwilioSmsAppApplication.class, args);
		System.out.println("Starting Twilio");
	}

}
