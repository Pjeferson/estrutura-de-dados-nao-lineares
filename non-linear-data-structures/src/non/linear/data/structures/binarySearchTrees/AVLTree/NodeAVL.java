/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package non.linear.data.structures.binarySearchTrees.AVLTree;

/**
 *
 * @author pjeferson
 */
public class NodeAVL {
    private int key;
    private Object val;
    private int fb;
    
    private NodeAVL parent;
    private NodeAVL left;
    private NodeAVL right;

    public NodeAVL(int key, Object val){
        this.key = key;
        this.val = val;
        this.fb = 0;
        
        this.parent = null;
        this.left = null;
        this.right = null;
        
    }
    

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }
    public boolean hasParent() {
        return (this.getParent()!= null);
    }
    public NodeAVL getParent() {
        return parent;
    }

    public void setParent(NodeAVL parent) {
        this.parent = parent;
    }
    public boolean isLeft(NodeAVL other) {
        return (this.getLeft() != null && this.getLeft().getKey() == other.getKey());
    }
    public NodeAVL getLeft() {
        return left;
    }

    public void setLeft(NodeAVL left) {
        this.left = left;
    }
    public boolean isRight(NodeAVL other) {
        return (this.getRight() != null && this.getRight().getKey() == other.getKey());
    }
    public NodeAVL getRight() {
        return right;
    }

    public void setRight(NodeAVL right) {
        this.right = right;
    }
    
    public int getFb() {
        return fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }
    public void incFb() {
        this.fb++;
    }
    public void decFb() {
        this.fb--;
    }
    
    public void printTree(StringBuffer out){
        if (right != null) {
            right.printTree(out, true, "");
        }
        printNodeValue(out);
        if (left != null) {
            left.printTree(out, false, "");
        }
    }
    private void printNodeValue(StringBuffer out){
        out.append(key+":"+fb);
        out.append('\n');
    }
    // use string and not stringbuffer on purpose as we need to change the indent at each recursion
    private void printTree(StringBuffer out, boolean isRight, String indent){
        if (right != null) {
            right.printTree(out, true, indent + (isRight ? "        " : " |      "));
        }
        out.append(indent);
        if (isRight) {
            out.append(" /");
        } else {
            out.append(" \\");
        }
        out.append("----- ");
        printNodeValue(out);
        if (left != null) {
            left.printTree(out, false, indent + (isRight ? " |      " : "        "));
        }
    }
}
