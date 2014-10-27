
package array;

/**
 *
 * @author brandonsladek
 */

public class ArrayStack {
    
    private final char[] paren;
    private int top = 0; //to ensure that the first time "push" is 
    //called the value will be put into paren[0]
    public int check; //variable for checking if there was an attempt
    //to "pop" a '(' out of an empty stack, which would mean the string
    //is unbalanced
    
    public ArrayStack(int stackSize) {
        paren = new char[stackSize]; //array constructor
    }
    public void push(char parenValue) {
        paren[top] = parenValue; //put value in stack
        top++;
        }
    
    public void pop() {
        if(isEmpty()) {
        check++; //increment check is there was an attempt to "pop" a 
        //'(' out of an empty stack
        }
        if(!isEmpty()) {
        top--; //moving top reference is like deleting a value from the stack
       }
    }
    
    public char peek() {
        return paren[--top]; //shows most recently added value in stack
    }
    
    public boolean isEmpty() {
        return (top == 0); //top is initially 0 so if it's 0 then
        //the stack is empty
    }
    
    public int check() {
        return check;
    }
    
    public void reset() {
        top = 0; //empties stack
    }
    
    public void checkReset() {
        check = 0; //reset check
    }
}
