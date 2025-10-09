/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }

    private void postOrderTraversal(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        postOrderTraversal(node.left, result);
        postOrderTraversal(node.right, result);
        result.add(node.data);
    }
}