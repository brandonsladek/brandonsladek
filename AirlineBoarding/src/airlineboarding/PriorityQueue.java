
package airlineboarding;

/**
 *
 * @author brandonsladek
 * @param <E>
 */

//priority queue will be made with a doubly linked list sorted by longevity

public class PriorityQueue<E extends Comparable> {
    private class Node<E> {
        Node<E> prev;
        Node<E> next;
        E element;
        
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        
        public Node<E> getPrev() {
            return prev;
        }
        
        public Node<E> getNext() {
            return next;
        }
        
        public void setPrev(Node<E> p) {
            prev = p;
        }
        
        public void setNext(Node<E> n) {
            next = n;
        }
        
        public E getElement() {
            return element;
        }
    } //end of nested Node class
    
    int size;
    private final Node<E> header;
    private final Node<E> trailer;
    
    public PriorityQueue() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
        size = 0;
    }
    
    public boolean isEmpty() {
        return (size==0);
    }
    
    //insert passenger into priority queue according to longevity
    public void enqueue(E e) {
        if(size == 0) {
            Node<E> newNode = new Node<>(e, header, trailer);
            header.setNext(newNode);
            trailer.setPrev(newNode);
            size++;
        }
        else {
            Node<E> current = header.getNext(); //need "current' node to compare to newNode
            while(current != trailer && (e.compareTo(current.getElement())) == -1) {
                    current = current.getNext(); //move to the next node in the list
            }
            if(current != trailer && e.compareTo(current.getElement()) == 0) {
                current = current.getNext();
            }
            Node<E> behindCurrent = current.getPrev();
            Node<E> newNode = new Node<>(e, behindCurrent, current);
            behindCurrent.setNext(newNode);
            current.setPrev(newNode);
            size++;
        }                     
    }
    
    public E dequeue() {
        if(size==0) {
            return null;
        }
        else {
        Node<E> temp = header.getNext();
        header.setNext(temp.getNext());
        Node<E> tempNext = temp.getNext();
        tempNext.setPrev(header);
        size--;
        return temp.getElement();
        }
    }
}