class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
       
        
        Node temp=head;
        int zcount=0;
        int ocount=0;
        int tcount=0;
        while(temp!=null){
            if(temp.data==0){
                zcount++;
            }
            else if(temp.data==1){
                ocount++;
            }else{
                tcount++;
            }
            temp=temp.next;
        }
         Node ans=head;
        while(ans!=null){
        while(zcount!=0){
            ans.data=0;
            ans=ans.next;
            zcount--;
        }
        while(ocount!=0){
            ans.data=1;
            ans=ans.next;
            ocount--;
        }
        while(tcount!=0){
            ans.data=2;
            ans=ans.next;
            tcount--;
        }
        }
        return head;
    }
}
