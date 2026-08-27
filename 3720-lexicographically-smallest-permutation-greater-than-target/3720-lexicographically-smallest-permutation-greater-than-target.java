class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        int bestPos = -1;
        char bestChar = 0;
        int[] bestSnapshot = null;

        int[] cur = freq.clone();
        for (int i = 0; i < n; i++) {
            char t = target.charAt(i);

            // is position pe target[i] se bada smallest available char dhoondo
            char found = 0;
            for (char c = (char) (t + 1); c <= 'z'; c++) {
                if (cur[c - 'a'] > 0) { found = c; break; }
            }
            if (found != 0) {
                bestPos = i;
                bestChar = found;
                bestSnapshot = cur.clone();
                bestSnapshot[found - 'a']--;
            }

            // prefix match aage badhane ki koshish karo
            if (cur[t - 'a'] > 0) {
                cur[t - 'a']--;
            } else {
                break; // ab prefix match nahi ho sakta, aage check karne ka fayda nahi
            }
        }

        if (bestPos == -1) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(target, 0, bestPos);
        sb.append(bestChar);
        for (int c = 0; c < 26; c++) {
            for (int k = 0; k < bestSnapshot[c]; k++) {
                sb.append((char) ('a' + c));
            }
        }
        return sb.toString();
    }
}