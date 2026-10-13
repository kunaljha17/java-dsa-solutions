//Approach 
//first think that what we need actually then, make sample example ,
//then found that for even position i have 5 options (0,2,4,6,8) and for odd position i have 4 options (2,3,5,7) prime num
// So i think this as when i found number of evenPosition and oddposition ,then i just simply do 5^evenPosition and similarly 4^oddPosition 


class Solution {
    public long mod = 1000000007; 
    public long power(long base , long exp){
         long result = 1;
         while(exp>0){
            if(exp % 2 == 1){
                result = (result * base)%mod;
            }
            base = (base*base)%mod;
            exp /=2;
         }
         return result;
    }

    public int countGoodNumbers(long n) {
        long evenPosition = (n+1)/2;
        long oddPosition = n/2;

        long evenWay = power(5,evenPosition);
        long oddWay = power(4,oddPosition);

        return (int)((evenWay*oddWay)%mod);
    }
}
