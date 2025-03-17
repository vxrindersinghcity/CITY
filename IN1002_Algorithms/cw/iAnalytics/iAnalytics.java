/**
 * Class of operations on integer arrays.
 * You MUST NOT change the signatures of the methods supplied. 
 */
 
// IN1002 Introduction to Algorithms
// Coursework 2024/2025
//
// Submission by
// Varinder Singh
// Varinder.Singh@city.ac.uk

public class iAnalytics {

    
	// Task 1: Count unique elements in an ordered array
    // Time complexity is O(n) as algorithm is linearly going through each item in array
    public int countUnique(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        int count = 1;

        // Loop through the array to find unique values.
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                count++; // Increment count if the current value is different from the previous one.
            }
        }
        System.out.println(count);
        return count;
    }


    // Task 2: Find least frequent value in an ordered array
    public int leastFrequent(int[] arr) {
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }


    // Task 3: Count elements in an ordered array less than num
    public int countLess(int[] arr, int num) {
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }
	

    // Task 4: Count elements in an ordered array between low and high
    public int countBetween(int[] arr, int low, int high) {
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }
	

    // Task 5: Find top K most frequent elements in an ordered array
    public int[] topKFrequent(int[] arr, int k) {
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Task 6: Longest contiguous subarray in ascending order
    public int[] longestAscSubarray(int[] arr) {
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }


    // Task 7: Maximum sum of a contiguous subarray with exactly k elements
    public int maxSubarraySum(int[] arr, int k) {
        // replace the following line with your implementation
        throw new UnsupportedOperationException("Not implemented yet.");
    }


}
