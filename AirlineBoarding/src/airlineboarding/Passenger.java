
package airlineboarding;

/**
 *
 * @author brandonsladek
 */
   
public class Passenger implements Comparable<Passenger> {
    //longevity number example: 20080315 (year, month, day) the smaller the number the longer the pass. has been employed
    
    String lastName;
    String confirmationNumber;
    int classNumber;
    int longevity;
    
    //regular passengers do not have to enter their date of employment
    public Passenger(String last, int classNum) {
        lastName = last;
        confirmationNumber = ("T" + ((int) (Math.random()*10000)));
        classNumber = classNum;
    }
    
    //only standby passengers have to enter their date of employment (longevity)
    public Passenger(int lon, String last) {
        lastName = last;
        confirmationNumber = ("T" + ((int) (Math.random()*10000)));
        longevity = lon;
    }
    
    public String getLastName() {
        return (lastName);
    }
    
    public String getConNum() {
        return confirmationNumber;
    }
    
    public int getLongevity() {
        return longevity;
    }
    
    public int getClassNum() {
        return classNumber;
    }
    
    @Override
    public int compareTo(Passenger o) {
        if(this.getLongevity() < o.getLongevity())
            return 1;
        if(this.getLongevity() == o.getLongevity())
            return 0;
        return -1;
    }
}