class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;      // last valid element in nums1
        int j = n - 1;      // last element in nums2
        int k = m + n - 1;  // last position in merged array

        // Merge from the end to avoid overwriting
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If any elements left in nums2, copy them over
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        // No need to copy remaining nums1 because they are already in place
    }
}