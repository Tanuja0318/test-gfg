/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    int preIndex=0;
    HashMap<Integer, Integer> postMap;
    public Node constructTree(int[] pre, int[] post) {
        postMap=new HashMap<>();
        for(int i=0;i<post.length;i++){
            postMap.put(post[i], i);
        }
        return build(pre, post, 0, post.length-1);
    }
    private Node build(int[] pre, int[] post, int l, int r){
        if (preIndex >= pre.length || l > r) return null;
        Node root = new Node(pre[preIndex++]);
        if (l == r || preIndex >= pre.length) return root;
        int leftRootVal = pre[preIndex];
        int leftRootIndex = postMap.get(leftRootVal);
        root.left = build(pre, post, l, leftRootIndex);
        root.right = build(pre, post, leftRootIndex + 1, r - 1);
        return root;
    }
}