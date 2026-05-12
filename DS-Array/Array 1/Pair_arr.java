public class Pair_arr {
    public static void pair_array(int numbers[]){
        for(int i =0;i<numbers.length;i++){
            for(int j = i+1;j<(numbers.length);j++){
               System.out.print("("+numbers[i]+","+numbers[j]+")"+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int num[] = {2,4,6,8,10};
        pair_array(num);
    }
}
