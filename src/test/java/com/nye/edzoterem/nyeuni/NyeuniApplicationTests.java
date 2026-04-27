// Integrációs teszt
package com.nye.edzoterem.nyeuni;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NyeuniApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		assertThat(applicationContext).isNotNull();
	}

	@Test
	void mainMethod_ShouldRunWithoutExceptions() {
		NyeuniApplication.main(new String[]{});
		assertThat(true).isTrue();
	}
}