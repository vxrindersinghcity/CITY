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
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                count++; // Increment count if the current value is different from the previous one.
            }
        }
        return count;
    }


    // Task 2: Find least frequent value in an ordered array
    // Time complexity is O(n) as algorithm is linearly going through each item in array
    public int leastFrequent(int[] arr) {
        int minFrequency = arr.length;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            int value = arr[i];

            // Count occurrences of arr[i]
            while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                count++;
                i++;
            }

            // Step 2: Update least frequent element
            if (count < minFrequency || (count == minFrequency && value < minValue)) {
                minFrequency = count;
                minValue = value;
            }

        }

        return minValue;

    }


    // Task 3: Count elements in an ordered array less than num
    // Time complexity is O(n) as algorithm is linearly going through each item in array
    public int countLess(int[] arr, int num) {
      int count = 0;
      for (int i = 0; i < arr.length; i++) {
          if (arr[i] < num) {
              count++;
          }else{
              break;
          }
      }
      return count;
    }


    // Task 4: Count elements in an ordered array between low and high
    // Time complexity is O(n)
    public int countBetween(int[] arr, int low, int high) {
      int count = 0;
      for(int i = 0; i < arr.length; i++) {
          if(arr[i] >= low && arr[i] <= high) {
              count++;
          }
      }
      return count;
    }


    // Task 5: Find top K most frequent elements in an ordered array
    //O(n^2) nested loops required to count frequencies and rank them.
    public int[] topKFrequent(int[] arr, int k) {
        int[][] frequentArr = new int[countUnique(arr)][2]; // Stores {value, frequency}
        int[] result = new int[k];

        int uniqueCount = 0; // Tracks the number of unique values
        int j = 0;           // Iterator for counting occurrences

        // Step 1: Count frequencies and store in frequentArr
        while (j < arr.length) {
            int value = arr[j];
            int count = 0;

            // Count occurrences of arr[j]
            while (j < arr.length && arr[j] == value) {
                count++;
                j++; // Move forward for the same value
            }

            // Store the value and its frequency
            frequentArr[uniqueCount][0] = value; // Value
            frequentArr[uniqueCount][1] = count; // Frequency
            uniqueCount++; // Move to the next unique number
        }

        int idx = 0; // Index to track filling the result array

        while (idx < k) { // Ensure we don't exceed the length of the result array
            int maxFreq = 0;
            int maxIdx = -1;

            // Find the value with the maximum frequency
            for (int i = 0; i < uniqueCount; i++) {
                if (frequentArr[i][1] > maxFreq) {
                    maxFreq = frequentArr[i][1];
                    maxIdx = i;
                } else if (frequentArr[i][1] == maxFreq && frequentArr[i][0] < frequentArr[maxIdx][0]) {
                    // Break ties by choosing the smaller value
                    maxIdx = i;
                }
            }

            // Add the value with the maximum frequency to the result
            if (maxIdx != -1) {
                result[idx] = frequentArr[maxIdx][0]; // Store the value
                frequentArr[maxIdx][1] = -1; // Mark the frequency as used
                idx++; // Move to the next index in result
            } else {
                break; // Break if there are no valid values left
            }
        }

        return result;
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
