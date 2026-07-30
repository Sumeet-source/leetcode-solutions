class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        // Start from the last digit
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // If digit is 9, set to 0 and continue carry
            digits[i] = 0;
        }
        // If all digits were 9, we need an extra leading 1
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}