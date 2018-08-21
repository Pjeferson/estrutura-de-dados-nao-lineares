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

    public NodeAVL getParent() {
        return parent;
    }

    public void setParent(NodeAVL parent) {
        this.parent = parent;
    }

    public NodeAVL getLeft() {
        return left;
    }

    public void setLeft(NodeAVL left) {
        this.left = left;
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
}
