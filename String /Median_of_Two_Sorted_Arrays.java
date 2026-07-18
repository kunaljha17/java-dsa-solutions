// idea (merge first, then find the median)
//Approach 1

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



//Approach 2 

// first take smaller array
// then take cut1 .. 
// as same we want leftsize - cut1 for cut2 of another array 
// then check L1<=R2 and L2<=R1 if true both then check n is odd or even if odd then return max of l1 l2 
// if even then take avg (max(L1,L2) + min(R1,R2)) / 2
// if false then  check that L1>R2 then high = cut1-1
// if L2>R1 then low = cut1+1
// at then end we get median ...

class Solution {
   
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(nums1.length >nums2.length){
            return findMedianSortedArrays(nums2 , nums1);
        }
        int low = 0;
        int high = n;// let smaller is a nums1
        int leftsize = (n+m+1)/2;
        while(low<=high){
            int cut1 = low +(high-low)/2;
            int cut2 = leftsize - cut1;
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int r1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if(l1<=r2 && l2<=r1){
                   //check length of both array nums1 and nums2 
                if((n + m) % 2 != 0){ // if even 
                    return (double)Math.max(l1,l2);
                }else{ // odd
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
            }
            else if(l1>r2){
                high = cut1-1;
            }
            else if(l2>r1){
                low = cut1+1;
            }
        }
        return 0;
    }
}
