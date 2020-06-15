package com.anagrams.project;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;  

public class AnagramsHelper {
	
	
	public static boolean containsNonAlphaCharacter(String word) {
		Pattern pattern = Pattern.compile("(\\W)+"); // regex for matching non-alpha character
		Matcher matcher = pattern.matcher(word);
		return matcher.find();
	}
	
	public static List<String> generateAllAnagrams(String word) {
        List<String> anagramsList = new ArrayList<>();
        permutations("", word, anagramsList);
        return anagramsList;
    }

    private static void permutations(String prefix, String suffix, List<String> anagramsList) {

        if (suffix.length() == 0) {
            anagramsList.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                permutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), anagramsList);
            }
        }
    }

}
