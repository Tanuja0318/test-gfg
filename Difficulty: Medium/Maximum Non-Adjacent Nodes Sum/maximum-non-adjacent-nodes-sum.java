/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    static class Pair {
        int include; 
        int exclude; 
        Pair(int include, int exclude) {
            this.include = include;
            this.exclude = exclude;
        }
    }
    public int getMaxSum(Node root) {
        Pair result = helper(root);
        return Math.max(result.include, result.exclude);
    }
    private static Pair helper(Node root) {
        if (root == null)
            return new Pair(0, 0);
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        int include = root.data + left.exclude + right.exclude;
        int exclude = Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);
        return new Pair(include, exclude);
    }
}