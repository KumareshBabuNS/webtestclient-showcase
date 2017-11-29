package com.example.webtestclientshowcase;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EchoControllerIntegrationTests {

	@Autowired
	private WebTestClient client;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void sampleEndpointWithClient() {
		this.client.get()
				.uri("/echo/{message}", "test")
				.exchange()
				.expectStatus().isOk()
				.expectBody(String.class)
				.isEqualTo("test");
	}

	@Test
	public void sampleEndpointWithRestTemplate() {
		String actual = this.restTemplate.getForObject("/echo/{message}", String.class,
				"test");
		assertThat(actual).isEqualTo("test");
	}

}
