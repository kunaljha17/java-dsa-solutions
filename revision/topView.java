import java.util.*;

public class topView {
    static class info {
        Node node;
        int hd;

        public info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public void top_view_tree(Node root) {

        if (root == null) {
            return;
        }
        Queue<info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;
        q.add(new info(root, 0));
        while (!q.isEmpty()) {
            info currInfo = q.remove();
            if (!map.containsKey(currInfo.hd)) {
                map.put(currInfo.hd, currInfo.node);
            }
            if (currInfo.node.left != null) {
                min = Math.min(min, currInfo.hd - 1);
                q.add(new info(currInfo.node.left, currInfo.hd - 1));
            }
            if (currInfo.node.right != null) {
                max = Math.max(max, currInfo.hd + 1);
                q.add(new info(currInfo.node.right, currInfo.hd + 1));
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }
}
