
package euclidsalgorithm;

/**
 *
 * @author brandonsladek
 */

public class EuclidsAlgorithmDriver {

    public static void main(String[] args) {
        
        GCD test = new GCD();
        
        System.out.println(test.gcd(11346, 544));
        System.out.println(test.gcd(5432, 735));
        System.out.println(test.gcd(1341, 890));
        System.out.println(test.gcd(542, 234));
        System.out.println(test.gcd(435, 145));
        System.out.println(test.gcd(233, 132));
        System.out.println(test.gcd(100, 25));
        System.out.println(test.gcd(92, 32));
        System.out.println(test.gcd(54, 32));
        System.out.println(test.gcd(77, 20));
    }
    
}
