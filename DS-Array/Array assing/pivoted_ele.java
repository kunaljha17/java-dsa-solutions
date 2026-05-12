public class pivoted_ele {

    public static int Pivoted_Arr(int numbers[],int target){
  
         int l=0, r=numbers.length-1;
         while (l<=r) {
            int mid = (l+r)/2;

            if (numbers[mid]==target) {
                return mid;
            }
   
            //left half is sorted
            if (numbers[l]<=numbers[mid]) {
                if (numbers[mid]>target&&numbers[l]<target) {
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
            //Right half is sorted
            if (numbers[r]>=numbers[mid]) {
                if (numbers[mid]<target&&numbers[r]>target) {
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
             
         }
         return -1;
         
    }

    public static void main(String[] args) {
        int num[] = {12,15,17,23,4,6,7};
        int target = 15;
        System.out.println(Pivoted_Arr(num, target));
        
    }
}
