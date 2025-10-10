/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class Solution {
    // Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head) {
        if (head == null || head.next == null)
            return head;
        Node p = head;
        while (p != null && p.next != null) {
            if (p.data == p.next.data) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}