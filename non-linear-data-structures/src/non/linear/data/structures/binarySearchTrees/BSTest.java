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
        BinarySearchTreeDefault bst = new BinarySearchTreeDefault();
        bst.insert(30, 30);
        bst.insert(10, 10);
        bst.insert(40, 40);
        bst.insert(20, 20);
        bst.insert(31, 31);
        bst.insert(11, 11);
        bst.insert(41, 41);
        bst.insert(21, 21);
        bst.order();
        bst.remove(30);
        bst.remove(40);
        bst.remove(31);
        bst.order();

        System.out.println(bst.size());
        System.out.println(bst.find(40) != null);
    }
}
