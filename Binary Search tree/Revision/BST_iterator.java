//understand problem first , 
//Approach is first we store all left node into stack in contructor
// when next is called first take top of stack and check that does that top node has right subtree or not ..
//if right subtree is available then call for leftpush for top right node to store all left node of that node then ,, same proccess
//hasnext() is true if stack has atleast one element .. is stack is empty() then return false.
//pushkeft() is used to push left node in stack 



class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeft(root);
    }
    
    public void pushLeft(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if(node.right !=null){
            pushLeft(node.right);
        }
        return node.val;
    }
    
    public boolean hasNext() {
        return stack.size()>0;
    }
}
