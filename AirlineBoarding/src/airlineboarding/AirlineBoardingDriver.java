
package airlineboarding;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

/**
 *
 * @author brandonsladek
 */

public class AirlineBoardingDriver {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        boolean done = false;
        AirlineBoarding airlineBoarding = new AirlineBoarding();
        
        String[] options = {"Enqueue", "Dequeue Non-Standby", "Dequeue Standby", "Quit"};
        
        while(!done) {
            
            int choice = JOptionPane.showOptionDialog(null, "Click a choice.", "Hawaiian Airlines", 
                     JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            
            try {
                
                switch(choice) {
                    
                    case 0: //enqueue a passenger, determine whether passenger is a non-standby or standby passenger                 
                        String lastName = JOptionPane.showInputDialog(null, "Enter last name: ");
                        int classNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter class (first = 0, platinum = 1, standard = 2, standby = 3): "));
                        if(classNum == 3) { //if classNum is 3 the passenger is a standby passenger and will have to enter longevity
                            int longevity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter date of employment (yyyymmdd): "));
                            Passenger standbyPassenger = new Passenger(longevity, lastName);
                            airlineBoarding.enqueueStandby(standbyPassenger);
                        }
                        else { //regular passengers do not have to enter longevity
                            Passenger regularPassenger = new Passenger(lastName, classNum);
                            airlineBoarding.enqueueNonStandby(regularPassenger, classNum);
                        }
                    break;
                    //end case 0
                    
                    case 1: //dequeue a non-standby passenger from the one of the regular passenger queues
                        Passenger regularPassenger = airlineBoarding.dequeueNonStandby();
                        if(regularPassenger == null) {
                            JOptionPane.showMessageDialog(null, "There are no more regular passengers on the list!");
                        }
                        else
                        JOptionPane.showMessageDialog(null, "Passenger name: " + regularPassenger.getLastName() + "\n"
                                + "Confirmation number: " + regularPassenger.getConNum() + "\n"
                                + "Passenger has been removed from the regular passenger list.");
                    break;
                    //end case 1
                        
                    case 2: //dequeue a standby passenger from the standby queue
                        Passenger standbyPassenger = airlineBoarding.dequeueStandby();
                        if(standbyPassenger == null) {
                            JOptionPane.showMessageDialog(null, "There are no more standby passengers on the list!");
                        }
                        else
                        JOptionPane.showMessageDialog(null, "Passenger name: " + standbyPassenger.getLastName() + "\n"
                                + "Confirmation number: " + standbyPassenger.getConNum() + "\n"
                                + "Passenger has been removed from the standby passenger list.");
                    break;
                    //end case 2
                    
                    case 3: //quit
                        done = true;
                        JOptionPane.showMessageDialog(null, "Mahalo, and enjoy your flight.");
                    break;
                    //end case 3
                }
            }
            
            catch(NoSuchElementException e) {
                
            }
        }
        
    }
    
}