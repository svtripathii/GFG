//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args)throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res,out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node node,PrintWriter out)
    {
        while(node != null)
        {
            out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        Node ptr=node,ptr1=node;
        ArrayList<Integer> arr;               
        int i=0,j=0,size=0;
        
        while(ptr!=null){
            size++;
            ptr=ptr.next;
        }
        
        int loop=size/k;ptr=node;
        
        for(i=0;i<loop;i++){
            
            arr = new ArrayList<Integer>();
            
            for(j=0;j<k;j++){
                arr.add(ptr.data);
                ptr=ptr.next;
            }
            
            Collections.reverse(arr);
            for(j=0;j<k;j++){
                ptr1.data=arr.get(j);
                ptr1=ptr1.next;
            }
            
        }
        if(size%k !=0){
            arr = new ArrayList<Integer>();
            while(ptr != null){
                arr.add(ptr.data);
                ptr=ptr.next;
            }
            Collections.reverse(arr);j=0;
            while(ptr1 != null){
                ptr1.data=arr.get(j++);
                ptr1=ptr1.next;
            }
        }
        return node;
    }
}
