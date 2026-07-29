import java.util.*;

class Solution {
    public int romanToInt(String s) {
        // Map each Roman symbol to its value
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int total = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int current = map.get(s.charAt(i));

            // Check if there's a next character and if current < next
            if (i + 1 < n && current < map.get(s.charAt(i + 1))) {
                total -= current;   // Subtract for cases like IV, IX, XL, etc.
            } else {
                total += current;   // Otherwise, add
            }
        }

        return total;
    }
}