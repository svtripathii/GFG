class Solution {
    
    public void inOrder(Node root, ArrayList<Integer> inorder) {
        if(root == null)
            return;
            
        inOrder(root.left, inorder);
        inorder.add(root.data);
        inOrder(root.right, inorder);
    }
    
    public void newTree(Node root, ArrayList<Integer> inorder, int[] idx) {
        if(root == null)
            return;
            
        newTree(root.left, inorder, idx);
        root.data = inorder.get(idx[0]++);
        newTree(root.right, inorder, idx);
    }
    
    public Node correctBST(Node root) {
        // code here.
        ArrayList<Integer> inorder = new ArrayList<>();
        inOrder(root, inorder);
        Collections.sort(inorder);
        int[] idx = {0};
        
        newTree(root, inorder, idx);
        
        return root;
    }
}