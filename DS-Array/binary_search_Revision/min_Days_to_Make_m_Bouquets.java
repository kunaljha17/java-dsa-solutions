//Approach is simple make boolean function that check with day number is possible or not with O(n) time compleixty in this function
//then we analysie that our day could be possible , min of boomday is low and high is max of bloomday

class Solution {

    private boolean isPossible(int[] bloomDay, int m, int k, int day) {
        int flowers = 0;
        int bouquets = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long required = (long) m * k;
        if (required > bloomDay.length) {
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;
        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isPossible(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
