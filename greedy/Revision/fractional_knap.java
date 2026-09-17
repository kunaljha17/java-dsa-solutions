//here we make sure by proper handling of datatype

class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        double[][]ratio = new double[val.length][2];//0 for ratio,1 for idx
        for(int i =0;i<val.length;i++){
            ratio[i][0] = (double)val[i]/wt[i];
            ratio[i][1] = i;
        }
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[0]));
        double ans = 0;
        for(int i=val.length-1;i>=0;i--){
            if(wt[(int)ratio[i][1]]<=capacity){
                capacity -=wt[(int)ratio[i][1]];
                ans += val[(int)ratio[i][1]];
            }else{
                ans +=ratio[i][0]*capacity;
                break;
            }
        }
        return ans;
    }
}
