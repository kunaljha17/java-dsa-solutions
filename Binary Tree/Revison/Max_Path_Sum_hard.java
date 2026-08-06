// Return to parent → root.val + max(left, right)
// Update answer → left + root.val + right
// Ignore negative branches → Math.max(0, childSum)
// Initialize global maximum → Integer.MIN_VALUE

//mujhe sbse phela last node pe jana hai 
// then waha sbse phela null pe 0 return , left,right dono niklna hai node ke liya 
// then left me agr -ve path aya toh ignore same right do -ve 0
// then update width and return one left right max selecting path with root .
//update me root ke shat left +root+ right 



class Solution {
     
    public int PathCal(TreeNode root , int width[]){
        if(root == null){
            return 0;
        }
      int left =  PathCal(root.left,width);
      int right =   PathCal(root.right,width);
      left = Math.max(0,left);
      right = Math.max(0,right);
     width[0] = Math.max(width[0],left+root.val+right);
     return root.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
     int width[] = {Integer.MIN_VALUE};
     PathCal(root,width);
     return width[0];
    }
}
