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
public interface BinarySearchTree {
    public Node find(int key);
    public void insert(int key, Object val);
    public void remove(int key);
    
    public int size();
}
