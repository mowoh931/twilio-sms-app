package com.baar.twiliosmsapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
class TwilioSmsAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void applicationStartsSuccessfully() {
		assertDoesNotThrow(() -> TwilioSmsAppApplication.main(new String[] {}));
	}

}
