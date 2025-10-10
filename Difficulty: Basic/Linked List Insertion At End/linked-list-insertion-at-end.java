/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node insertAtEnd(Node head, int x) {
        if (head == null) 
            return new Node(x);
        Node p=head;
        while(p.next!=null){
            p=p.next;
        }
        p.next=new Node(x);
        return head;
    }
}