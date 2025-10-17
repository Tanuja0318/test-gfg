/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    static int sum = 0;
    public static void transformTree(Node root) {
        sum = 0; 
        transform(root);
    }
    private static void transform(Node root) {
        if (root == null)
            return;
        transform(root.right);
        int original = root.data;
        root.data = sum;
        sum += original;
        transform(root.left);
    }
}