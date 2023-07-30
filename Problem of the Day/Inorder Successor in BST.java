class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
         {
          //add code here.
          
          ArrayList<Integer> l = new ArrayList<>();
          find(root,l);
          int res = 0;
          for(int i =0;i<l.size()-1;i++){
              
              if(l.get(i)==x.data){
                  
                  res = l.get(i+1);
              }
          }
          if(res == 0){
              res = -1;
          }
          Node temp = new Node(res);
          return temp;
          
         }
         
         public static void find(Node root, ArrayList<Integer> l){
             if(root==null){
                 return;
             }
             find(root.left,l);
             l.add(root.data);
             find(root.right,l);
         }
         
}
