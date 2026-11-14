//remove from left sum by one and add from right while this we compare  maxSum and then return


class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int suml = 0;
        int sumr = 0;
        
        for(int i =0;i<k;i++) suml += cardPoints[i];
        int maxSum =suml;

        int j = cardPoints.length-1;
         for(int i = k-1;i>=0;i--){
            suml -=cardPoints[i];
            sumr +=cardPoints[j];
            maxSum = Math.max(maxSum , suml+sumr);
            j--;
        }
        return maxSum;
    }
}
