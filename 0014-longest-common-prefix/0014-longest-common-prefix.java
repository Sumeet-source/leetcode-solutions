class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: empty array
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Take the first string as reference
        for (int i = 0; i < strs[0].length(); i++) {
            char currentChar = strs[0].charAt(i);

            // Compare this character with the same index in all other strings
            for (int j = 1; j < strs.length; j++) {
                // If index is out of bounds OR characters don't match
                if (i >= strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return strs[0].substring(0, i);
                }
            }
        }

        // If we didn't return early, the entire first string is the prefix
        return strs[0];
    }
}