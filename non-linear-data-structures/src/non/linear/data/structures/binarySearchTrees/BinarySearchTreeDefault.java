/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package non.linear.data.structures.binarySearchTrees;

/**
 *
 * @author pjeferson
 */
public class BinarySearchTreeDefault implements BinarySearchTree{
    private Node root;
    
    private int size;
    
    public BinarySearchTreeDefault () {
        this.root = null;
        this.size = 0;
    }

    public void order(){
        order(this.root);
    }
    private void order(Node n){
        if(n == null) return;
        else {
            System.out.print(n.getKey() + " ");
            order(n.getLeft());
            order(n.getRight());
        }
        System.out.print("\n");
    }
    
    @Override
    public Node find(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(int key, Object val) {
        Node n = new Node(key, val);
        if(this.root == null) {
            this.root = n;
        }else{
            insert(this.root, n);
        }
        this.size++;
    }
    private Node insert(Node current, Node inserting) {
        if(current == null) {
            current = inserting;
        }
        else if (inserting.getKey() < current.getKey()){
            current.setLeft(insert(current.getLeft(), inserting));
        }
        else if (inserting.getKey() > current.getKey()){
           current.setRight(insert(current.getRight(), inserting));
        }
        else {
            current.setVal(inserting.getVal());
        }
        return current;
    }

    @Override
    public void remove(int key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return this.size;
    }
}
