/*
class Node {
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    ArrayList<Integer> res=new ArrayList<>();
    public ArrayList<Integer> inOrder(Node root) {
        if(root!=null){
            inOrder(root.left);
            res.add(root.data);
            inOrder(root.right);
        }
        return res;
    }
}