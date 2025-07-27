package com.slidingWindow;

//Problem: Given array of elements wanted to find the minimum length subarray sum
//Analysis: I prefer dynamic sliding window approach to get the min length subarray sum
//Strategy: Using dynamic sliding window
//TC: O(n) for linear traversal in array
//SC: O(1)

public class minLengthOfSum {

	public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowStart = 0;
 
        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            windowSum += nums[windowEnd];  // Expand the window
 
            while (windowSum >= s) {
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
 
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
 
	public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
 
        int result = minSubArrayLen(s, nums);
        System.out.println("Minimum length of subarray with sum ≥ " + s + " is: " + result);
    }
}