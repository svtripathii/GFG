class Solution {
    // Function to return list containing elements of the right view of a binary tree.
    ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Traverse all nodes at the current level and add the last node's value to the result list.
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (i == levelSize - 1) {
                    result.add(node.data); // Last node encountered at the current level.
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
}
