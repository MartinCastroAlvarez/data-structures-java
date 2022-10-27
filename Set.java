import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// ------------------------------------------------------------------------------
// Goal:
//  Java class representing a set (in set theory).
//  It is similar to an Array but it only supports distinct values.
// ------------------------------------------------------------------------------
class Set<T> {   

    // ------------------------------------------------------------------------------
    // Goal:
    //  Storing different values using the data structure ArrayList. 
    //  In this list, distinct values will be stored without sorting.
    //
    // Reference:
    //  - https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
    // ------------------------------------------------------------------------------
    private ArrayList<T> data;

    // ------------------------------------------------------------------------------
    // Goal:
    //  Creating an empty ArrayList.
    //
    // Input:
    //  No input is required.
    //
    // Output:
    //  No output is required.
    // ------------------------------------------------------------------------------
    public Set() {
        this.data = new ArrayList<T>();
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Returns the element at position `index` in the ArrayList.
    //  This ensures that the value is encapsulated in this class and there is no
    //  need to access the underliying ArrayList object.
    //
    // Reference:
    //  - https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#get-int-
    //
    // Input:
    //  A positive integer representing a position in the ArrayList.
    //  No checks are performed. If the index is greater than the ArrayList size,
    //  this will fail.
    //
    // Output:
    //  The output depends on the type of variable declared for instances of
    //  this generic Java class.
    // ------------------------------------------------------------------------------
    public T get(int index) {
        return this.data.get(index);
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Method responsible for adding a value to the ArrayList data structure,
    //  as long as the value does not already exist. Since this object is a set
    //  (in set theory), only distinct values are supported.
    //
    // Reference:
    //  - https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#add-E-
    //
    // Input:
    //  An object of the type of values accepted in the set, as declared for
    //  instances of this generic Java class.
    //
    // Output:
    //  No output is required
    // ------------------------------------------------------------------------------
    public void add(T value) {
        if (!this.contains(value)) {
            this.data.add(value);
        }
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Encapsulates the size of the ArrayList to represent the size of the set.
    //
    // Reference:
    //  - https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html
    //
    // Input:
    //  No input is required
    //
    // Output:
    //  Returns the size of the ArrayLits. The reuslt is a positive integer or 0.
    // ------------------------------------------------------------------------------
    public int size() {
        return this.data.size();
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Removes an object from the the ArrayList as long as the object is there.
    //  If the object is not there, this function fails silently. There is no way to know.
    //
    // Reference:
    //  - https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#indexOf-java.lang.Object-
    //  - https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#remove-int-
    //
    // Input:
    //  A value of the type that was declared for instances of this generic Java class.
    //
    // Output:
    //  No output is required
    // ------------------------------------------------------------------------------
    public void remove(T value) {
        int i = this.data.indexOf(value);
        if (i != -1) {
            this.data.remove(i);
        }
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Checks whether an element exists in the ArrayList data structure.
    //  Returns True if the element is there. False otherwise.
    //
    // Reference:
    //  - https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#contains-java.lang.Object-
    //
    // Input:
    //  Accepts a value used for checking if it is stored in the ArrayList or not.
    //
    // Output:
    //  Returns either true or false.
    // ------------------------------------------------------------------------------
    public boolean contains(T value) {
        if (this.data.contains(value)) {
            return true;
        }
        return false;
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Implements the ArrayList getter software pattern.
    //
    // References:
    //  - https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html#toArray--
    //
    // Input:
    //  No input is required
    //
    // Output:
    //  Transforms the Set instance into an ArrayList instance.
    // ------------------------------------------------------------------------------
    public ArrayList<T> toArray() {
        return this.data;
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Representing an instance as a String.
    //
    // Input:
    //  No input is required
    //
    // Output:
    //  Returns a string representation of the ArrayList.
    // ------------------------------------------------------------------------------
    public String toString() {
        return this.toArray().toString();
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Calculates the union of 2 sets of any given type.
    //
    // Input:
    //  Accepts 2 instances of the Set class.
    //  It is not checked whether the Sets contain the same type of data.
    //
    // Output:
    //  Returns another Set, which is the union of the 2 Sets passed as arguments.
    // ------------------------------------------------------------------------------
    public static Set union(Set a, Set b) {
        Set x = new Set();
        for (int i = 0; i < a.size(); i++) {
            x.add(a.get(i));
        }
        for (int i = 0; i < b.size(); i++) {
            x.add(b.get(i));
        }
        return x;
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Calculates the difference of 2 sets of any given type.
    //
    // Input:
    //  Accepts 2 instances of the Set class.
    //  It is not checked whether the Sets contain the same type of data.
    //
    // Output:
    //  Returns another Set, which is the diff of the 2 Sets passed as arguments.
    // ------------------------------------------------------------------------------
    public static Set difference(Set a, Set b) {
        Set x = new Set();
        for (int i = 0; i < a.size(); i++) {
            if (!b.contains(a.get(i))) {
                x.add(a.get(i));
            }
        }
        for (int i = 0; i < b.size(); i++) {
            if (!a.contains(b.get(i))) {
                x.add(b.get(i));
            }
        }
        return x;
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Calculates the intersection of 2 sets of any given type.
    //
    // Input:
    //  Accepts 2 instances of the Set class.
    //  It is not checked whether the Sets contain the same type of data.
    //
    // Output:
    //  Returns another Set, which is the intersetion of the 2 Sets passed as arguments.
    // ------------------------------------------------------------------------------
    public static Set intersection(Set a, Set b) {
        Set x = new Set();
        for (int i = 0; i < a.size(); i++) {
            if (b.contains(a.get(i))) {
                x.add(a.get(i));
            }
        }
        return x;
    }

    // ------------------------------------------------------------------------------
    // Goal:
    //  Main method.
    //  Allows the User to introduce 2 arrays of strings from the console
    //  and prints the union, intersection and difference.
    // ------------------------------------------------------------------------------
	public static void main( String [ ] args ) {   
        // Declaring variables.
        Scanner scanner;
        int number;
        Set<Integer> a;
        Set<Integer> b;

        // Reading integers from STDIN until the User introudces
        // an invalid value that can not be casted to integer.
        a = new Set<Integer>();
        scanner = new Scanner(System.in);
        System.out.println("Creating Set A: ");
        try {
            while (true) {
                System.out.println("Insert a number or 'exit' to continue: ");
                System.out.print(">>> ");
                number = scanner.nextInt();
                System.out.println("Added: " + number);
                a.add(number);
            }
        } catch (java.util.InputMismatchException error) {}

        // Doing the same but for B now.
        b = new Set<Integer>();
        scanner = new Scanner(System.in);
        System.out.println("Creating Set B: ");
        try {
            while (true) {
                System.out.println("Insert a number or 'exit' to continue: ");
                System.out.print(">>> ");
                number = scanner.nextInt();
                System.out.println("Added: " + number);
                b.add(number);
            }
        } catch (java.util.InputMismatchException error) {}

        // Printing the results to STDOUT.
        System.out.println("Set A: " + a);
        System.out.println("Set B: " + b);
        System.out.println("Union: " + Set.union(a, b));
        System.out.println("Difference: " + Set.difference(a, b));
        System.out.println("Intersection: " + Set.intersection(a, b));
	}
}
