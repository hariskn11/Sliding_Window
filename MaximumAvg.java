package com.slidingWindow;

//Problem: Given array of numbers wanted to find the maximum average of k elements
//Analysis: I prefer static sliding window approach bcz in qn has contiguous subarray
//Strategy: Using window adding k elements
//TC: O(k) for first window + O(n-k) for rest of windows -> O(n)
//SC: O(1)

import java.util.Scanner;

public class MaximumAvg {

	public static double max_avg(int[] arr,int k) {
		double max_sum=0;
		for (int i=0;i<k;i++) {
			max_sum+=arr[i];
		}
		double windowSum=max_sum;
		for (int i=k;i<arr.length;i++) {
			windowSum=windowSum-arr[i-k]+arr[i];
            max_sum=Math.max(max_sum,windowSum);
		}
		return max_sum/k;
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int arrLen=scan.nextInt();
		if (1>arrLen || arrLen>Math.pow(10, 5)) {	//1<=n<=10^5
			System.out.println("Entered array length is out of limit!");
			return;
		}
		int[] arr=new int[arrLen];
		for (int i=0;i<arrLen;i++) {
			arr[i]=scan.nextInt();
			if (-1*Math.pow(10, 4)>arr[i] || arr[i]>Math.pow(10, 4)) {	//-10^4<=arr[i]<=10^4
				System.out.println("Entered value is out of limit!");
				return;
			}
		}
		int k=scan.nextInt();
		if (1>k || k>arrLen) {	//1<=k<=nums.length
			System.out.println("Entered k value is invalid!"); 
		}
		System.out.println(max_avg(arr,k));
	}

}
