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
        System.out.print("\n");
    }
    private void order(Node n){
        if(n == null) return;
        else {
            order(n.getLeft());
            System.out.print(n.getKey() + " ");
            order(n.getRight());
        }
    }
    
    @Override
    public Node find(int key) {
        return find(key, this.root);
    }
    private Node find(int key, Node start) {
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

    @Override
    public void remove(int key) {
        Node delete = find(key);
        if (delete == null) return;
        Node removed = remove(delete);
        if(delete.getParent() == null)
            this.root = removed;
        this.size--;
    }
    private Node remove(Node n){
        if(n.getLeft() != null && n.getRight() != null){
            Node next = findlastLeft(n.getRight());
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
    private Node findlastLeft(Node n){
        if(n.getLeft() != null){
            return findlastLeft(n.getLeft());
        }
        return n;
    }
    @Override
    public int size() {
        return this.size;
    }
}
