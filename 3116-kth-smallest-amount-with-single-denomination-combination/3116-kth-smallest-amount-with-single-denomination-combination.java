class Solution {
    public long findKthSmallest(int[] coins, int k) {
        // Remove duplicates and sort
        List<Integer> uniqueCoins = new ArrayList<>();
        for (int coin : coins) {
            if (!uniqueCoins.contains(coin)) {
                uniqueCoins.add(coin);
            }
        }
        Collections.sort(uniqueCoins);
        
        // Convert to array
        int[] sortedCoins = new int[uniqueCoins.size()];
        for (int i = 0; i < sortedCoins.length; i++) {
            sortedCoins[i] = uniqueCoins.get(i);
        }
        
        // Binary search
        long low = 1;
        long high = (long) sortedCoins[0] * k; // Maximum possible answer
        
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countMultiples(mid, sortedCoins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    // Count numbers <= x that are multiples of any coin
    private long countMultiples(long x, int[] coins) {
        int n = coins.length;
        long count = 0;
        
        // Inclusion-Exclusion using bitmask
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;
            
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, coins[i]);
                    if (lcm > x) break;
                    bits++;
                }
            }
            
            if (lcm <= x) {
                if (bits % 2 == 1) {
                    count += x / lcm;
                } else {
                    count -= x / lcm;
                }
            }
        }
        
        return count;
    }
    
    // GCD using Euclidean algorithm
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // LCM = (a * b) / gcd(a, b)
    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}