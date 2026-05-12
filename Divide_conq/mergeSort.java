
public class mergeSort {

    public static void mergesort(int arr[], int si, int ei) {//O(nlogn) time complexity
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergesort(arr, si, mid);
        mergesort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
    }
    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;// idx for 1st sorted part
        int j = mid + 1;// idx for 2nd sorted part
        int k = 0;// idx for temp

        while(i<=mid&&j<=ei){
            if (arr[i]<arr[j]) {
                temp[k]=arr[i];
                i++;
                k++;
            }
            else{
                temp[k] =arr[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            temp[k]=arr[i];
            k++;
            i++;
        }
        while (j<=ei) {
            temp[k]=arr[j];
            k++;
            j++;
        }

        for( k =0,i=si; k<temp.length; k++,i++){
            arr[i] = temp[k];
        }
    }

    public static void quicksort(int arr[],int si , int ei){//avg case O(nlogn) and worst case O(n^2) -->O(1) space complexity
        if (si>=ei) {
            return;
        }
        int pidx = partionarr( arr , si ,ei);
        quicksort(arr, si, pidx-1);//left
        quicksort(arr, pidx+1, ei);//right
    }
    public static int partionarr(int arr[],int si, int ei){
        int pivot = arr[ei];
        int i = si-1;
        for(int j =si;j<ei;j++){
            if (arr[j]<pivot) {
                i++;
                //swap
                int temp = arr[j];
                arr[j] =arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp = pivot;//or arr[ei]
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }


    public static void main(String[] args) {

    }
}