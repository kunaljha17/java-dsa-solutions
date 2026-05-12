public class HeapSort {

    static class heapsort{

        public void heapify(int arr[] ,int n, int i){
            int maxIdx = i;
            int left = 2*i+1;
            int right = 2*i+2;

            if (left <n && arr[maxIdx] <arr[left]) {
                maxIdx = left;
            }
            if (right<n && arr[maxIdx] <arr[right]) {
                maxIdx = right;
            }

            if (maxIdx != i) {
                int temp = arr[maxIdx];
                arr[maxIdx] = arr[i];
                arr[i] = temp;

                heapify(arr,n , maxIdx);
            }
        }

        public void sort(int arr[]){
            //maxheap
            int n = arr.length;
            for(int i = n/2;i>=0;i--){   // n/2 ->>>>>> (n/2-1)
                heapify(arr ,n, i);
            }

            //swap
            for(int i = n-1;i>=0;i--){
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapify(arr ,i,0);
            }
        }
    }
    public static void main(String[] args) {
        int arr [] = { 1,2,4,5,3};

        heapsort hs = new heapsort();
        hs.sort(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] +" ");
        }
        
    }
}
