package com.slidingWindow;

import java.util.*;

//Problem: Given two strings, I wanted to Find All Anagrams in a String 
//Analysis:	Since wanted to find all anagrams in a string I prefer sliding window approach
//Strategy: Using sliding window 
//TC: O(n+m) 
//SC: O(1)

public class FindAllAnagramsinaString {

	public static ArrayList<Integer> anagram(String str1, String str2) {
		ArrayList<Integer> al=new ArrayList<>();
		HashMap<Character,Integer> map=new HashMap<>();
		HashMap<Character,Integer> window=new HashMap<>();
		for (char ch:str2.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		int count=0;
		int left=0;
		for (int right=0;right<str1.length();right++) {
			char rightCh=str1.charAt(right);
			window.put(rightCh, window.getOrDefault(rightCh, 0)+1);
			if (map.containsKey(rightCh) && window.get(rightCh).intValue()==map.get(rightCh).intValue()) {
				count++;
			}
			if (right-left+1 == str2.length()) {
				if (count==map.size()) {
					al.add(left);
				}	
				
				char leftCh=str1.charAt(left);
				if (map.containsKey(leftCh) && window.get(leftCh).intValue()==map.get(leftCh).intValue()) {
					count--;
				}
				window.put(leftCh, window.get(leftCh)-1);
				if (window.get(leftCh)==0) window.remove(leftCh);
				left++;
			}
			
		}
		return al;
	}

	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String str1=scan.next();
		if (1>str1.length() || str1.length()>3*Math.pow(10, 4)) {	//1 <= str1.length <= 3 * 10^4
			System.out.println("Entered string size is out of limit!");
			return;
		}
		String str2=scan.next();
		if (1>str2.length() || str2.length()>3*Math.pow(10, 4)) {	//1 <= str2.length <= 3 * 10^4
			System.out.println("Entered string size is out of limit!");
			return;
		}
		ArrayList<Integer>al=anagram(str1,str2);
		System.out.print("[");
		for (int i:al) {
			System.out.print(i+", ");
		}
		System.out.print("]");
	}

}
