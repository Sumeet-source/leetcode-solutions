class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int fullGroups = n / 8;
        int remaining = n % 8;

        // fullGroups groups of 8 letters with costs 1, 2, ..., fullGroups
        // remaining letters cost (fullGroups + 1) each
        return 8 * fullGroups * (fullGroups + 1) / 2 + remaining * (fullGroups + 1);
    }
}