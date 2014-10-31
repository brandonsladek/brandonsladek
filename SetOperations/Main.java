
package set;

/**
 *
 * @author brandonsladek
 * 
 * This program allows the user to create sets and perform the union, intersection, and difference set operations on the created sets.
 */

public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Set set = new Set();
        int[] A = {1,2,3,4};
        int[] B = {4,5,6};
        
        System.out.println("A = {1,2,3,4} \nB = {4,5,6}");
        System.out.println();
        System.out.println("With sets A and B:");
        System.out.println();
        
        System.out.print("The union set is: ");
        set.printUnion(A, B); //constructs and prints the union of A and B
        System.out.println("It is " + set.checkUnion(A, B, 3) + " that 3 is in the union set.");
        System.out.println("It is " + set.checkUnion(A, B, 9) + " that 9 is in the union set.");
        System.out.println("------------------------------------------------");
        
        System.out.println();
        System.out.print("The intersection set is: ");
        set.printIntersection(A, B); //constructs and prints the intersection of A and B
        System.out.println("It is " + set.checkIntersection(A, B, 3) + " that 3 is in the intersection set.");
        System.out.println("It is " + set.checkIntersection(A, B, 4) + " that 4 is in the intersection set.");
        System.out.println("------------------------------------------------");
        
        System.out.println();
        System.out.print("The difference set (A-B) is: ");
        set.printDifference(A, B); //constructs and prints the difference of A and B
        System.out.println("It is " + set.checkDifference(A, B, 3) + " that 3 is in the difference set.");
        System.out.println("It is " + set.checkDifference(A, B, 4) + " that 4 is in the difference set.");
        System.out.println("------------------------------------------------");
        
        System.out.println();
        
        int[] C = {0,1,3,8,9,43,77};
        int[] D = {3,9,43,81};
        
        System.out.println("C = {0,1,3,8,9,43,77} \nD = {3,9,43,81}");
        System.out.println();
        System.out.println("With sets C and D:");
        System.out.println();
        
        System.out.print("The union set is: ");
        set.printUnion(C, D); //constructs and prints the union of C and D
        System.out.println("It is " + set.checkUnion(C, D, 3) + " that 3 is in the union set.");
        System.out.println("It is " + set.checkUnion(C, D, 82) + " that 82 is in the union set.");
        System.out.println("------------------------------------------------");
        
        System.out.println();
        System.out.print("The intersection set is: ");
        set.printIntersection(C, D); //constructs and prints the intersection of C and D
        System.out.println("It is " + set.checkIntersection(C, D, 3) + " that 3 is in the intersection set.");
        System.out.println("It is " + set.checkIntersection(C, D, 81) + " that 81 is in the intersection set.");
        System.out.println("------------------------------------------------");
        
        System.out.println();
        System.out.print("The difference set (C-D) is: ");
        set.printDifference(C, D); //constructs and prints the difference of C and D
        System.out.println("It is " + set.checkDifference(C, D, 77) + " that 77 is in the difference set.");
        System.out.println("It is " + set.checkDifference(C, D, 9) + " that 9 is in the difference set.");
        System.out.println("------------------------------------------------");
    }
}