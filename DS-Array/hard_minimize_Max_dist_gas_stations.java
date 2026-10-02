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

class Solution {
    
    public int numberOfGasStationsRequired(int[] arr, double dist) {
        int required = 0;
        
        for (int i = 0; i < arr.length - 1; i++) {
           double gap = arr[i + 1] - arr[i];
           if (gap % dist == 0) {
               required += (int)(gap / dist) - 1;
           } else {
               required += (int)(gap / dist);
           }
        }
        return required;
    }
    
    public double minMaxDist(int[] stations, int k) {
        double low = 0;
        double high = 0;
         
        for (int i = 0; i < stations.length - 1; i++) {
            high = Math.max(high, (double)(stations[i + 1] - stations[i]));
        }
        
        while (high - low > 1e-6) {
            
            double mid = low + (high - low) / 2.0;
             
            if (numberOfGasStationsRequired(stations, mid) > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
        
    }
}

