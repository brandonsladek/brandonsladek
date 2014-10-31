
package extended;

/**
 *
 * @author brandonsladek
 */

public class ExtendedEuclideanAlgorithm {
    
    ExtendedEuclideanAlgorithm() {}
    
    public void extendedGCD(int A, int B) {
        int a = A;
        int b = B;
        int s = 1;
        int t = 0;
        int u = 0;
        int v = 1;
        int r;
        int q;
        int newU;
        int newV;
        boolean check = false;
        
        while(b != 0) {
            r = a%b;
            q = a/b;
            a = b;
            b = r;
            newU = s - u*q;
            newV = t - v*q;
            s = u;
            t = v;
            u = newU;
            v = newV;
        } //end while
        
        int[] answer = new int[3];
        answer[0] = a;
        answer[1] = s;
        answer[2] = t;
        
        //if this method correctly computes the gcd(A,B) and s and t, then (a) should be equal to (sA + tB)
        if(a == (s*A + t*B)) {
            System.out.println("The GCD is " + answer[0] + ", s = " + answer[1] + ", t = " + answer[2]);
        }
        else {
            System.out.println("Something is wrong!");
        }
    }
}
