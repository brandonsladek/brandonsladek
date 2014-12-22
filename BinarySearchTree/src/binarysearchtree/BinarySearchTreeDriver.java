
package binarysearchtree;

import java.util.Random;
import javax.swing.JOptionPane;
import java.util.NoSuchElementException;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.FileWriter;
//import java.net.URI;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Scanner;

/**
 *
 * @author brandonsladek
 */

public class BinarySearchTreeDriver {
    
    String preorderData = "";
    String postorderData = "";
    String inorderData = "";
    
    //methods to return strings that represent tree traversals
    
    public void addPreorderData(int in) {
        this.preorderData += in + " ";
    }
    
    public void addPostorderData(int in) {
        this.postorderData += in + " ";
    }
    
    public void addInorderData(int in) {
        this.inorderData += in + " ";
    }
    
    public String getPreorderData() {
        return preorderData;
    }
    
    public String getPostorderData() {
        return postorderData;
    }
    
    public String getInorderData() {
        return inorderData;
    }
    
    public void clearPreorderData() {
        this.preorderData = "";
    }
    
    public void clearPostorderData() {
        this.postorderData = "";
    }
    
    public void clearInorderData() {
        this.inorderData = "";
    }
    
    //end of tree traversal string methods
    
    //constructor
    public BinarySearchTreeDriver() { 
                
        boolean done = false;
        BinarySearchTree tree = new BinarySearchTree();
        String[] options = {"Quit","Search","Inorder","Postorder","Preorder","CheckOrder"};
        //File file = null;
        
        int numberOfIntegers = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number of integers to"
                               + " be sorted in binary search tree:"));
        int randomIntRange = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter desired maximum of (non-negative)"
                                    + " random integers: ")); //determine range of random integers
        Random randomInteger = new Random();
                        
           tree.createRoot();
           String order = "";
           
                    for(int i = 0; i < numberOfIntegers; i++) {
                        int num = randomInteger.nextInt(randomIntRange);
                        order += num + " ";
                        tree.insertInteger(num);
                     }
                    
        JOptionPane.showMessageDialog(null, "The following window has an option called CheckOrder.\nThis "
                    + "option will display the order in which the randomly\ngenerated integers were inserted"
                    + " into the Binary Search Tree."); //NOTE          
                        
        while(!done) {
            
            int choice = JOptionPane.showOptionDialog(null, "Please choose an option below:", "Binary Search Tree", 
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[5]);
            
            try {
                switch(choice) {
                      
//------------------ this was my code for the file reading --------------------------------------
//                        try {
//                            Path p = Paths.get(URI.create("file:///BinarySearchTree/dist/"));
//                            if(file != null)
//                                file.delete();
//                            file = new File("integerFile.txt");
//                            BufferedWriter output = new BufferedWriter(new FileWriter(file));
//                            for(int i = 0; i < numberOfIntegers; i++) {
//                                output.write(randomInteger.nextInt(randomIntRange) + " ");
//                            }
//                            output.close();
//                        }
//                        catch(IOException e) {
//                            e.printStackTrace();
//                        } // end of writing to file integer.txt
                        
//                        try {
//                        Scanner scanner = new Scanner(file);
//                        tree.createRoot();
//                        while(scanner.hasNextInt()) {
//                            tree.insertInteger(scanner.nextInt());
//                           }
//                        } catch(FileNotFoundException e) {
//                            
//                         }
//-----------------------------------------------------------------------------------------------                   
                    case 5:
                        JOptionPane.showMessageDialog(null, "The integers were inserted into the tree in this order (left to right):\n " + order);
                        break; //end of case 5
                        
                    case 4: 
                        BinarySearchTree.preorderTraversal(tree.getRoot(), this);
                        JOptionPane.showMessageDialog(null, this.getPreorderData());
                        this.clearPreorderData();
                        break; // end of case 1
                        
                    case 3:
                        BinarySearchTree.postorderTraversal(tree.getRoot(), this);
                        JOptionPane.showMessageDialog(null, this.getPostorderData());
                        this.clearPostorderData();
                        break; // end of case 2
                        
                    case 2:
                        BinarySearchTree.inorderTraversal(tree.getRoot(), this);
                        JOptionPane.showMessageDialog(null, this.getInorderData());
                        this.clearInorderData();
                        break; // end of case 3
                        
                    case 1:
                        int numToSearch = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number to be searched: "));
                        JOptionPane.showMessageDialog(null, "It is " + tree.search(numToSearch) + " that " + numToSearch + " is "
                                + "in the Binary Search Tree.");
                        break; // end of case 4
                        
                    case 0: 
                        done = true;
                        break; // end of case 5
                }
            }
            catch(NoSuchElementException e) { }
        }
        JOptionPane.showMessageDialog(null, "Thank you.");        
    } // end of constructor
    
    public static void main(String[] args) {
         new BinarySearchTreeDriver();
    } // end of main method
}