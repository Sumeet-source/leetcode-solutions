class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        int left = 1, right = x;
        int ans = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Use long to avoid overflow when multiplying mid * mid
            long square = (long) mid * mid;
            
            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;  // mid is a valid candidate
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}