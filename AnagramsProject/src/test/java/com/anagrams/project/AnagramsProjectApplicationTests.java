package com.anagrams.project;

import static org.assertj.core.api.Assertions.assertThat;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.anagrams.project.controller.AnagramsController;


@SpringBootTest
class AnagramsProjectApplicationTests {

	@Autowired
	private AnagramsController controller;
	
	private static final String ANAGRAMS_TRUE  = "{areAnagrams=true}";
	private static final String ANAGRAMS_FALSE = "{areAnagrams=false}";
	private static final String BAD_REQUEST = "400 BAD_REQUEST";
	
	@Test
	void verifyAnagramsTrue() {
		ResponseEntity response = controller.checkAnagrams("abc", "bac");
		String json = response.getBody().toString();
		System.out.println("json response is "+ json);
		assertThat(json).isEqualTo(ANAGRAMS_TRUE);		
	}
	
	@Test
	void verifyAnagramsFalse() {
		ResponseEntity response = controller.checkAnagrams("abc", "cde");
		String json = response.getBody().toString();
		System.out.println("json response is "+ json);
		assertThat(json).isEqualTo(ANAGRAMS_FALSE);
				
	}
	
	@Test
	void verifyBadRequest() {
		ResponseEntity response = controller.checkAnagrams("abc", "cde*");
		String statusCode = response.getStatusCode().toString();
		System.out.println("statusCode response is "+ statusCode);
		assertThat(statusCode).isEqualTo(BAD_REQUEST);
				
	}

}
