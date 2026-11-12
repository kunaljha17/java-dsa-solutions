// here simplly use memoization for optimize bruite force approach
// candies array to store max of candies distributed by analysising rating


class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); //memoization
 
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
 
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int totalCandies = 0;
        for (int candyCount : candies) {
            totalCandies += candyCount;
        }
        return totalCandies;
    }
}
