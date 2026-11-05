//We have to check through doing xor from 1 to 1 ,2,3,4,5,6,7,8.. then analysis the pattern 
// then make this condition function ..
//Constant time and space complexity


class Solution {
    
    
    public int f(int n){
        if(n%4==0)return n;
        if(n%4==1)return 1;
        if(n%4==2)return n+1;
        return 0;
    }
    
    public int findXOR(int l, int r) {
        return f(r)^f(l-1);
        
    }
}
