import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Step 2: Fix the first element
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int target = -nums[i];
            int left = i + 1;
            int right = n - 1;
            
            // Two-pointer search for pairs that sum to target
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    // Move both pointers inward
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;  // need a larger sum
                } else {
                    right--; // need a smaller sum
                }
            }
        }
        
        return result;
    }
}