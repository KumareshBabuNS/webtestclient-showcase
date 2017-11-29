package com.example.webtestclientshowcase;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest(EchoController.class)
public class EchoControllerTests {

	@Autowired
	private WebTestClient client;

	@Test
	public void sampleEndpoint() {
		this.client.get()
				.uri("/echo/{message}", "test")
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class)
				.isEqualTo("test");
	}

}
