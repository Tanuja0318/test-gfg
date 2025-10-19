/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) return b[0] - a[0]; 
                return b[1] - a[1]; 
            }
        );
        for (int val : inorderList) {
            int diff = Math.abs(val - target);
            pq.offer(new int[]{diff, val});
            if (pq.size() > k)
                pq.poll(); 
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll()[1]);
        }
        return result; 
    }
    private static void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}