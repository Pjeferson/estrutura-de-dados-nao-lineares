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
public class TestAVL {
    public static void main(String[] args) {
        TreeAVL avl = new TreeAVL();
        /*avl.insert(20, null); //Normal Rotation
        avl.insert(4, null);
        avl.insert(15, null);*/
        
        /*avl.insert(20, null);//Double Rotation
        avl.insert(4, null);
        avl.insert(26, null);
        avl.insert(3, null);
        avl.insert(9, null);
        avl.insert(15, null);*/ 
        
        /*avl.insert(2, null); // Removing leaf
        avl.insert(1, null);
        avl.insert(4, null);
        avl.insert(3, null);
        avl.insert(5, null);
        avl.remove(1);*/
        
        avl.insert(5, null); // Removing leaf
        avl.insert(2, null);
        avl.insert(8, null);
        avl.insert(1, null);
        avl.insert(3, null);
        avl.insert(7, null);
        avl.insert(10, null);
        avl.insert(4, null);
        avl.insert(6, null);
        avl.insert(9, null);
        avl.insert(11, null);
        avl.insert(12, null);
        avl.remove(1);
                
        avl.print();
        System.out.println(avl.size());
        System.out.println(avl.find(40) != null);
    }
}
