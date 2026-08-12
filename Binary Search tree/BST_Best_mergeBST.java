//one of the best problem on bst ..
//here we use indegree concept to track root element
//then after that in isValid bst there i check that current bst is valid or not with together merging bst too ...at the end we get merged bst if applicable



class Solution {
    public TreeNode canMerge(List<TreeNode> trees) {
        Map<Integer, TreeNode> valToNode = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (TreeNode tree : trees) {
            valToNode.put(tree.val, tree);
            inDegree.putIfAbsent(tree.val, 0);
            
            if (tree.left != null) {
                inDegree.put(tree.left.val, inDegree.getOrDefault(tree.left.val, 0) + 1);
            }
            if (tree.right != null) {
                inDegree.put(tree.right.val, inDegree.getOrDefault(tree.right.val, 0) + 1);
            }
        }
        TreeNode rootCandidate = null;
        for (TreeNode tree : trees) {
            if (inDegree.get(tree.val) == 0) {
                if (rootCandidate != null) {
                    return null;  
                }
                rootCandidate = tree;
            }
        }
        
        if (rootCandidate == null) {
            return null;
        }
        valToNode.remove(rootCandidate.val);
        if (isValidBST(rootCandidate, Long.MIN_VALUE, Long.MAX_VALUE, valToNode) && valToNode.isEmpty()) {
            return rootCandidate;
        }
        
        return null;
    }
    
    private boolean isValidBST(TreeNode node, long minVal, long maxVal, Map<Integer, TreeNode> valToNode) {
        if (node == null) {
            return true;
        }
        
        if (node.val <= minVal || node.val >= maxVal) {
            return false;
        }
        if (node.left == null && node.right == null) {
            if (valToNode.containsKey(node.val)) {
                TreeNode nextRoot = valToNode.get(node.val);
                node.left = nextRoot.left;
                node.right = nextRoot.right;
                valToNode.remove(node.val);  
            }
        }
        return isValidBST(node.left, minVal, node.val, valToNode) && 
               isValidBST(node.right, node.val, maxVal, valToNode);
    }
}
