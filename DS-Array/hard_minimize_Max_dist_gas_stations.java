//Approach 1 
//brute force 
// just make one countStation for each section so overall minimize length


//NOT GOOD AND OPTIMIZE CODE
class Solution {
    public double minMaxDist(int[] stations, int k) {
        int n = stations.length;
        int countStation [] = new int[n-1];
        
        for(int station = 1;station<=k;station++){
            
            double maxSection = -1.0;
            int maxIdx = -1;
            
            for(int i =0;i<n-1;i++){
                double diff = stations[i+1]-stations[i];
                double currLength = diff/(double)(countStation[i]+1);
                
                if(maxSection<currLength){
                    maxSection = currLength;
                    maxIdx = i;
                }
            }
            countStation[maxIdx]++;
        }
        
        double ans = -1.0;
        for(int i =0;i<n-1;i++){
            double diff = stations[i+1]-stations[i];
            double currLength = diff/(double)(countStation[i]+1);
            ans = Math.max(currLength,ans);
            
        }
        return ans;
        
    }
}


//Max optimize code by binary search method 
// Goal: Minimize the maximum distance between adjacent gas stations.
// Use binary search on the answer (dist).
// low = 0, high = maximum existing gap.
// mid = (low + high) / 2.
// Count how many new stations are needed for mid.
// For each gap: segments = gap / mid.
// If gap / mid is exactly an integer → stations = segments - 1.
// Otherwise → stations = floor(segments).
// If required > k, mid is too small → low = mid; else high = mid.
// Stop when high - low <= 1e-6; return high.



//EXPLAINING EVERY LINE 
class Solution {
    
    public int numberOfGasStationsRequired(int[] arr, double dist) { //In this  dist we have we to maintain for every station 
        int required = 0; // This is for counting number of station that statisfy in all gap , 
        
        for (int i = 0; i < arr.length - 1; i++) { // This loop iterate on every element i to n-1
           double gap = arr[i + 1] - arr[i]; //This is we caculate gap in each station
           if (gap % dist == 0) { // this check that caculated gap is divisible or not , if divisible like 1/0.5 = 2, here we onl;y put 1 station , So decrease count 
               required += (int)(gap / dist) - 1; // here decrease count 
           } else { // normally add to count 
               required += (int)(gap / dist);
           }
        }
        return required; // finally return 
    }
    
    public double minMaxDist(int[] stations, int k) {
        double low = 0; //initialize low as 0 assuming lowest distance could be 0
        double high = 0; // initialize high , actually we have making range (lowest possible gap ,max possible gap between two consecutive station position)
         
        for (int i = 0; i < stations.length - 1; i++) { //This loop for iterating one each position of station , upto n-1
            high = Math.max(high, (double)(stations[i + 1] - stations[i])); //Here compare gap of each possible gap and take max and store in high
        }
        
        while (high - low > 1e-6) { // this is binary search condition here we see that (high -low) > 10^-6 this is maximum border line for taking . like that high - low is not less than 10^-6 
            
            double mid = low + (high - low) / 2.0; // here ,calculate mid .One thing that we have mind this that this problem is not as normal integer search problem . in this we have double value , 
            // So we have infinite value in (0,1) range So this make problem so unique
             
            if (numberOfGasStationsRequired(stations, mid) > k) { //here whatever mid i get pass that mid as a dist that we want max for gap ,
                low = mid; // this we know that  current dist is sammller so for increase dist , shift low to mid
            } else {
                high = mid; // this we know that we can't avail to place k stations in there gap so need smaller dist 
            }
        }
        return high; // finallly we return high because at the end high point to dist or mid value
        
    }
}

