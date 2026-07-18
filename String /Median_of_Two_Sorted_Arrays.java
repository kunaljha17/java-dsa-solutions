// idea (merge first, then find the median)

class Solution {
    public void merge(int arr[],int nums1[] , int nums2[]){
        int i = 0;
        int j = 0,k=0;
        while(i<nums1.length  && j<nums2.length){
            if(nums1[i]<nums2[j]){
                arr[k] = nums1[i];
                k++;
                i++;
            }else{
                arr[k] = nums2[j];
                k++;
                j++;
            }
        }

        while(i<nums1.length){
            arr[k++] = nums1[i++];
        }
        while(j<nums2.length){
            arr[k++] = nums2[j++];
        }
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int arr[] = new int[nums1.length+nums2.length];
        merge(arr,nums1,nums2);
       int n = arr.length;

        if (n % 2 == 1) {
            return arr[n / 2];
            }
         return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
    }
}
