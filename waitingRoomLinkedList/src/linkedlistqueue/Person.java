
package linkedlistqueue;

/**
 *
 * @author brandonsladek
 */

public class Person {
    
    private final String lastName;
    private final String firstName;
    private final int ticketNum;
    
    public Person(String last, String first, int num) {
        lastName = last;
        firstName = first;
        ticketNum = num;
    }
    
    public String getInfo() {
        return ("[" + lastName + ", " + firstName + "]" + " --> Ticket Number: " + ticketNum);
        
    }
    
}

