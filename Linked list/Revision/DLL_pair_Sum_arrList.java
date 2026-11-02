//I am thinking of binary search so i do like that , 


class Solution {
    public ArrayList<ArrayList<Integer>> givenSumPairs(Node head, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        
        Node left = head;
        Node right = head;
        
        while(right.next != null){
            right = right.next;
        }
         
        while(right != left && right.next != left){
            int sum = right.data + left.data;
            if(sum == target){
                ans.add(new ArrayList<>(List.of(left.data,right.data)));
                right = right.prev;
                left = left.next;
            }
            else if(sum<target){
                left = left.next;
            }else{
                right = right.prev;
            }
        }
        return ans;
    }
}
