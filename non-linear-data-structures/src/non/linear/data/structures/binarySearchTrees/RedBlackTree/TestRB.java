/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package non.linear.data.structures.binarySearchTrees.RedBlackTree;

import java.util.Scanner;

/**
 *
 * @author pjeferson
 */
public class TestRB {
    public static void main(String[] args) {
        TreeRB rb = new TreeRB();
        
        boolean key = true;
        Scanner reader = new Scanner(System.in);
        while(key){
            System.out.println("Ops: in, rm and end");
            String in = reader.next();
            int n;
            switch(in){
               case "in":
                    n = reader.nextInt();
                    rb.insert(n);
                    break;
               case "rm":
                    n = reader.nextInt();
                    rb.remove(n);
                    break;
               case "end":
                    key = false;
                    reader.close();
                    break;
            }
            rb.print();
        }
        
       /*rb.insert(4);
       rb.insert(26);
       rb.insert(3);
       rb.insert(9);
       rb.insert(15);*/
       
       rb.print();
       rb.order();
    }
}
