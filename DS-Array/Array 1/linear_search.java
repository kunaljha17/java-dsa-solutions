public class linear_search {
 
    public static int linearSearch(int num[], int key){
        for(int i =0;i<num.length;i++){
            if (num[i]==key) {
                return i;
            }
        }
          return -1 ;
    } 

    public static void main(String[] args) {
        int marks[] = {2,3,4,6,8,10,12,14,16};
        int key = 20;
        if(linearSearch(marks, key) == -1){
            System.out.println("The given number not found!");
        }
        else{
            System.out.printf("The %d at index %d ",key,linearSearch(marks, key));
        }
    }
}
