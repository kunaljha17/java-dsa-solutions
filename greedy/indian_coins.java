import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class indian_coins {
    public static void main(String[] args) {
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        Arrays.sort(coins, Comparator.reverseOrder());
        int amount = 590;
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                while (coins[i]<=amount) {
                    count++;
                    amount -=coins[i];
                    ans.add(coins[i]);
                }
            }
        }

        System.out.println("Total coins/notes is "+count + " "+ans );
    }
}
