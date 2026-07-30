/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        // Map to store prefix sum frequencies
        Map<Long, Integer> prefixSum = new HashMap<>();
        // Initialize with 0 sum count 1 for paths starting at root
        prefixSum.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSum);
    }
    
    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSum) {
        if (node == null) return 0;
        
        // Update current sum
        currentSum += node.val;
        
        // Count paths ending at current node with sum targetSum
        int paths = prefixSum.getOrDefault(currentSum - targetSum, 0);
        
        // Add current sum to map
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        
        // Recurse left and right
        paths += dfs(node.left, currentSum, targetSum, prefixSum);
        paths += dfs(node.right, currentSum, targetSum, prefixSum);
        
        // Backtrack: remove current sum from map
        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);
        
        return paths;
    }
}