
package extended;

/**
 *
 * @author brandonsladek
 */

public class ExtendedEuclideanAlgorithmDriver {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        ExtendedEuclideanAlgorithm test = new ExtendedEuclideanAlgorithm();
        
        test.extendedGCD(10, 5);
        test.extendedGCD(100, 25);
        test.extendedGCD(24, 8);
        test.extendedGCD(55, 14);
        test.extendedGCD(402, 200);
        test.extendedGCD(568, 202);
        test.extendedGCD(1000, 268);
        test.extendedGCD(10432, 568);
        test.extendedGCD(13456, 987);
        test.extendedGCD(18094, 1456);
    }
}