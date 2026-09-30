class Solution {
    
    public int MaxBook(int[] arr, int k,long pages){
        int stu = 1;
        long pagesStud =  0;
        for(int i =0;i<arr.length;i++){
             if(pagesStud + arr[i]<=pages){
                 pagesStud +=arr[i];
             }else{
                 stu++;
                 pagesStud = arr[i];
             }
              
        }
        return stu;
    }
    
    public int findPages(int[] arr, int k) {
        
        if(arr.length<k)return -1;
        long low = Integer.MIN_VALUE;
        long high = 0;
        
        for(int num:arr){
            low = Math.max(num,low);
            high +=num;
        }
        
        while(low<=high){
            long mid = low +(high-low)/2;
             int stu = MaxBook(arr,k,mid);
             if(stu > k) low = mid+1;
             else high = mid-1;
        }
        return (int)low;
    }
}
