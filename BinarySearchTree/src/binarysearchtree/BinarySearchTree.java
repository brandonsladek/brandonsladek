
package binarysearchtree;

/**
 *
 * @author brandonsladek
 */

public class BinarySearchTree {
    private class Node<E> {
        private E element;      // an element is stored in each node
        private Node<E> parent; // pointer to parent of node
        private Node<E> left;   // pointer to left child of node
        private Node<E> right;  // pointer to right child of node
        
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        
        // access methods
        public E getElement() { return element; } 
        public Node<E> getParent() { return parent; }
        public Node<E> getLeftChild() { return left; }
        public Node<E> getRightChild() { return right; }
        
        // update methods
        public void setElement(E e) { element = e; }
        public void setParent(Node<E> p) { parent = p; }
        public void setLeftChild(Node<E> l) { left = l; }
        public void setRightChild(Node<E> r) { right = r; }
        
    } //----------- end of nested Node class -------------
    
    public BinarySearchTree() { } // constructor creates an empty binary tree
    
    // instance variables
    private Node<Integer> root;
    int size = 0; // initial tree size is 0
    
    public int size() { return size; } // get size of the tree (number of nodes)
    
    public void createRoot() {
        root = new Node(null, null, null, null);
    }
    
    public Node<Integer> getRoot() { return root; }
    
    public void insertInteger(int number) {
        Node<Integer> newNode = new Node(number, null, null, null);
        if(size == 0) {
            root.setElement(number);
            size++;
        }
        
        else {
            Node<Integer> current = root;
            Node<Integer> previous = null;
   
            while(current != null) {
                previous = current;
                if(number <= current.getElement()) {
                    current = current.getLeftChild();
                }
                else {
                    current = current.getRightChild();
                }
            }
            
            if(number <= previous.getElement()) {
                previous.setLeftChild(newNode);
                newNode.setParent(previous);
                size++;
            }
            
            if(number > previous.getElement()) {
                previous.setRightChild(newNode);
                newNode.setParent(previous);
                size++;
            }
            
        } // end of else statement
    } // end of insertInteger method
    
    public static void preorderTraversal(Node<Integer> current, BinarySearchTreeDriver bstd) {
        if(current != null) { 
            bstd.addPreorderData((Integer) current.getElement());
            preorderTraversal(current.getLeftChild(), bstd);
            preorderTraversal(current.getRightChild(), bstd); 
        }
    } // end of preorderTraversal method
    
    public static void postorderTraversal(Node<Integer> current, BinarySearchTreeDriver bstd) {
        if(current != null) {
        postorderTraversal(current.getLeftChild(), bstd);
        postorderTraversal(current.getRightChild(), bstd);
        bstd.addPostorderData((Integer) current.getElement());
        }
    } // end of postorderTraversal method
    
    public static void inorderTraversal(Node<Integer> current, BinarySearchTreeDriver bstd) {
        if(current != null) {
        if(current.getLeftChild() != null)
            inorderTraversal(current.getLeftChild(), bstd);
        bstd.addInorderData((Integer) current.getElement());
        if(current.getRightChild() != null)
            inorderTraversal(current.getRightChild(), bstd);
        }
    }
    
    public boolean search(int number) {
        boolean found = false;
        Node<Integer> node = root;
        while(!found && node != null) {
            if(number == node.getElement()) {
                found = true;
            }
            else if(number < node.getElement()) {
                node = node.getLeftChild();
            }
            else {
                node = node.getRightChild();
            }
        }
        return found;
    } // end of search method
    
} // end of BinarySearchTree class
