
package linkedlistqueue;

import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

/**
 *
 * @author brandonsladek
 */

public class LinkedListQueueDriver {

    public static void main(String[] args) {
        
        boolean done = false; //while loop parameter
        int ticketNum = 1;
        SinglyLinkedList<Person> list; //linked list queue
        list = new SinglyLinkedList<>();
        
        String[] options = {"Join Waiting List", "Next", "Quit"}; //GUI panel options
        
        while(!done) {
            int choice = JOptionPane.showOptionDialog(null, "Please click a choice.", "Customer Service", 
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            try {
                switch(choice) {
                    case 0: 
                        String lastName = JOptionPane.showInputDialog(null, "Enter last name");
                        String firstName = JOptionPane.showInputDialog(null, "Enter first name");
                        Person person = new Person(lastName, firstName, ticketNum); //create new person object
                        ticketNum++; //increment ticket number by 1
                        list.enqueue(person); //add person object to queue
                        JOptionPane.showMessageDialog(null, person.getInfo()); //return info to customer
                        break;
                        
                    case 1: 
                        if(list.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "There is nobody on the list!");
                            break;
                        }
                        else {
                            //remove person from the front of the queue and return their info
                            JOptionPane.showMessageDialog(null, list.dequeue().getInfo()); 
                            break;
                        }
                        
                    case 2:
                        done = true; //break out of while loop
                        break;
                        
                    default: 
                        JOptionPane.showMessageDialog(null, "Invalid response; try again.");
                        break;
                }
                
            }
            catch(NoSuchElementException e) {
                
            }
        }
        
        JOptionPane.showMessageDialog(null, "Thank you");
    }
    
}
