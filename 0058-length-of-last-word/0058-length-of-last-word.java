class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        
        // Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        int end = i; // position of last character of last word
        
        // Move to start of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        
        return end - i; // length of last word
    }
}