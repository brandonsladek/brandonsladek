
package airlineboarding;

/**
 *
 * @author brandonsladek
 * @param <E>
 */

public class SimpleQueue<E> {
    
    //nested Node class for LinkedList
    private static class Node<E> {
        private final E element; //the object reference in each Node
        private Node<E> next; //pointer to next Node
        public Node(E e, Node<E> n) { //constructor for Node
            element = e;
            next = n;
        }
        
        public void setNext(Node<E> n) {
            next = n; //sets pointer to function parameter Node
        }
        public Node<E> getNext() {
            return next; //returns next Node
        }
        
        public E getInfo(Node<E> n) {
            return n.element; //return element within Node
        }
    }
    
   private Node head; //pointer to first Node in list
   private Node tail; //pointer to last Node in list
   private int size; //size of list
    
   public SimpleQueue() { }
   
   public int size() {
       return size; //return number of Nodes in list
   }
   
   public boolean isEmpty() {
       return (size == 0); //returns true if list is empty
   }
    
   public void enqueue(E e) { //adds a Node to the end of the list
       Node newest = new Node<>(e, null);
       if(isEmpty())
           head = newest;
       else
           tail.setNext(newest);
       tail = newest;
       size++;
   }
   
   public E dequeue() { //removes a Node from the front of the list
       if(isEmpty()) {
          return null;
       }
       else {
       Node temp = head;
       head = head.getNext(); //link out first Node and reassign head pointer
       size--;
       return (E) temp.getInfo(temp);
     } 
   }
}