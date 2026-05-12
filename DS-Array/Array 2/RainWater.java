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
    


     
    public static void main(String[] args) {
        int height[] = { 4, 2, 0, 6, 3, 2, 5 };

        System.out.println("Rain water trapped inside is :"+RainWater_trapped(height));

    }
}
 