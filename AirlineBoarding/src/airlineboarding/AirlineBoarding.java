
package airlineboarding;

/**
 *
 * @author brandonsladek
 * 
 */

public class AirlineBoarding {
    
    //constructor that instantiates an array of queues for different types of passengers
    public AirlineBoarding() {
        queues = new SimpleQueue[3];
        for(int i = 0; i < 3; i++) {
        queues[i] = new SimpleQueue<>();
        }
    }
    
    PriorityQueue<Passenger> standbyQueue = new PriorityQueue<>(); //priority queue declaration
    SimpleQueue<Passenger>[] queues; //array declaration
        
    public void enqueueNonStandby(Passenger p, int arrayNumber) {
        queues[arrayNumber].enqueue(p); //enqueue regular passenger into proper queue
    }
    
    public void enqueueStandby(Passenger p) {
        standbyQueue.enqueue(p); //enqueue standby passenger into priority queue
    }
    
    public Passenger dequeueNonStandby() {
        //passenger should be dequeued from whichever queue is the first to not be empty (checked in order from 0 to 1 to 2)
        if(!queues[0].isEmpty()) {
            return queues[0].dequeue();
        }
        else if(!queues[1].isEmpty()) {
            return queues[1].dequeue();
        }
        else if(!queues[2].isEmpty()) {
            return queues[2].dequeue();
        }
        else {
            return null;
        }
    }
    
    public Passenger dequeueStandby() {
        return standbyQueue.dequeue(); //dequeue passenger from priority queue
    }
}