//Approach is similar to count inversion but here we do perform count viva function , in this 
// In count function we first select one element from sorted left part then do check condition with sorted right part increase right pointer till satisfy
//then for counting we have to do (right - (mid+1))
//When right part all element traverse is done and then we still have left element in left part then , do update count until left part has traverse left ...

//mainly we have all code of merge sort but one small changes in there make this optimal code 

//Also make sure to store return output with function call and add too 

class Solution {

    public void merge(int arr[], int low, int mid, int high){
        int n1 = mid - low +1;
        int n2 = high - mid;
        int left[] =  new int[n1];
        int right[] = new int[n2];

        for(int i =0;i<n1;i++){
            left[i] = arr[low+i];
        }
        for(int i = 0; i<n2;i++){
            right[i] = arr[mid +i+1];
        }
        int k = low , i = 0, j = 0;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }
        while(i<n1){
            arr[k++] = left[i++];
        }
        while(j<n2){
            arr[k++] = right[j++];
        }
    }

    public int CountPair(int arr[], int low ,int mid ,int high){ //This is function we define
        int right  = mid +1;
        int count = 0;
        for(int i = low; i<=mid;i++){
            while(right<=high && (long)arr[i]>(long)arr[right]*2){
                right++;
            } 
            count += (right - (mid + 1)); // this is count way for element statisfy
        }
        return count;
    }

    public int mergeSort(int arr[],int low,int high){
        int count = 0;
        if(low<high){
            int mid = low + (high - low)/2;
            count += mergeSort(arr , low , mid);
            count += mergeSort(arr , mid+1 , high);
            count += CountPair(arr , low ,mid , high);//pass two sorted array.
            merge(arr , low , mid ,high);//merge sorted array
        }
        return count;
    }



    public int reversePairs(int[] nums) {
      int low = 0;
      int high = nums.length - 1;
      return mergeSort(nums,low,high);
    }
}
