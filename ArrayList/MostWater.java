import java.util.ArrayList;
// import java.util.*;

public class MostWater {
    // brute force (Time complexity O(n^2))
    public static int waterStored(ArrayList<Integer> height) {
        int MostWater = 0;
        for (int i = 0; i < height.size(); i++) {
            int CurrHeight = height.get(i);
            for (int j = i + 1; j < height.size(); j++) {
                int MinHeight = Math.min(CurrHeight, height.get(j));
                int width = j - i;
                MostWater = Math.max(MostWater, MinHeight * width);

            }
        }
        return MostWater;
    }

    // 2-point-Approach(Optimized)-->O(n)

    public static int MostWaterOptimze(ArrayList<Integer> height) {
        int Lp = 0, Rp = height.size() - 1;
        int MaxWater = 0;
        while (Lp < Rp) {
            int width = Rp - Lp;
            int MinHeight = Math.min(height.get(Lp), height.get(Rp));
            MaxWater = Math.max(MaxWater, width * MinHeight);
            // if (MaxWater<width*MinHeight) { <<<<---->>>Same as Math.max
            // MaxWater = width*MinHeight;
            // }

            if (height.get(Lp) < height.get(Rp)) {
                Lp++;
            } else {
                Rp--;
            }
        }
        return MaxWater;
    }

    public static void main(String[] args) {
        // int height[] = {1,8,6,2,5,4,8,3,7};
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(MostWaterOptimze(height));

    }
}
