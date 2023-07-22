class Solution
{
    //Function to remove duplicates from unsorted linked list.
    public Node removeDuplicates(Node head) 
    {
       HashSet<Integer> hs=new LinkedHashSet<>();
       Node temp=head;
       while(temp!=null)
       {
           hs.add(temp.data);
           temp=temp.next;
       }
       temp=head;
       int count=0;
       for(int x : hs)
       {
           temp.data=x;
           count++;
           if(count==hs.size()){temp.next=null;break;}
           temp=temp.next;
       }
       temp.next=null;
       return head;
    }
}
