
//This approach solvere this problem with O(n) space and time complexity
// not Optimize or standard approach
public class RainWater {

    public static int RainWater_trapped(int height[]) {
        int n = height.length;
        int leftMaxBound[] = new int[n];
        int RightMaxBound[] = new int[n];

        leftMaxBound[0] = height[0];
        RightMaxBound[n - 1] = height[n - 1];
          
        //left-MAX-Bound
        for (int i = 1; i < n; i++) {
            leftMaxBound[i] = Math.max(leftMaxBound[i - 1], height[i]);
        }
        //right-max-bound
        for (int i = n - 2; i >=0; i--) {
            RightMaxBound[i] = Math.max(RightMaxBound[i+1], height[i]);
        }  

        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(RightMaxBound[i], leftMaxBound[i]);
            trappedWater = trappedWater + (waterLevel - height[i]);
        }
        return trappedWater;
    }




// 1. Keep two pointers: left and right.
// 2. Maintain leftMax and rightMax.
// 3. Compare leftMax and rightMax.
// 4. Smaller max decides the water level.
// 5. If leftMax <= rightMax, process left.
// 6. Else, process right.
// 7. Update max if current bar is taller.
// 8. Otherwise add (max - current height).
// 9. Move only the processed pointer.
// 10. Time O(n), Space O(1).

   
  public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    trappedWater += leftMax - height[left];
                }

                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    trappedWater += rightMax - height[right];
                }
                right--;
            }
        }
        return trappedWater;
    }
    


     
    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };

        System.out.println("Rain water trapped inside is :"+RainWater_trapped(height));

    }
}
 
