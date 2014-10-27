
package linkedlist;

/**
 *
 * @author brandonsladek
 */

public class SinglyLinkedList {
    
    //nested Node class for LinkedList
    private static class Node<E> {
        private final E element; //the object reference in each node
        private Node<E> next; //pointer to next node
        public Node(E e, Node<E> n) { //constructor for Node
            element = e;
            next = n;
        }
        
        public void setNext(Node<E> n) {
            next = n; //not used but I guess it's good practice
        }
        public Node<E> getNext() {
            return next; //returns next Node
        }
    }
    
   private Node head; //pointer to first Node in list
   private Node tail; //pointer to last Node in list
   private int size; //size of list
   private int check; //variable for determining if the
   private Node top; //pointer to top of stack
    
   public SinglyLinkedList() { }
   
   public int size() {
       return size; //return number of Nodes in list
   }
   
   public boolean isEmpty() {
       return (size == 0); //returns true if list is empty
   }
   
   public void addFirst(char e) { 
       head = new Node<>(e, head); //assigns head pointer
       //to new Node and makes the next pointer point to
       //the previous head Node
       if(size == 0) {
       tail = head;
       }
       size++;
   }
   
   public void addLast(char e) { //not used but again good practice...
       Node newest = new Node<>(e, null);
       if(isEmpty())
           head = newest;
       else
           tail.setNext(newest);
       tail = newest;
       size++;
   }
   
   public void removeFirst() { 
       if(isEmpty()) {
           check++;
       }
       if(!isEmpty()) {
       head = head.getNext(); //assigns head pointer to the
       //next Node after head, essentially linking out the
       //original head Node (the first Node in list)
       size--;
     }  
   }
   
   public int check() {
       return check;
   }
   
   public void resetCheck() {
       check = 0;
   }
}
