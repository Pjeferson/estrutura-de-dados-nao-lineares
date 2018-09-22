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
public class TreeRB {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    private NodeRB root,nil;
    private int size;
    
    public TreeRB () {
        this.root = null;
        this.size = 0;
        this.nil = new NodeRB(-1);
        this.nil.setBlack();
    }
    public void updateInsert(NodeRB n) {
        if(!n.getParent().isBlack()){
            if(n.getParent().getParent().isLeft(n.getParent())){
                NodeRB aux = n.getParent().getParent().getRight();
                if(!aux.isBlack()){
                    n.getParent().setBlack();
                    aux.setBlack();
                    n.getParent().getParent().setRed();
                    n=n.getParent().getParent();
                }else if(n == n.getParent().getRight()){
                     n=n.getParent();
                     leftRotate(n);
                }else {
                    n.getParent().setBlack();
                    n.getParent().getParent().setRed();
                    rightRotate(n.getParent().getParent());
                }
            }
            else{
                
                NodeRB aux = n.getParent().getParent().getLeft();
                if(!aux.isBlack()){
                    n.getParent().setBlack();
                    aux.setBlack();
                    n.getParent().getParent().setRed();
                    n=n.getParent().getParent();
                }else if(n == n.getParent().getLeft()){
                     n=n.getParent();
                     rightRotate(n);
                }
                else {
                    n.getParent().setBlack();
                    n.getParent().getParent().setRed();
                    leftRotate(n.getParent().getParent());
                }
            }
            updateInsert(n);
        }
        else {
           this.root.setBlack();
        }
    }
    private NodeRB leftRotate(NodeRB n){//x
        NodeRB nRight = n.getRight();
        NodeRB rightLeft =  nRight.getLeft();

        if(n == this.root){
            nRight.setParent(null);
            this.root = nRight;
        }
        else{
            if(n.getParent().isLeft(n)){
                n.getParent().setLeft(nRight);
                nRight.setParent(n.getParent());
            }
            else{
                n.getParent().setRight(nRight);
                nRight.setParent(n.getParent());
            }
        }
            
        nRight.setLeft(n); 
        n.setParent(nRight);
        
        n.setRight(rightLeft);
        if(rightLeft != null) rightLeft.setParent(n);
        
        return nRight;
    }
    
    private NodeRB rightRotate(NodeRB n){
        NodeRB nLeft = n.getLeft();
        NodeRB leftRight = nLeft.getRight();

        if(n == this.root) {
            nLeft.setParent(null);
            this.root = nLeft;
        }
        else{
            if(n.getParent().isLeft(n)){
                n.getParent().setLeft(nLeft);
                nLeft.setParent(n.getParent());
            }
            else{
                n.getParent().setRight(nLeft);
                nLeft.setParent(n.getParent());
            }
        }
        nLeft.setRight(n);
        n.setParent(nLeft);
        
        n.setLeft(leftRight);
        if(leftRight != null) leftRight.setParent(n);
        
        return nLeft;
    }
    public void insert(int key) {
        NodeRB n = new NodeRB(key);
        if(this.root == null) { // First Node
            n.setParent(this.nil);
            n.setLeft(this.nil);
            n.setRight(this.nil);
            this.root = n;
        }else {
            insert(this.root, n);
        }
        updateInsert(n);
        this.size++;
    }
    private void insert(NodeRB current, NodeRB inserting) {
        if (inserting.getKey() < current.getKey()){
            if(current.getLeft() == this.nil){
                inserting.setParent(current);
                inserting.setLeft(this.nil);
                inserting.setRight(this.nil);
                current.setLeft(inserting);
            }
            else {
                insert(current.getLeft(), inserting);
            }
        } else {
            if(current.getRight() == this.nil){
                
                inserting.setParent(current);
                inserting.setLeft(this.nil);
                inserting.setRight(this.nil);
                current.setRight(inserting);
            }
            else {   
                insert(current.getRight(), inserting);
            }
        }
    }
    
    public void order(){
        order(this.root);
        System.out.print("\n");
    }
    private void order(NodeRB n){
        if(n == this.nil) return;
        else {
            order(n.getLeft());
            System.out.print((n.isBlack()?ANSI_BLACK:ANSI_RED)+n.getKey()+ANSI_RESET + " ");
            order(n.getRight());
        }
    }
    public void print(){
        StringBuffer out = new StringBuffer();
        this.root.printTree(out);
        System.out.println(out);
    }
}
