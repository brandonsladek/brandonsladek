
package arrayqueue;

import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

/**
 *
 * @author brandonsladek
 */

public class ArrayQueueDriver {

    public static void main(String[] args) {
        
        boolean done = false; //while loop parameter
        int ticketNum = 1;
        ArrayQueue<Person> queue;
        queue = new ArrayQueue<>(100);
        
        String[] options = {"Join Waiting List", "Next", "Quit"}; //GUI panel options
        
        while(!done) {
            int choice = JOptionPane.showOptionDialog(null, "Please click a choice", "Welcome to Customer Service", 
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            try {
                
                switch(choice) {
                    case 0: 
                        String lastName = JOptionPane.showInputDialog("Enter your last name");
                        String firstName = JOptionPane.showInputDialog("Enter your first name");
                        Person person = new Person(lastName, firstName, ticketNum); //create new person object
                        ticketNum++; //increment ticket number by 1
                        queue.enqueue(person); //add person object to the end of the queue
                        JOptionPane.showMessageDialog(null, person.getInfo()); //return the person's information
                        break;
                        
                    case 1:
                        if(queue.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "There is nobody on the list!");
                        }
                        else {
                            //remove person object from the front of the queue and return the person's information
                            JOptionPane.showMessageDialog(null, queue.dequeue().getInfo());
                        }
                        break;
                        
                    case 2:
                        done = true;
                        break;
                        
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid response; try again.");
                        break;
                        
                }
            }
            catch(NoSuchElementException e) {
                
            }
        }
        
        JOptionPane.showMessageDialog(null, "Thank you.");
        
        
    }
    
}