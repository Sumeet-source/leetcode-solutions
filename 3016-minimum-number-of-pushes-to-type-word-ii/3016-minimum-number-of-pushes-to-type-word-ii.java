import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        Arrays.sort(freq);
        
        long ans = 0;
        int pushes = 1;
        int count = 0;
        
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;
            ans += (long) freq[i] * pushes;
            count++;
            if (count == 8) {
                pushes++;
                count = 0;
            }
        }
        
        return (int) ans;
    }
}