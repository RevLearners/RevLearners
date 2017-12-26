package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import io.revlearners.SpringDemoApplication;
import io.revlearners.model.bo.TopicBo;
import io.revlearners.util.commons.configs.WebConstants;

@SpringBootTest(classes = SpringDemoApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringDemoApplicationTests extends AbstractTestNGSpringContextTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() {
	}
	
//	Tests that topic service can fetch and DB is pre-loaded
	@Test
	public void topicPersistence() {
//		Object[] topics = this.restTemplate.getForObject("/api/getTopics", Object[].class);
		ResponseEntity<List<TopicBo>> topicsResponse = this.restTemplate.exchange("/api/getTopics", HttpMethod.GET, null, new ParameterizedTypeReference<List<TopicBo>>() {
		});
		List<TopicBo> topics = topicsResponse.getBody();
		assertThat(topicsResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertTrue(topics != null);
	}

}
