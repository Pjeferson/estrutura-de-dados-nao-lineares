/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package non.linear.data.structures.binarySearchTrees.AVLTree;

import static java.lang.Math.max;
import static java.lang.Math.min;

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
    public void print(){
        StringBuffer out = new StringBuffer();
        this.root.printTree(out);
        System.out.println(out);
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
    
    private void updateFbInsert(NodeAVL inserted){
        if(!inserted.hasParent()) return;
        if(inserted.getParent().isLeft(inserted))
            inserted.getParent().incFb();
        else
            inserted.getParent().decFb();
        if(inserted.getParent().getFb() > 1)
            rebalanceLeft( inserted.getParent());
        else if ( inserted.getParent().getFb() < -1)
            rebalanceRight( inserted.getParent());
        if(inserted.getParent().getFb() != 0)
            updateFbInsert(inserted.getParent());
            
    }
    
    public void insert(int key, Object val) {
        NodeAVL n = new NodeAVL(key, val);
        if(this.root == null) { // First Node
            this.root = n;
            this.size = 1;
            return;
        }
        NodeAVL inserted = insert(this.root, n);
        updateFbInsert(inserted);
        this.size++;
    }
    private NodeAVL insert(NodeAVL current, NodeAVL inserting) {
        if (inserting.getKey() < current.getKey()){
            if(current.getLeft() != null){
                return insert(current.getLeft(), inserting);
            }
            else {   
                current.setLeft(inserting);
                inserting.setParent(current);
                return inserting;
            }
        } else {
            if(current.getRight() != null){
                return insert(current.getRight(), inserting);
            }
            else {   
                current.setRight(inserting);
                inserting.setParent(current);
                return inserting;
            }
        }
    }
    
    private void updateFbRemove(NodeAVL replaced){
        if(!replaced.hasParent()) return;
        if(replaced.getParent().isLeft(replaced))
            replaced.getParent().decFb();
        else
            replaced.getParent().incFb();
        
        if(replaced.getParent().getFb() > 1)
            rebalanceLeft(replaced.getParent());
        else if (replaced.getParent().getFb() < -1)
            rebalanceRight(replaced.getParent());
        if(replaced.getParent().getFb() == 0)
            updateFbRemove(replaced.getParent());
            
    }
    
    public void remove(int key) {
        NodeAVL delete = find(key);
        if (delete == null) return;
        NodeAVL replaced = remove(delete);
        if(replaced != null){
            updateFbRemove(replaced);
        }
        this.size--;
    }
    private NodeAVL remove(NodeAVL n){
        if(n.getLeft() != null && n.getRight() != null){
            NodeAVL next = findlastLeft(n.getRight());
            n.setKey(next.getKey());
            n.setVal(next.getVal());
            return remove(next);
        } else if(n.getLeft() != null){
            n.getLeft().setParent(n.getParent());
            if(n.hasParent()){
                if(n.getParent().isLeft(n)) 
                    n.getParent().setLeft(n.getLeft());
                else
                    n.getParent().setRight(n.getLeft());
            }else {
                this.root = n.getLeft();
            }
            return n.getLeft();
        } else if(n.getRight() != null){
            n.getRight().setParent(n.getParent());
            if(n.getParent() != null){
                if(n.getParent().isLeft(n))
                    n.getParent().setLeft(n.getRight());
                else
                    n.getParent().setRight(n.getRight());
            }else {
                this.root = n.getRight();
            }
            return n.getRight();
        } else {
            if(n.getParent() != null){
                if(n.getParent().isLeft(n)){
                    n.getParent().setLeft(null);
                    n.getParent().decFb();
                }
                else{
                    n.getParent().setRight(null);
                    n.getParent().incFb();
                }
                NodeAVL aux = n.getParent();
                if(n.getParent().getFb() > 1)
                    aux = rebalanceLeft(n.getParent());
                else if(n.getParent().getFb() < -1)
                    aux = rebalanceRight(n.getParent());
                if(n.getParent().getFb() == 0)
                    return aux;
                return null;
            }
            this.root = null;
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
    
    private NodeAVL rebalanceLeft(NodeAVL n){
        if(n.getLeft().getFb() >= 0)
            return rightRotate(n);
        else 
            return doubleRightRotate(n);
    }
    
    private NodeAVL rebalanceRight(NodeAVL n){
        if(n.getRight().getFb() <= 0)
            return leftRotate(n);
        else
            return doubleLeftRotate(n);
    }
    
    private NodeAVL doubleLeftRotate(NodeAVL n){
        rightRotate(n.getRight());
        return leftRotate(n);
    }
    
    private NodeAVL doubleRightRotate(NodeAVL n){
        leftRotate(n.getLeft());
        return rightRotate(n);
    }
    private NodeAVL leftRotate(NodeAVL n){//x
        NodeAVL nRight = n.getRight();
        NodeAVL rightLeft =  nRight.getLeft();

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
        
        n.setFb(n.getFb()+1 - min(nRight.getFb(), 0));
        nRight.setFb(nRight.getFb()+1 + max(n.getFb(), 0));
        return nRight;
    }
    
    private NodeAVL rightRotate(NodeAVL n){
        NodeAVL nLeft = n.getLeft();
        NodeAVL leftRight = nLeft.getRight();

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
        
        n.setFb(n.getFb()-1 - max(nLeft.getFb(), 0));
        nLeft.setFb(nLeft.getFb()-1 + min(n.getFb(), 0));
        return nLeft;
    }
}
