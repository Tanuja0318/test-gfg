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
    public int findMedian(Node root) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        int n = inorderList.size();
        if (n % 2 == 1) {
            return inorderList.get(n / 2);
        } else {
            return inorderList.get((n / 2) - 1);
        }
    }
    private void inorder(Node root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}