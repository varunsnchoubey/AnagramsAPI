package com.anagrams.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anagrams.project.service.AnagramsService;

@RestController
public class AnagramsController {
	
	@Autowired
	AnagramsService svc;
	
	private static final String ARE_ANAGRAMS = "areAnagrams";
	private static final String ANAGRAMS = "anagrams";
	
	@RequestMapping(value = "/anagrams/{string1}/{string2}")
	public ResponseEntity<Map<String, Boolean>> checkAnagrams(@PathVariable String string1, @PathVariable String string2) {
		System.out.println("string1 " + string1);
		System.out.println("string2 " + string2);
		if(!svc.isValidWord(string1) || !svc.isValidWord(string2))
			return new ResponseEntity<Map<String, Boolean>>(HttpStatus.BAD_REQUEST); // Error response
		boolean areAnagrams = svc.areAnagrams(string1, string2);
		System.out.println("words are anagrams : " + areAnagrams);
		Map<String,Boolean> response = new HashMap<>();
		response.put(ARE_ANAGRAMS, areAnagrams);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/anagrams/{string1}")
	public ResponseEntity<Map<String, List<String>>> checkWordValid(@PathVariable String string1) {
		System.out.println("string1 " + string1);
		boolean validWord = svc.isValidWord(string1);
		System.out.println("valid Word " + validWord);
		if(!validWord)
			return new ResponseEntity<Map<String,List<String>>>(HttpStatus.BAD_REQUEST); // Error response
		Map<String, List<String>> response = new HashMap<>();
		List<String> allAnagramsList = svc.getAllPossibleAnagrams(string1);
		response.put(ANAGRAMS, allAnagramsList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
