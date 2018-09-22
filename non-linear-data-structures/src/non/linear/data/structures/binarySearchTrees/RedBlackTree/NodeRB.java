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
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    
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
    public void setBlack() {
        this.color = true;
    }
    public void setRed() {
        this.color = false;
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
    public boolean isLeft(NodeRB other) {
        return (this.getLeft() != null && this.getLeft().getKey() == other.getKey());
    }
    public NodeRB getRight() {
        return right;
    }

    public void setRight(NodeRB right) {
        this.right = right;
    }
    public boolean isRight(NodeRB other) {
        return (this.getRight() != null && this.getRight().getKey() == other.getKey());
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
        if(this.isBlack())
            out.append(ANSI_BLACK+key+ANSI_RESET);
        else
            out.append(ANSI_RED+key+ANSI_RESET);
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
