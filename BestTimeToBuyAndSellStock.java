package com.slidingWindow;

import java.util.*;

//Problem: Given a array of stock prices, task is to find the maximum profit that can take from the stock prices in array
//Analysis: I prefer sliding window with two pointers approach to get the longest substring without repeating characters in efficient way
//Strategy: Using min profit, max profit and cur profit, that cur profit=prices of stock-min profit, max profit=max of (max profit or cur profit)
//TC: O(n) for iteration in the array
//SC: O(1) for 

public class BestTimeToBuyAndSellStock {
	
	public static int stock(int[] arr) {
		int min_profit=Integer.MAX_VALUE;
		int max_profit=0;
		int cur_profit=0;
		for (int i=0;i<arr.length;i++) {
			if (arr[i]<min_profit) {
				min_profit=arr[i];
			}
			cur_profit=arr[i]-min_profit;
			max_profit=Math.max(max_profit, cur_profit);
		}
		return max_profit;
	}


	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int arrLen=scan.nextInt();
		if (1>arrLen || arrLen>Math.pow(10, 5)) {	// 1 <= prices.length <= 10^5
			System.out.println("Entered prices length is out of limit!");
			return;
		}
		int[] arr=new int[arrLen];
		for (int i=0;i<arrLen;i++) {
			arr[i]=scan.nextInt();
			if (0> arr[i] || arr[i]>Math.pow(10, 4)) {	// 0 <= prices[i] <= 10^4
				System.out.println("Entered price is out of limit!");
				return;
			}
		}
		System.out.println(stock(arr));
	}

}
