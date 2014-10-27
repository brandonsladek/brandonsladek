
package fibonacci;

/**
 *
 * @author brandonsladek
 */

public class FibonacciInduction {
    //going to be a for or while loop
    
    public FibonacciInduction() {}
    
    public int fibonacciInduction(int n) {
        int a = 0;
        int b = 1;
        int answer = 0;
        int j = 1;
        
        while(j <= n) {
            answer = a + b;
            b = a;
            a = answer;
            j++;
        }
        
        return answer;
        
    }
}
