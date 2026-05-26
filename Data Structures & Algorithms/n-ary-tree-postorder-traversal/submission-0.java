class Solution {
    public void getPostorder(Node n, List<Integer> al) {
        if (n == null)
            return;
        for (Node child : n.children)
            getPostorder(child, al);
        al.add(n.val);
    }
    public List<Integer> postorder(Node root) {
        List<Integer> al = new ArrayList<>();
        getPostorder(root, al);
        return al;
    }
}