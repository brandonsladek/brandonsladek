
package fibonacci;

/**
 *
 * @author brandonsladek
 */

public class FibonacciRecursion {
    
    public FibonacciRecursion() {}
    
    public int fibonacciRecursion(int n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        else {
            return fibonacciRecursion(n-1) + fibonacciRecursion(n-2);
        }
    }
}
