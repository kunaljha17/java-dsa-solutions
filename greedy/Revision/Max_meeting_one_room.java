class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int [][] slots= new int[s.length][3];
        
        for(int i =0;i<s.length;i++){
            slots[i][0] = i+1;
            slots[i][1] = s[i];
            slots[i][2] = f[i];
        }
        
        Arrays.sort(slots,(a,b)-> Integer.compare(a[2],b[2]));
        
        ans.add(slots[0][0]);
        
        int endTime = slots[0][2];
        
        for(int i = 1;i<s.length;i++){
            if(slots[i][1]>endTime){
                ans.add(slots[i][0]);
                endTime = slots[i][2];
            }
        }
          Collections.sort(ans); // in question they ask for sorted indices output :(idx 1 based ) we want
          return ans;
    }
}
