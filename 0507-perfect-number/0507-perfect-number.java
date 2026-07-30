class Solution {
    public boolean checkPerfectNumber(int num) {
        // Edge case: 1 is not a perfect number (sum of divisors = 0)
        if (num <= 1) {
            return false;
        }

        // 1 is always a divisor (unless num is 1, which we already handled)
        int sum = 1;

        // Iterate from 2 up to the square root of num
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                // Avoid adding the same divisor twice (e.g., for perfect squares like 16, i=4)
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }

        // Return true if the sum of divisors (excluding num itself) equals num
        return sum == num;
    }
}