
package arrayqueue;

/**
 *
 * @author brandonsladek
 * @param <E>
 */

public class ArrayQueue<E> {
    
    private final E[] data; //array for storing queue objects
    private int front = 0; //front of queue
    private int numElements = 0;
    
    public ArrayQueue(int capacity) { //constructor for array
        data = (E[]) new Object[capacity];
    }
    
    public int size() {
        return numElements;
    }
    
    public boolean isEmpty() {
        return (numElements == 0);
    }
    
    public boolean isFull() {
        return (numElements == data.length);
    }
    
    public void enqueue(E element) throws IllegalStateException {
        //adds new object to the end of the queue
        if(isFull()) {
            throw new IllegalStateException("Queue is full!");
        }
        //modular arithmetic for wrap-around array queue
        int available = ((front + numElements) % data.length);
        data[available] = element;
        numElements++;
    }
    
    public E dequeue() { //removes object from the front of the queue
        if(isEmpty()) {
            return null;
        }
        E element = data[front];
        data[front] = null; //clear array index value
        //modular arithmetic for determining the new front of the queue
        front = ((front + 1) % data.length);
        numElements--;
        return element;
    }
}