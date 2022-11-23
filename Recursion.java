import java.util.HashMap;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// ------------------------------------------------------------------------------
// Goal:
//  Java class representing the recursion: A(n, m) = A(n-1, m-1) + m*A(n-1, m)
//  with n=>m=>1, A(n, 1) = 1, A(n, n) = 1
// ------------------------------------------------------------------------------
class Recursion {   

    // ------------------------------------------------------------------------------
    // Goal:
    //  Caching values of the recursion to avoid calculating the same
    //  values multiple times using HashMaps.
    //
    // Reference:
    //  - https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
    // ------------------------------------------------------------------------------
    private HashMap<Integer, HashMap<Integer, Integer>> cache;

    // ------------------------------------------------------------------------------
    // Goal:
    //  Creating an empty HashMap.
    //
    // Input:
    //  No input is required.
    //
    // Output:
    //  No output is required.
    // ------------------------------------------------------------------------------
    public Recursion() {
        this.cache = new HashMap<Integer, HashMap<Integer, Integer>>();
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Recursively calls itself until the recursion is simplified
    //  into primitives.
    //
    // Optimization:
    //  Values might have been cached in memory.
    //
    // Reference:
    //  - https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html
    //
    // Input:
    //  Accepts a pair of n and m integers as defined above
    //  with n=>m=>1, A(n, 1) = 1, A(n, n) = 1
    //
    // Output:
    //  Returns the integer value resulting of resolving the recursion.
    // ------------------------------------------------------------------------------
    public int solveWithRecursion(int n, int m) {

        // Enforcing the restrictions on the input arguments.
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater or equal to 1");
        }
        if (m < 1) {
            throw new IllegalArgumentException("m must be greater or equal to 1");
        }
        if (n < m) {
            throw new IllegalArgumentException("n must be greater or equal to m");
        }

        // Primitive values of the recursion.
        if (m == 1) {
            return 1;
        }
        if (n == m) {
            return 1;
        }

        // Checking if the value is cached in memory.
        if (this.cache.containsKey(n)) {
            if (this.cache.get(n).containsKey(m)) {
                return this.cache.get(n).get(m);
            }
        }

        // Calling itself again until arriving into
        // primitive values of the recursion.
        int value = this.solveWithRecursion(n - 1, m - 1) + m * this.solveWithRecursion(n - 1, m);

        // Storing value into the in-memory cache.
        if (!this.cache.containsKey(n)) {
            this.cache.put(n, new HashMap<Integer, Integer>());
        }
        this.cache.get(n).put(m, value);

        // Returning the calculated value.
        return value;
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Solves the recursion using loops.
    //
    // Reference:
    //  - https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html
    //
    // Input:
    //  Accepts a pair of n and m integers as defined above
    //  with n=>m=>1, A(n, 1) = 1, A(n, n) = 1
    //
    // Output:
    //  Returns the integer value resulting of resolving the recursion.
    // ------------------------------------------------------------------------------
    public int solveWithoutRecursion(int n, int m) {

        // Declaring variables used in this function.
        int i;
        int j;
        int a;
        int b;
        int value;
        int window;
        int maxX;
        int maxY;
        ArrayList<Integer> tuple;
        HashMap<ArrayList<Integer>, Integer> cache;

        // Primitive values of the recursion.
        if (m == 1) {
            return 1;
        }
        if (n == m) {
            return 1;
        }

        // Enforcing the restrictions on the input arguments.
        if (n < 1) {
            throw new IllegalArgumentException("n must be greater or equal to 1");
        }
        if (m < 1) {
            throw new IllegalArgumentException("m must be greater or equal to 1");
        }
        if (n < m) {
            throw new IllegalArgumentException("n must be greater or equal to m");
        }

        // Calculates a sliding window to iterate over a triangle
        // in the matrix of possible values.
        window = n - m + 1;

        // Calculating the maximum iterations in the x-axis
        // and y-axis.
        maxX = n - 1;
        maxY = m;

        // Defining an ArrayList that will store the results
        // of the iterations in the triangle defined by the
        // sliding window `w`;
        cache = new HashMap<ArrayList<Integer>, Integer>();

        // For each row, it is only required to iterate in the
        // sliding window since those are the only values
        // that affect the value to be calculated.
        for (j = 1; j <= maxY; j++) { 
            for (i = j; i <= maxX && i - j < window; i++) {
                if (i == j || j == 1) {

                    // The value can be calculated directly.
                    value = 1;

                } else {

                    // The value to be calculated must be split
                    // into 3 parts.

                    // Part I: Finding the cache value of `a`.
                    tuple = new ArrayList<Integer>();
                    tuple.add(i - 1);
                    tuple.add(j - 1);
                    a = cache.get(tuple);

                    // Part II: Finding the cache value of `b`.
                    tuple = new ArrayList<Integer>();
                    tuple.add(i - 1);
                    tuple.add(j);
                    b = cache.get(tuple);

                    // Part III: Calculating the current value.
                    value = a + j * b;

                }

                // Caching the new value.
                tuple = new ArrayList<Integer>();
                tuple.add(i);
                tuple.add(j);
                cache.put(tuple, value);
            }
        }

        // Part I: Calculating the final value.
        tuple = new ArrayList<Integer>();
        tuple.add(n - 1);
        tuple.add(m - 1);
        a = cache.get(tuple);

        // Part II: Calculating the final value.
        tuple = new ArrayList<Integer>();
        tuple.add(n - 1);
        tuple.add(m);
        b = cache.get(tuple);

        // Returning calculated value.
        return a + m * b;
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Main method.
    //  Allows the user to introduce 2 integers and calculates the matrix
    //  and prints the union, intersection and difference.
    // ------------------------------------------------------------------------------
	public static void main( String [ ] args ) {   
        // Declaring variables.
        Scanner scanner;
        int n;
        int m;
        int i;
        int j;
        int result;
        String results;
        Recursion recursion;

        // Reading the value of `n` from STDIN.
        scanner = new Scanner(System.in);
        System.out.println("What is value `n`?");
        System.out.print(">>> ");
        n = scanner.nextInt();

        // Reading the value of `m` from STDIN.
        scanner = new Scanner(System.in);
        System.out.println("What is value `m`?");
        System.out.print(">>> ");
        m = scanner.nextInt();

        // Calculating the value of the recursion
        // with the given `n` and `m` values.
        System.out.println("Calculating: A(" + n + ", " + m + "):");
        recursion = new Recursion();
        result = recursion.solveWithRecursion(n, m);
        System.out.println(">>> " + result);

        // Calculating the matrix of all the values
        // up to `n` and `m` using recursion.
        System.out.println("Calculating with recursion:");
        for (i = 1; i <= n; i++) {
            results = "";
            for (j = 1; j <= i && j <= m; j++) {
                results = results + recursion.solveWithRecursion(i, j) + "  ";
            }
            System.out.println("n=" + i + ": " + results);
        }

        // Calculating the matrix of all the values
        // up to `n` and `m` using loops.
        System.out.println("Calculating without recursion:");
        for (i = 1; i <= n; i++) {
            results = "";
            for (j = 1; j <= i && j <= m; j++) {
                results = results + recursion.solveWithoutRecursion(i, j) + "  ";
            }
            System.out.println("n=" + i + ": " + results);
        }
	}
}
