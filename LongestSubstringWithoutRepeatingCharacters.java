package com.slidingWindow;

import java.util.*;

//Problem: Given string to find the longest substring without repeating characters
//Analysis: I prefer sliding window approach (start,end) to get the longest substring without repeating characters in efficient way
//Strategy: Using hashset
//TC: O(n) for sliding the string to end
//SC: O(k) for hashset

public class LongestSubstringWithoutRepeatingCharacters {

	public static int subStringLength(String str) {
		HashSet<Character> hs=new HashSet<>();
		int start=0;
		int end=0;
		int len=0;
		int max=0;
		while (start<str.length()) {
			if (hs.contains(str.charAt(start))) {
				hs.remove(str.charAt(end));
				end++;
				len--;
			}
			else {
				hs.add(str.charAt(start));
				len++;
				max=Math.max(len, max);
				start++;
			}
		}
		return max;
		
	}


	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String str=scan.next();
		if (0>str.length() || str.length()>5*Math.pow(10, 4)) {	//	0 <= s.length <= 5 * 10^4
			System.out.println("Entered string length is high!");
			return;
		}
		System.out.println(subStringLength(str));
	}

}
