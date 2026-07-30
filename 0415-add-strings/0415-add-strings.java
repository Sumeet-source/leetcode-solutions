class Solution {
    public String addStrings(String num1, String num2) {
        // Use StringBuilder for efficient string concatenation
        StringBuilder sb = new StringBuilder();
        
        // Pointers to traverse the strings from right to left
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        int carry = 0;
        
        // Loop until we run out of digits in both strings AND there is no carry left
        while (i >= 0 || j >= 0 || carry != 0) {
            // Get the current digit from num1 (if index is valid, otherwise 0)
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            // Get the current digit from num2 (if index is valid, otherwise 0)
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;
            
            int sum = digit1 + digit2 + carry;
            
            // Append the unit digit of the sum
            sb.append(sum % 10);
            // Calculate the new carry
            carry = sum / 10;
            
            // Move the pointers to the left
            i--;
            j--;
        }
        
        // Since we appended digits from right to left, reverse the string to get the final answer
        return sb.reverse().toString();
    }
}