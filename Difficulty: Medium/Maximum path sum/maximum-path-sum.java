/*
class Node{
    int data;
    Node left, right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    int maxSum;

    int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxSum;
    }
    int maxPathDown(Node node) {
        if (node == null)
            return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxSum = Math.max(maxSum, left + right + node.data);
        return Math.max(left, right) + node.data;
    }
}