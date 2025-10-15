/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node swapKth(Node head, int k) {
        if (head == null) return head;
        Node curr = head;
        for (int i = 1; i < k; i++) {
            if (curr.next != null)
                curr = curr.next;
            else
                return head; 
        }
        Node p = curr;
        Node q = head;
        while (curr.next != null) {
            q = q.next;
            curr = curr.next;
        }
        int temp = p.data;
        p.data = q.data;
        q.data = temp;
        return head;
    }
}
