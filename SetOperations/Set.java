
package set;

/**
 *
 * @author brandonsladek
 */
public class Set {
    
    public Set() {}
           
    //constructs a union set with A and B
    public int[] union(int[] A, int[] B) {
        int[] firstHalfUnion = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            firstHalfUnion[i] = A[i];
        }
        //determine number of unique elements in union set
        int j = A.length;
        int numElements = A.length;
        for(int i = 0; i < B.length; i++) {
            boolean found = false;
            for(int k = 0; k < A.length; k++) {
                if(firstHalfUnion[k] == B[i])
                    found = true;
            }
            if(!found) {
                numElements++;
            }
            j++;
        }
        //construct int array with numElements
        int[] union = new int[numElements];
        //copy A to the first half of union
        for(int i = 0; i < A.length; i++) {
            union[i] = A[i];
        }
        //copy unique elements of B to the second half of union
        int m = A.length;
        for(int i = 0; i < B.length; i++) {
            boolean found = false;
            for(int k = 0; k < A.length; k++) {
                if(union[k] == B[i])
                    found = true;
            }
            if(!found) {
                union[m] = B[i];
                m++;
            }
        }
        return union;
    }
    
    //print the union set
    public void printUnion(int[] A, int[] B) {
        int[] setToPrint = union(A,B);
        for(int i = 0; i < setToPrint.length; i++) {
            if(i < setToPrint.length-1)
            System.out.print(setToPrint[i] + ", ");
        else
            System.out.println(setToPrint[i]);
       }
    }
        
    //method to check if element c is in the union set
    //outputs true if found, false if not found in the union set
    public boolean checkUnion(int[] A, int[] B, int c) {
        boolean found = false;
        int[] setToCheck = union(A,B);
        for(int i = 0; i < setToCheck.length; i++) {
            if(setToCheck[i] == c) {
                found = true;
            }    
     }
        return found;
}

    //construct the intersection set with A and B
    public int[] intersection(int[] A, int[] B) {
        //int[] intersection = new int[A.length + B.length];
        int numElements = 0;
        for(int i = 0; i < A.length; i++) { 
            for(int j = 0; j < B.length; j++) {
                if(A[i] == B[j])
                    numElements++;
            }
        }
        int[] intersection = new int[numElements];
        int k = 0;
        for(int x = 0; x < A.length; x++) { 
            boolean found = false;
                for(int y = 0; y < B.length; y++) {
                    if(A[x] == B[y])
                        found = true;
            }
            if(found) {
            intersection[k] = A[x];
            k++;
            }
          }
        return intersection;
        }
  
    //print the intersection set
    public void printIntersection(int[] A, int[] B) {
        int[] setToPrint = intersection(A,B);
        for(int i = 0; i < setToPrint.length; i++) {
            if(i < setToPrint.length-1)
            System.out.print(setToPrint[i] + ", ");
        else
            System.out.println(setToPrint[i]);
       }
    }
    
    //method to check if element c is in the intersection set of A and B
    public boolean checkIntersection(int[] A, int[] B, int c) {
        int[] setToCheck = intersection(A,B);
        boolean found = false;
        for(int i = 0; i < setToCheck.length; i++) {
            if(setToCheck[i] == c)
                found = true;   
        }
        return found;
    }
    
    //construct the difference set with A and B
    //NOTE: this difference method subtracts the second set from the first (A-B)
    public int[] difference(int[] A, int[] B) {
        int numElements = 0;//(A.length + B.length);
        for(int i = 0; i < A.length; i++) {
            boolean firstFound = false;
            for(int j = 0; j < B.length; j++) {
                if(A[i] == B[j])
                    firstFound = true;
            }
            if(!firstFound) {
                numElements++;
            }
        }
        int[] difference = new int[numElements];
        int k = 0;
        for(int x = 0; x < A.length; x++) {
            boolean found = false;
            for(int y = 0; y < B.length; y++) {
                if(A[x] == B[y])
                    found = true;
            }
            if(!found) {
                difference[k] = A[x];
                k++;
            }
        }
        return difference;
    }
    
    //print the difference set
    public void printDifference(int[] A, int[] B) {
        int[] setToPrint = difference(A,B);
        for(int i = 0; i < setToPrint.length; i++) {
            if(i < setToPrint.length-1)
            System.out.print(setToPrint[i] + ", ");
        else
            System.out.println(setToPrint[i]);
       }
    }
    
    //method to check if element c is in the difference set of A and B
    public boolean checkDifference(int[] A, int[] B, int c) {
        int[] setToCheck = difference(A, B);
        boolean found = false;
        for(int i = 0; i < setToCheck.length; i++) {
            if(setToCheck[i] == c)
                found = true;
        }
        return found;
    }
}