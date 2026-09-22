// Here appraoch is first find one row by iterating each col
// here i use nCr way to get row . by doing  (rowNum - col) /col * prevVal

//by this appraoch i get row so doing in same manner for all row then add to list 
//  this way i use in multipication  res = res * (row - i) / i
//because we no need to be division done by starting

//**** if we need to get exact val by row and col we do apply nCr formula so get this 

class Solution {

    public List<Integer> ncrRow(int row){
        ArrayList<Integer> list = new ArrayList<>();
        int res = 1;
        list.add(1);
        for(int i =1;i<row;i++){
            res = res * (row - i) / i;
            list.add(res);
        }
        return list;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ls = new ArrayList<>();
         
        for(int i =1;i<=numRows;i++){
             ls.add(ncrRow(i));
        }
        return ls;
    }
}
