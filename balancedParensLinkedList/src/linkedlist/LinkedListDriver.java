
package linkedlist;

import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

/**
 *
 * @author brandonsladek
 */

public class LinkedListDriver {

    public static void main(String[] args) {
        
        String string = null; //for user input
        boolean done = false; //for while loop
        SinglyLinkedList listStack = new SinglyLinkedList();
        
        String[] choices = {"Check string", "Quit"};
        
        while(!done) {
            int choice = JOptionPane.showOptionDialog(
                    null, 
                    "Click a choice",
                    "Balanced Parentheses Verifier",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, 
                    null,
                    choices,
                    choices[0]);
            try{
                switch (choice){
                case 0:

            string = JOptionPane.showInputDialog("Enter string");
            
            char[] charArray = string.toCharArray(); //turn input into char array
            
            for(int i = 0; i < charArray.length; i++) { //parse entire char array
                if(charArray[i] == '(')
                    listStack.addFirst('('); //each '(' that is parsed will add a
                //Node to the front of the list, or push the char onto the stack
                if(charArray[i] == ')')
                    listStack.removeFirst(); //each ')' that is parsed will remove
                //the first Node in the list, or pop the top char out of the stack
            }
            
            if(listStack.isEmpty() && listStack.check() == 0) 
                JOptionPane.showMessageDialog(null, "The string has balanced parentheses.");
            else {
                JOptionPane.showMessageDialog(null, "The string does NOT have balanced parentheses.");
            }
            listStack.resetCheck();
            break;
            
                case 1: 
                done = true;
                JOptionPane.showMessageDialog(null, "Thank you.");
            break;
                    
                default: 
                    JOptionPane.showMessageDialog(null, "Invalid selection; try again.");
            break;
                    
        }
     }
            catch(NoSuchElementException e) {
                
            }
        }
    }
}