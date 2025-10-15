/*
class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        Node dummy=new Node(0);
        Node q=dummy;
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                q.next=head1;
                head1=head1.next;
            }
            else{
                q.next=head2;
                head2=head2.next;
            }
            q=q.next;
        }
        if(head1!=null) 
            q.next=head1;
        else
            q.next=head2;
        return dummy.next;
    }
}