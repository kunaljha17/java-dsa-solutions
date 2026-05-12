public class Array_repeatE {

     public static boolean Array_check(int numbers[]){

        for(int i = 0;i<numbers.length;i++){
            int num = numbers[i];
            for(int j = i+1;j<numbers.length;j++){
                if (num == numbers[j]) {
                    return  true;
                }
            }
        }
        
        return false;
     }

    public static void main(String[] args) {

        int num[] = {1,2,3,5};
        System.out.println(Array_check(num));
        
    }
}
