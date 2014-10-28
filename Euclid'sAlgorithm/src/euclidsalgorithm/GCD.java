
package euclidsalgorithm;

/**
 *
 * @author brandonsladek
 */

public class GCD {
    
    public GCD() {}
    
    public int gcd(int a, int b) {
        int r;
        while(b!=0) {
            r = (a%b);
            a = b;
            b = r;
        }
        return a;
  }
}
