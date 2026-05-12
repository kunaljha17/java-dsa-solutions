import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class fractional_knapsack {
    public static void main(String[] args) {
        int value [] = {60, 100, 120};
        int weight[] = {10 , 20 ,30};

        int capacity = 50;
        double knapsack[][] = new double[value.length][2];
        for(int i = 0;i<value.length;i++){
            knapsack[i][0] = i;
            knapsack[i][1] = value[i]/(double)weight[i];
        }

        Arrays.sort(knapsack,Comparator.comparingDouble(o->o[1]));

        double finalvalue = 0;

        for(int i =value.length-1;i>=0;i--){
            int idx = (int)knapsack[i][0];
            if (capacity>=weight[idx]) {
                finalvalue += value[idx];
                capacity -=weight[idx];
            }else{
                finalvalue =  finalvalue +capacity*(int)knapsack[i][1];
                capacity = 0;
                break;
            }
        }
        System.out.println("Final value : " + finalvalue );
    }
}
