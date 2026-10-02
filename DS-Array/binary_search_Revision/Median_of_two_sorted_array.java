//Approach : here in this problem , is doable by two approach , 
//normal approach is by doing merge sort merge then , do check even or odd , and finally return ans;

//Approach 2 :One of the best concept use 
//in this we know that both array is sorted , we only need midian in any way , so for this we 
//we think like by doing this with binary search assuming nums1 is greater or equal length , i do binary search on nums1 
//in this low = 1, high = nums1.length , then first calculate how much part should be in left of array ,

//assume like this when total left part = (n+m+1)/2;
//first cut1 do in nums1 like binary mid , then remaining cut2 from done in nums2 by this full fill left part requirements
// then we initialize l1 ,l2 ,r1,r2 these are corner of nums before cut1 and cut2 
//cut1 generate l1 and r1 and similary cut2 generate l2 and r2 .
//by comparing l1 to r2 and l2 to r1 we decide cut1 moves 
