package com.anagrams.project.service;

import java.util.List;

public interface AnagramsService {
	
	public boolean areAnagrams(String word1, String word2);
	
	public boolean isValidWord(String word);
	
	public List<String> getAllPossibleAnagrams(String word1);
}
