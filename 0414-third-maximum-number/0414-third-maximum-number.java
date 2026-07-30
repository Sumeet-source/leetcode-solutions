class Solution {
    public int thirdMax(int[] nums) {
        // Use Long.MIN_VALUE as a sentinel to handle cases where the array 
        // actually contains Integer.MIN_VALUE
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int num : nums) {
            // Skip duplicates
            if (num == firstMax || num == secondMax || num == thirdMax) {
                continue;
            }

            if (num > firstMax) {
                // Shift existing maximums down
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                // Shift the second and third maximums down
                thirdMax = secondMax;
                secondMax = num;
            } else if (num > thirdMax) {
                // Update the third maximum
                thirdMax = num;
            }
        }

        // If thirdMax was never updated, it means there are fewer than 3 distinct numbers.
        // Return the maximum number (firstMax) as per the rules.
        if (thirdMax == Long.MIN_VALUE) {
            return (int) firstMax;
        }

        return (int) thirdMax;
    }
}