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
public class BSTest {
    public static void main(String[] args) {
        // BinarySearchTree bst;
        BinarySearchTreeDefault bst = new BinarySearchTreeDefault();
        bst.insert(10, 10);
        bst.insert(20, 20);
        bst.order();
        System.out.println(bst.size());
    }
}
