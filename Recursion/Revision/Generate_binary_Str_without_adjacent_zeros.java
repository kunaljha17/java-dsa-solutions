//Approach : we first think that how many length str we want,
//then make a recursive function there , first by picking 1 make str also store LastPlace then , for next iteration check that does lastplace statisfy requirement
// if satisfy , then make another recursive call , remove last char from current string and add 0 then make string until base case reach 
// then store it into ans, and return 
// atlast also remove from StringBuilder

class Solution {

    public void validStr(int n,ArrayList<String> ans,StringBuilder str , int Lp){
        if(n == 0){
            ans.add(str.toString());
            return;
        }
        str.append(1);
        validStr(n-1,ans, str,1);
        str.deleteCharAt(str.length()-1);
        if(Lp ==1){
            validStr(n-1,ans,str.append(0),0);
            str.deleteCharAt(str.length()-1);
        }
    }

    public List<String> validStrings(int n) {
        ArrayList<String> ans = new ArrayList<>();
        validStr(n,ans,new StringBuilder(""),1);
        return ans;
    }
}
