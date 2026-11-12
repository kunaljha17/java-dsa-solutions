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



//Most optimal way of doing this problem is single-pass approach using peak and down slopes



//O(N)time & O(1) space

    class Solution {
    public int candy(int[] ratings) {
        int sum =1;
        int i = 1;
        while(i<ratings.length){
            if(ratings[i]==ratings[i-1]){
                sum +=1;
                i++;
                continue;
            }
            int peak =1;
            while(i<ratings.length && ratings[i]>ratings[i-1]){
                peak+=1;
                sum +=peak;
                i++;
            }
            int down = 0;  //that the peak is shared between both slopes, so it must not be counted twice
            while(i<ratings.length && ratings[i]<ratings[i-1]){
                down++;
                sum +=down;
                i++;
            }
           if(down>=peak) sum += down-peak+1;
        }
        return sum;
    }
}
