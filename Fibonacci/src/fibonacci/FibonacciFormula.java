
package fibonacci;

/**
 *
 * @author brandonsladek
 */

public class FibonacciFormula {
    
    public FibonacciFormula() {}
    
    public int fibonacciFormula(int n) {
        double a = Math.pow(((1 + Math.sqrt(5)) / 2.0), n);
        double b = Math.pow(((1 - Math.sqrt(5)) / 2.0), n);
        return (int) Math.floor((a-b) / Math.sqrt(5));
    }
}
