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
public class TestRB {
    public static void main(String[] args) {
       TreeRB rb = new TreeRB();
       rb.insert(4);
       rb.insert(26);
       rb.insert(3);
       rb.insert(9);
       rb.insert(15);
       
       rb.print();
       rb.order();
    }
}
