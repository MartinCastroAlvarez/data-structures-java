import java.util.Scanner; 

// ------------------------------------------------------------------------------
// Goal:
//  Analyzing the complexity of multiple algorithms to solve the
//  same polynomial exponentiation problem.
// ------------------------------------------------------------------------------
public class Complexity {

    // ------------------------------------------------------------------------------
    // Goal:
    //  Applies the polynomial function without using recursion.
    //
    // Input:
    //  Accepts an array of coefficients `pol`, an `x` term and an exponent `i`.
    //
    // Output:
    //  The result of applying the polynomial function to `pol`, `x` and `i`.
    //
    // Example:
    //  If `pol` is [1, 2, 3, 4, 5, 6], `x` is 2 and `n` is 3,
    //  then the output is: 26
    //  - when i = 0 => resultado = 1 + 2 * 0 = 1
    //  - when i = 1 => resultado = 2 + 2 * 1 = 4
    //  - when i = 2 => resultado = 3 + 2 * 4 = 11
    //  - when i = 3 => resultado = 4 + 2 * 11 = 26
    //
    // Time Complexity:
    //  O(n) => 1 + n * 1 + 1 ~ n
    // ------------------------------------------------------------------------------
    private static double calculaHorner(double [ ] pol, double x, int n) {
        // One single elemental operation: assigning an integer to a variable.
        double resultado = 0;
        // Loop executed `n+1` times, from in the following range: [0, n],
        // which is approximately a complexity of `n`.
        for (int i = 0; i <= n; i++) {
            // Two single elemental operations: a multiplication and a sum,
            // which can be considered a single elemental math operation.
            resultado = (resultado * x) + pol[i];
        }
        // One single element operation: returning the result of the function.
        return resultado;
    } 

