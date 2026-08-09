//Approach yaha mujhe pata haio bst me left me lesser val node hota hai . 
//sbse phela ham eek Data structure sochenge jo last in first out deta ho ..ow es liya kyuki ham traverse krke niche jate smay stack me add kr denge `
//jo sb se bara root hoga ho stack me sb se niche ayega ...aur us se bara wala uske upr ..
//then so sb se phela eek temp node  jo track krega ..
// then tb tk stack me add krenge jb tk temp null na ho jaye ..
//then waha se use stack ke top wala ko pop krke check krenge ki ye kth element toh nahi .. agr hoga toh return kr denge 
//agr kth smallest nhi hai toh temp me temp ke right ko dalo aur espe check kro same pure left krke ..same 
//k-- krke dekho k jb k== 0 then our ans get .

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            k--;  
            if (k == 0) {
                return current.val;
            }
            current = current.right;
        }
        return -1;  
    }
}
