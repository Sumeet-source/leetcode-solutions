class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;

        // Build half counts and find middle character
        int[] half = new int[26];
        char middle = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1)
                middle = (char) ('a' + i);
            half[i] = count[i] / 2;
        }

        int m = n / 2; // length of first half

        // Compute total distinct permutations with cap at k (to avoid overflow)
        long total = countPermutations(half, m, k);
        if (total < k)
            return "";

        // Build the k-th lexicographically smallest first half
        StringBuilder firstHalf = new StringBuilder();
        int remaining = m;
        long kk = k;

        for (int pos = 0; pos < m; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0)
                    continue;
                half[c]--; // try placing char c
                long ways = countPermutations(half, remaining - 1, kk);
                if (kk <= ways) {
                    firstHalf.append((char) ('a' + c));
                    remaining--;
                    break; // move to next position
                } else {
                    kk -= ways;
                    half[c]++; // revert
                }
            }
        }

        // Assemble the full palindrome
        String first = firstHalf.toString();
        String second = new StringBuilder(first).reverse().toString();
        if (n % 2 == 0)
            return first + second;
        else
            return first + middle + second;
    }

    // Returns min(actual number of distinct permutations, limit+1) to cap at k
    private long countPermutations(int[] half, int totalLen, long limit) {
        long res = 1;
        int rem = totalLen;
        for (int c = 0; c < 26; c++) {
            if (half[c] > 0) {
                long comb = nCr(rem, half[c], limit);
                res *= comb;
                if (res > limit)
                    return limit + 1; // cap
                rem -= half[c];
            }
        }
        return res;
    }

    // Compute C(n, r) capped at limit+1
    private long nCr(int n, int r, long limit) {
        if (r > n - r)
            r = n - r;
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (n - r + i) / i;
            if (res > limit)
                return limit + 1;
        }
        return res;
    }
}