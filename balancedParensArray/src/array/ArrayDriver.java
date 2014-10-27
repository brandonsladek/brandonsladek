
package array;

import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

/**
 *
 * @author brandonsladek
 */

public class ArrayDriver {

    public static void main(String[] args) {
        
        String string = null;
        boolean done = false; // variable for while loop
        ArrayStack arrayStack = new ArrayStack(100);
        
        String[] choices = {"Check string", "Quit"}; //options
        
        while(!done) {
            int choice = JOptionPane.showOptionDialog(null, "Click a choice", 
                    "Balanced Parentheses Verifier", JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
            
            try {
                switch(choice) {
                    case 0:
                            string = JOptionPane.showInputDialog("Enter String"); //user input
                            char[] charArray = string.toCharArray(); //turn user input into char array
            
                            for(int i = 0; i < charArray.length; i++) { //parse entire char array
                     
                                 if(charArray[i] == '(')
                                  arrayStack.push('('); //each '(' will be pushed into stack
                                 if(charArray[i] == ')')
                                  arrayStack.pop(); //each ')' will pop a '(' out of stack
                                }
                            if(arrayStack.isEmpty() && arrayStack.check() == 0) 
                             JOptionPane.showMessageDialog(null, "The string has balanced parentheses.");
                            else
                             JOptionPane.showMessageDialog(null, "The string does NOT have balanced parentheses.");
            
                            arrayStack.reset(); //empty stack
                            arrayStack.checkReset(); //reset check 
                    break;
                        
                    case 1:
                        done = true;
                        JOptionPane.showMessageDialog(null, "Thank you.");
                    break;
                }
            }
            catch(NoSuchElementException e) {
                
            }
        }
    }
    
}
