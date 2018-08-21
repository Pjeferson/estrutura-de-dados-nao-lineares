/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package non.linear.data.structures.binarySearchTrees.AVLTree;

import non.linear.data.structures.binarySearchTrees.BinarySearchTree;

/**
 *
 * @author pjeferson
 */
public class TreeAVL {
private NodeAVL root;
    
    private int size;
    
    public TreeAVL () {
        this.root = null;
        this.size = 0;
    }

    public void order(){
        order(this.root);
        System.out.print("\n");
    }
    private void order(NodeAVL n){
        if(n == null) return;
        else {
            order(n.getLeft());
            System.out.print(n.getKey() + ":" + n.getFb() +" ");
            order(n.getRight());
        }
    }
    
    public NodeAVL find(int key) {
        return find(key, this.root);
    }
    private NodeAVL find(int key, NodeAVL start) {
        if(start == null) {
            return null; // Explicit Comparison
        }
        if(start.getKey() == key){
            return start;
        }
        if (key < start.getKey()){
            return find(key, start.getLeft());
        }
        else {
             return find(key, start.getRight());
        }
    }
    
    private void updateFbInsert(NodeAVL n, NodeAVL parent){
        if(parent == null) return;
        if(parent.getLeft() != null && parent.getLeft().getKey() == n.getKey()){
            parent.incFb();
        }else {
            parent.decFb();
        }
        if(parent.getFb() == 0) return;
        if(parent.getFb() > 1){
            rebalanceLeft(parent);
            return;
        } else if (parent.getFb() < -1){
            rebalanceRight(parent);
            return;
        }
        updateFbInsert(parent, parent.getParent());
            
    }
    
    public void insert(int key, Object val) {
        NodeAVL n = new NodeAVL(key, val);
        if(this.root == null) {
            this.root = n;
            return;
        }
        NodeAVL inserted = insert(this.root, n);
        updateFbInsert(inserted, inserted.getParent());
        this.size++;
    }
    private NodeAVL insert(NodeAVL current, NodeAVL inserting) {
        if(current == null) {
            /*
            Bug in return: this aways return the root
            Possible solution: pass a reference for the parent, set this in constructor and return the newest node
            
            */
            current = inserting;
        }
        else if (inserting.getKey() < current.getKey()){
            current.setLeft(insert(current.getLeft(), inserting));
            current.getLeft().setParent(current);
        }
        else if (inserting.getKey() > current.getKey()){
           current.setRight(insert(current.getRight(), inserting));
           current.getRight().setParent(current);
        }
        else {
            current.setVal(inserting.getVal());
        }
        return current;
    }
    
    public void remove(int key) {
        NodeAVL delete = find(key);
        if (delete == null) return;
        NodeAVL removed = remove(delete);
        if(delete.getParent() == null)
            this.root = removed;
        this.size--;
    }
    private NodeAVL remove(NodeAVL n){
        if(n.getLeft() != null && n.getRight() != null){
            NodeAVL next = findlastLeft(n.getRight());
            n.setKey(next.getKey());
            n.setVal(next.getVal());
            remove(next);
            return n;
        } else if(n.getLeft() != null){
            n.getLeft().setParent(n.getParent());
            if(n.getParent() != null){
                if(n.getParent().getLeft()!=null && n.getParent().getLeft().getKey() == n.getKey()) n.getParent().setLeft(n.getLeft());
                else n.getParent().setRight(n.getLeft());
            }
            return n.getLeft();
        } else if(n.getRight() != null){
            n.getRight().setParent(n.getParent());
            if(n.getParent() != null){
                if(n.getParent().getLeft()!=null && n.getParent().getLeft().getKey() == n.getKey()) n.getParent().setLeft(n.getRight());
                else n.getParent().setRight(n.getRight());
            }
            return n.getRight();
        } else {
            if(n.getParent() != null){
                if(n.getParent().getLeft()!=null && n.getParent().getLeft().getKey() == n.getKey()) n.getParent().setLeft(null);
                else n.getParent().setRight(null);
            }
            return null;
        } 
    }
    private NodeAVL findlastLeft(NodeAVL n){
        if(n.getLeft() != null){
            return findlastLeft(n.getLeft());
        }
        return n;
    }
    
    public int size() {
        return this.size;
    }
    
    private void rebalanceLeft(NodeAVL n){
        /*
            - Left Height > Right Height
            - Check if dooble rotate is needed
        */
        System.out.println("Left ajust needed");
    }
    private void rebalanceRight(NodeAVL n){
        /*
            - Left Height < Right Height 
            - Check if dooble rotate is needed
        */
        System.out.println("Right ajust needed");
    }
}
