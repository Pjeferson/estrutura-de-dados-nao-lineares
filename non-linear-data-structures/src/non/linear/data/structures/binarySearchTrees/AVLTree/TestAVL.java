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
        avl.insert(10, 10);
        avl.insert(11, 11);
        avl.insert(20, 20);
        avl.insert(21, 21);
        avl.insert(30, 30);
        avl.insert(31, 31);
        avl.insert(40, 40);
        avl.insert(41, 41);
        avl.order();
        /*avl.remove(30);
        avl.remove(40);
        avl.remove(31);
        avl.order();*/

        System.out.println(avl.size());
        System.out.println(avl.find(40) != null);
    }
}
