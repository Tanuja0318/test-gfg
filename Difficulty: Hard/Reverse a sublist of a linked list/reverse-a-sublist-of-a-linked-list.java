// User function Template for Java

/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution {
    public static Node reverseBetween(int left, int right, Node head) {
        if(head==null || left==right) return head;
        Node dummyHead = new Node(0);
        dummyHead.next = head;
        Node prev = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        Node curr = prev.next;
        Node next = null;
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyHead.next;
    }
}