public class Binary_search {

    public static int Binary_S(int number[], int key) {
        int start = 0;
        int end = number.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (number[mid] == key) {
                return mid;
            } else if (number[mid] > key) {
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int num[] = { 34, 56, 78, 90, 102, 122, 129 };
        int key = 2;
         if(Binary_S(num, key)==-1){
            System.out.println("NOT FOUND!!");
         }else{
             System.out.println("The index of key is "+Binary_S(num,key));
         }
    }
}
   