class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = word.indexOf(ch);
        
        // If ch doesn't exist, return the original word
        if (idx == -1) {
            return word;
        }
        
        // Get the substring from 0 to idx (inclusive)
        String prefix = word.substring(0, idx + 1);
        
        // Reverse the prefix using StringBuilder
        String reversedPrefix = new StringBuilder(prefix).reverse().toString();
        
        // Get the remaining part of the string
        String suffix = word.substring(idx + 1);
        
        // Combine and return
        return reversedPrefix + suffix;
    }
}