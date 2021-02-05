// Longest Harmonious Subsequence
// We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

// Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

// A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

 

// Example 1:

// Input: nums = [1,3,2,2,5,2,3,7]
// Output: 5
// Explanation: The longest harmonious subsequence is [3,2,2,2,3].




class Solution {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int el: nums){
            int currfreq = map.getOrDefault(el, 0);
            map.put(el, currfreq+1);
        }

        int maxLHS = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int currKey = entry.getKey();
            int freq =entry.getValue();
            int currLHS = 0;
            if(map.containsKey(currKey+1)){ // 1 1 1 1
                currLHS = freq + map.get(currKey+1);
            }
            maxLHS = Math.max(maxLHS, currLHS);
        }
        return maxLHS;

    }
}