// Here appraoch is first find one row by iterating each col
// here i use nCr way to get row . by doing  (rowNum - col) /col * prevVal

//by this appraoch i get row so doing in same manner for all row then add to list 
//  this way i use in multipication  res = res * (row - i) / i
//because we no need to be division done by starting

//**** if we need to get exact val by row and col we do apply (n-1)C(r-1) formula so get this 

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

//Another veriant i talk about this 
//we have to mind for integer over flow issue 
// So do check contraint

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        long res = 1;
        list.add(1);
        int row = rowIndex+1;
        for(int i = 1;i<=rowIndex;i++){
            res = (long)res * (row - i) / i;
            list.add((int)res);
        }
        return list;
    }
}

