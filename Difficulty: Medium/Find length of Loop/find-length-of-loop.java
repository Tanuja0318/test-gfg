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
    public int lengthOfLoop(Node head) {
        /*if (head == null || head.next == null) return 0;
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return countLoopLength(slow);
            }
        }
        return 0;
    }
    private int countLoopLength(Node node) {
        int count = 1;
        Node temp = node.next;
        while (temp != node) {
            count++;
            temp = temp.next;
        }
        return count;*/
        
        
        if (head == null || head.next == null) return 0;
        int count=0;
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                count=1;
                slow=slow.next;
                while(slow!=fast){
                    count++;
                    slow=slow.next;
                }
                break;
            }
        }
        return count;
    }
}