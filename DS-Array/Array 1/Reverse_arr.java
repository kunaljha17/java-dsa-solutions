//Method -1!


// public class Reverse_arr {
   
//     public static int[] Reverse_array(int numbers[]){

//         int new_arr[] = new int[numbers.length];

//         for(int i = 0;i<numbers.length;i++){
//             new_arr[i]= numbers[numbers.length-i-1];
//         }

//       return new_arr;
//     }

//     public static void main(String[] args) {
//      int num[] = {12,23,34,56,66,78,90};
         
//      int newnNum[] = Reverse_array(num);

//      for(int i =0;i<newnNum.length;i++){
//         System.out.print(newnNum[i]+" ");
//      }
//     }
// }


//Method-2

public class Reverse_arr {
    public static void Reverse_array(int numbers[]){
        int first =0;
        int last = numbers.length-1;
        while (first<last) {
           int temp = numbers[first];
            numbers[first]= numbers[last];
            numbers[last]= temp;
            first++;
            last--;
        }
    }

    public static void main(String[] args) {
        int num[] = {12,23,34,56,66,78,90};
         
      Reverse_array(num);

     for(int i =0;i<num.length;i++){
        System.out.print(num[i]+" ");
     }
        
    }
}