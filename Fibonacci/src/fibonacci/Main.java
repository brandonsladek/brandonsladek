
package fibonacci;

/**
 *
 * @author brandonsladek
 */

public class Main {

    public static void main(String[] args) {
        
        FibonacciRecursion recursion = new FibonacciRecursion();
        FibonacciInduction induction = new FibonacciInduction();
        FibonacciFormula formula = new FibonacciFormula();
        
        long startTime;
        long endTime;
        long duration;
        
        System.out.println("Recursive Fibonacci Method");
        startTime = System.nanoTime();
        recursion.fibonacciRecursion(5);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 5, " + recursion.fibonacciRecursion(5) + ", " + duration + " nanoseconds");
        
        startTime = System.nanoTime();
        recursion.fibonacciRecursion(10);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 10, " + recursion.fibonacciRecursion(10) + ", " + duration + " nanoseconds");
        
        startTime = System.nanoTime();
        recursion.fibonacciRecursion(15);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 15, " + recursion.fibonacciRecursion(15) + ", " + duration + " nanoseconds");
        
        startTime = System.nanoTime();
        recursion.fibonacciRecursion(20);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 20, " + recursion.fibonacciRecursion(20) + ", " + duration + " nanoseconds");
        
        startTime = System.nanoTime();
        recursion.fibonacciRecursion(25);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 25, " + recursion.fibonacciRecursion(25) + ", " + duration + " nanoseconds");
        
        System.out.println("-------------------------------");
        
        System.out.println("Inductive Fibonacci Method");
        startTime = System.nanoTime();
        induction.fibonacciInduction(5);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 5, " + induction.fibonacciInduction(5) + ", " + duration + " nanoseconds");
        
        startTime = System.nanoTime();
        induction.fibonacciInduction(10);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 10, " + induction.fibonacciInduction(10) + ", " + duration + " nanoseconds");
        
        startTime = System.nanoTime();
        induction.fibonacciInduction(15);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 15, " + induction.fibonacciInduction(15) + ", " + duration + " nanoseconds");
        
        startTime = System.nanoTime();
        induction.fibonacciInduction(20);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 20, " + induction.fibonacciInduction(20) + ", " + duration + " nanoseconds");
        
        startTime = System.nanoTime();
        induction.fibonacciInduction(25);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 25, " + induction.fibonacciInduction(25) + ", " + duration + " nanoseconds");
        
        System.out.println("-------------------------------");
        
        System.out.println("Formulaic Fibonacci Method");
        startTime = System.nanoTime();
        formula.fibonacciFormula(5);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 5, " + formula.fibonacciFormula(5) + ", " + duration + " nanoseconds");
        
        startTime = System.nanoTime();
        formula.fibonacciFormula(10);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 10, " + formula.fibonacciFormula(10) + ", " + duration + " nanoseconds");
        
        startTime = System.nanoTime();
        formula.fibonacciFormula(15);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 15, " + formula.fibonacciFormula(15) + ", " + duration + " nanoseconds");
        
        startTime = System.nanoTime();
        formula.fibonacciFormula(20);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 20, " + formula.fibonacciFormula(20) + ", " + duration + " nanoseconds");
        
        startTime = System.nanoTime();
        formula.fibonacciFormula(25);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("For n = 25, " + formula.fibonacciFormula(25) + ", " + duration + " nanoseconds");
        
        System.out.println("-------------------------------DONE");
    }
    
}
