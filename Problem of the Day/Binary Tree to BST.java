//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            Node rootA = g.binaryTreeToBST(root);
            printInorder(rootA);
            System.out.println();
            t--;
        }
    }
}


// } Driver Code Ends


class Solution
{
    
    void inorder(Node root,ArrayList<Integer>list){
        if(root==null) return;
        
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }
    Node helper(int[] nums,int left,int right){
        if (left > right) {
            return null ;
        }

        int mid = left + (right - left) / 2;
        Node root=new Node(nums[mid]);
        
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        
        return root;
    }
    Node binaryTreeToBST(Node root)
    {
       ArrayList<Integer>list=new ArrayList<>();
       inorder(root,list);
       
       int[] arr = new int[list.size()];

        // Copy elements from ArrayList to int array
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        return helper(arr,0,arr.length-1);
        
        
    }
}
 