    // ------------------------------------------------------------------------------
    // Goal:
    //  Applies the polynomial function using an external function.
    //
    // Input:
    //  Accepts an array of coefficients `pol`, an `x` term and an exponent `i`.
    //
    // Output:
    //  The result of applying the polynomial function to `pol`, `x` and `i`.
    //
    // Example:
    //  If `pol` is [1, 2, 3, 4, 5, 6], `x` is 2 and `n` is 3,
    //  then the output is: 26
    //  - when i = 3 => n - i = 0, pol[n - i] = 1, potencia(2, 3) = 8 => suma = 0 + 1 * 8 = 8
    //  - when i = 2 => n - i = 1, pol[n - i] = 2, potencia(2, 2) = 4 => suma = 8 + 2 * 4 = 16
    //  - when i = 1 => n - i = 2, pol[n - i] = 3, potencia(2, 1) = 2 => suma = 16 + 3 * 2 = 22
    //  - when i = 0 => n - i = 3, pol[n - i] = 4, potencia(2, 0) = 1 => suma = 22 + 4 * 1 = 26
    //
    // Time Complexity:
    //  O(n³) => 1 + 1 + n² + 1 ~ n²
    // ------------------------------------------------------------------------------
    private static double calculaConPotencia(double [ ] pol, double x, int n) {
        // One single elemental operation: assigning an integer to a variable.
        int i = n;
        // One single elemental operation: assigning a double to a variable.
        double suma = 0.0;
        // This loop is executed `n+1` times in the range: [0, n], which is
        // approximately a complexity of `n`.
        while (i >= 0) {
            // Accessing the value `pol[n-i]` is considered a single elemental operation,
            // since the array `pol` in indexed for that purpose.
            //
            // The complexity of `potencia(x, i)` depends is `i` and since `i` goes from
            // 0 to `n`, and solving the series (transforming `n` into `i`), the effective
            // complexity is `n(n+1)/2` which is approximately quadratical complexity: `n²`.
            suma += pol[n - i] * potencia(x, i);
            // A single elemental operation to increase the value of `i`.
            i--;
        }
        // One single element operation: returning the result of the function.
        return suma;
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Applies the polynomial function using recursion.
    //
    // Input:
    //  Accepts an array of coefficients `pol`, an `x` term and an exponent `i`.
    //
    // Output:
    //  The result of applying the polynomial function to `pol`, `x` and `i`.
    //
    // Example:
    //  If `pol` is [1, 2, 3, 4, 5, 6], `x` is 2 and `n` is 3,
    //  then the output is: 26
    //  - when i = 3 => pol[n - i] = 1, potencia1(x, i) = 8, suma = 0 + 1 * 8 = 8
    //  - when i = 2 => pol[n - i] = 2, potencia1(x, i) = 4, suma = 8 + 2 * 4 = 16
    //  - when i = 1 => pol[n - i] = 3, potencia1(x, i) = 2, suma = 16 + 2 * 3 = 22
    //  - when i = 0 => pol[n - i] = 4, potencia1(x, i) = 1, suma = 22 + 1 * 4 = 26
    //
    // Time Complexity:
    //  O(n log n) => 1 + 1 + n log n + 1 ~ n log n
    // ------------------------------------------------------------------------------
    private static double calculaConPotencia1(double [ ] pol, double x, int n) {
        // One single elemental operation: assigning an integer to a variable.
        int i = n;
        // One single elemental operation: assigning a double to a variable.
        double suma = 0.0;
        // The loop is executed `n+1` times, which is a complexity of approximately `n`.
        while (i >= 0) {
            // Accessing a value in the array `pol` has a complexity 1 but calling the
            // function `potencia1` has a complexity of `log(i)`.
            //
            // If `potencia1` is called `n` times then, using the discrete formula
            // given, the complexity has an upper bound of `n log n`.
            suma += pol[n - i] * potencia1(x, i);
            // A single elemental operation: decreasing the value of `i`.
            i--;
        }
        // One single element operation: returning the result of the function.
        return suma;
    } 

    // ------------------------------------------------------------------------------
    // Goal:
    //  Calculates the exponential of a number `x` using a for loop.
    //
    // Input:
    //  Accepts an `x` term and an exponent `i`.
    //
    // Output:
    //  Returns `x` to the power `i`, or `x^i`.
    //
    // Example:
    //  If `x` is 2 and `i` is 3, then, `resultado` is 8:
    //  - when j = 0 => resultado = 1 * 2 = 2
    //  - when j = 1 => resultado = 2 * 2 = 4
    //  - when j = 2 => resultado = 4 * 2 = 8
    //
    // Time Complexity:
    //  O(i) => 1 + i * 1 + 1 ~ i
    // ------------------------------------------------------------------------------
    public static double potencia(double x, int i) {
        // One single elemental operation: assigning a double to a variable.
        double resultado = 1.0;
        // The loop is executed `i` times in the following range: [0, i).
        for (int j=0; j<i; j++) {
            // One single elemental operation: multiplying the total by `x`.
            resultado *= x;
        }
        // One single element operation: returning the result of the function.
        return resultado;
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Calculates the exponential of a number `x` using recursion.
    //
    // Input:
    //  Accepts an `x` term and an exponent `i`.
    //
    // Output:
    //  Returns `x` to the power `i`, or `x^i`.
    //
    // Example:
    //  When `x` is 2 and `i` is 4, then, the result is:
    //  - On the first call, 
    //  - When `i` is 4 => i % 2 = 0,  x * x = 4, i / 2 = 2
    //  - When `i` is 2 => i % 2 = 0,  x * x = 16, i / 2 = 1
    //  - When `i` is 1 => 16
    //
    // Time Complexity:
    //  O(log i) => log(i) // explained below.
    // ------------------------------------------------------------------------------
    public static double potencia1(double x, int i) {
        // 2 elemental operations: A conditional evaluation and a return statement.
        // They are not considered for the worst-case time complexity analysis, if
        // we assume that `i` will be a very large number tending to infinity.
        if(i == 0) return 1;
        // 2 elemental operations: A conditional evaluation and a return statement.
        // They are not considered for the worst-case time complexity analysis, if
        // we assume that `i` will be a very large number tending to infinity.
        if(i == 1) return x;
        // The following statements indicate that when `i` is odd, one of the
        // statements will be executed and when `i` is even, the other statment
        // is chosen.
        //
        // In any case, we can put an upper bound on the time complexity if the
        // most complex scenario is considered.
        //
        // Fortunately, both cases seem to have the same complexity, so the
        // following statements can be considered an unique statement that
        // recursively calls `potencia1` until `i` is 0 or 1 (depending on
        // whether `i` was initially 0 or some other number).
        //
        // On each recursive call, `i` is divided by 2. That means that the
        // progression of `i` is then `i`, `i/2`, `i/4`, `i/8`, `i/16`, etc
        // until the numerator equals the denominator (or `i` is 0).
        //
        // As a consequence, it can be considered that on each step, the
        // the division by 2 and the floor operations are applied.
        //
        // - When `i` is equal to 1, the progression is just [1]. Called 1 time.
        // - When `i` is equal to 2, the progression is [2, 1]. Called 2 times.
        // - When `i` is equal to 3, the progression is [3, 1]. Called 2 times.
        // - When `i` is equal to 4, the progression is [4, 2, 1]. Called 3 times.
        // - When `i` is equal to 8, the progression is [8, 4, 2, 1]. Called 4 times.
        // - When `i` is equal to 10, the progression is [10, 5, 2, 1]. Called 4 times.
        // - When `i` is equal to 20, the progression is [20, 10, 5, 2, 1]. Called 5 times.
        //
        // That progression like a complexity of `log(i)`. It is not linear. The
        // amount of operations does not grow as `i` grows. It is much slower than that.
        if(i % 2 == 0) return potencia1(x * x, i / 2);
        else return potencia1(x * x, i / 2) * x;
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Main program hook responsible for collecting the parameters from STDIN
    //  and calculating the polynomial formula using 3 different functions.
    // ------------------------------------------------------------------------------
    public final static void main(String[] args) {
        try (Scanner reader = new Scanner(System.in)) {
            System.out.println("Introduce el grado del polinomio: ");
            int n = reader.nextInt();
            double[ ] pol= new double[n+1];
            System.out.println("Introduce coeficientes " + "polinomio de mayor a menor grado: ");
            for(int i=0;i<=n;i++) {
                pol[i] = reader.nextDouble();
            }
            System.out.println("Introduce el valor x: ");
            double x = reader.nextDouble();
            double resultado;
            resultado = calculaHorner(pol, x, n);
            System.out.println(String.format("Resultado: %10.2f", resultado));
            resultado = calculaConPotencia(pol, x, n);
            System.out.println(String.format("Resultado: %10.2f", resultado));
            resultado = calculaConPotencia1(pol, x, n);
            System.out.println(String.format("Resultado: %10.2f", resultado));
        } catch(Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
