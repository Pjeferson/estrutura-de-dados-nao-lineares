/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package non.linear.data.structures.binarySearchTrees.RedBlackTree;

/**
 *
 * @author pjeferson
 */
public class NodeRB {
    private int key;
    private boolean color;/*0-Red, 1-Black*/
    
    private NodeRB parent, left,right;
    
    public NodeRB(int key) {
        this.key = key;
        this.color = false;
    }
    
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isBlack() {
        return color;
    }

    public void changeColor() {
        this.color = !this.color;
    }

    public NodeRB getParent() {
        return parent;
    }

    public void setParent(NodeRB parent) {
        this.parent = parent;
    }

    public NodeRB getLeft() {
        return left;
    }

    public void setLeft(NodeRB left) {
        this.left = left;
    }

    public NodeRB getRight() {
        return right;
    }

    public void setRight(NodeRB right) {
        this.right = right;
    }
}
