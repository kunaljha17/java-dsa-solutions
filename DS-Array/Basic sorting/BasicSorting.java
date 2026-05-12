import java.util.*;

public class BasicSorting {

    public static void bubbleS(int numbers[]) {
        for (int turn = 0; turn < numbers.length - 1; turn++) {
            for (int j = 0; j < numbers.length - turn - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void SelectionSort(int arr[]) {

        for (int i = 0; i < arr.length - 1; i++) {//count turns
            int minElement =  i;
            for (int j = i+1; j < arr.length; j++) {//search min index in array and then assing
                if (arr[minElement] > arr[j]) {
                    minElement =  j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minElement];
           arr[minElement] = temp;
        }
    }

    public static void InsertionSort(int arr[]){
         for(int i = 1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
            //Finding correct pos
            while (prev>=0&&arr[prev]>curr) {
                arr[prev+1] =arr[prev];
                prev--;
            }
            //insertion here
            arr[prev+1] = curr;
         }
    }

    public static void CountSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest+1];
        for(int i = 0;i<arr.length;i++){
            count[arr[i]]++;
        }
        int j=0;
        for(int i=0;i<count.length;i++){
            while(count[i]>0){
                arr[j]=i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int num[] = { 67, 2, 56, 35, 545, 544, 3, 10 };
        printArr(num);
        System.out.println("after sorting :");
        SelectionSort(num);
        printArr(num);

    }
}
