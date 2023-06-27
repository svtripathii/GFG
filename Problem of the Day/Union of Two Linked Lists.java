//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Sol
{
    public static Node findUnion(Node head1,Node head2)
    {
        HashMap<Integer, Integer> map =new HashMap<>();
        Node temp= head1;
        while(temp != null) {
            map.put(temp.data, map.getOrDefault(temp.data,0)+1);
            temp = temp.next;
        }
        temp = head2;
        while(temp!= null){
            map.put(temp.data, map.getOrDefault(temp.data, 0)+1);
            temp =temp.next;
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int val =entry.getKey();
    
           arr.add(val);
        }
        Collections.sort(arr);
        Node head = new Node(-1);
        temp =head;
        for(Integer elem: arr){
            temp.next= new Node(elem);
            temp =temp.next;
        }
        return head.next;
    }
}
