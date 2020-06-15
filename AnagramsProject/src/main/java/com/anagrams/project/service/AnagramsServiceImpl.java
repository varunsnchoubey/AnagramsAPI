package com.anagrams.project.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.anagrams.project.AnagramsHelper;

@Service
public class AnagramsServiceImpl implements AnagramsService{

	@Override
	public boolean areAnagrams(String word1, String word2) {
		if(word1.length() != word2.length())  // check for word length
			return false;
		// convert word to char array
		char[] arr1 = word1.toCharArray();
		char[] arr2 = word2.toCharArray();
		// sort both char arr in ascending order
		Arrays.sort(arr1); 
		Arrays.sort(arr2);
		
		return new String(arr1).equals(new String(arr2));
	}

	@Override
	public List<String> getAllPossibleAnagrams(String word) {
		List<String> anagramsList = AnagramsHelper.generateAllAnagrams(word);
		return anagramsList;
	}

	@Override
	public boolean isValidWord(String word) {
		if(AnagramsHelper.containsNonAlphaCharacter(word)) {
			System.out.println(word + " is not a valid word");
			return false;	
		}
		return true;
	}
	
}
