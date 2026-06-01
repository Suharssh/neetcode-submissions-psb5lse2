/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node pcopy = p;
        Node qcopy = q;
        while(pcopy != qcopy){
            if(qcopy == null) qcopy = p;
            else qcopy = qcopy.parent;
            if(pcopy == null) pcopy = q;
            else pcopy = pcopy.parent;
        }
        return pcopy;
    }
}