import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    void testTwoSum() {
        Solution sol = new Solution();
        
        // Example 1: nums = [2,7,11,15], target = 9 -> [0,1]
        int[] result1 = sol.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result1);
        
        // Example 2: nums = [3,2,4], target = 6 -> [1,2]
        int[] result2 = sol.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(new int[]{1, 2}, result2);
        
        // Example 3: nums = [3,3], target = 6 -> [0,1]
        int[] result3 = sol.twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(new int[]{0, 1}, result3);
    }
}
