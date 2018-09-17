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
    private NodeRB root,nil;
    private int size;
    
    public TreeRB () {
        this.root = null;
        this.size = 0;
        this.nil = new NodeRB(-1);
        if(!this.nil.isBlack()) this.nil.changeColor();
    }
    
    public void insert(int key) {
        NodeRB n = new NodeRB(key);
        if(this.root == null) { // First Node
            this.root = n;
            this.size = 1;
            n.setParent(this.nil);
            n.setLeft(this.nil);
            n.setRight(this.nil);
            return;
        }
        insert(this.root, n);
        //updateFbInsert(inserted);
        this.size++;
    }
    private void insert(NodeRB current, NodeRB inserting) {
        if (inserting.getKey() < current.getKey()){
            if(current.getLeft() == this.nil){
                current.setLeft(inserting);
                inserting.setParent(current);
                inserting.setLeft(this.nil);
                inserting.setRight(this.nil);
                
            }
            else {
                insert(current.getLeft(), inserting);
            }
        } else {
            if(current.getRight() == this.nil){
                current.setRight(inserting);
                inserting.setParent(current);
                inserting.setLeft(this.nil);
                inserting.setRight(this.nil);
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
            System.out.print(n.getKey() + " ");
            order(n.getRight());
        }
    }
}
