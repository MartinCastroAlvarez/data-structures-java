import java.util.Scanner;

// -------------------------------------------------------------------
// Purpose:
//  Implementation of a generic LinkedList data structure.
//  The LinkedList defines an internal private class of type Node
//  which represents the nodes in the LinkedList.
//
// Generic Data:
//  Both the LinkedList and the Node type are generic and accept an
//  instance of any given class, as defined when declaring the list.
// -------------------------------------------------------------------
public class LinkedList<T> {

    // -------------------------------------------------------------------
    // Purpose:
    //  Defining reference to a single Node is sufficient in a LinkedList.
    //
    // Visibility:
    //  Private. Only the class can get and set the first node of the list.
    // -------------------------------------------------------------------
    private Node<T> firstNode = null;

    // -------------------------------------------------------------------
    // Purpose:
    //  Defining an integer counter with the size of the LinkedList.
    //
    // Visibility:
    //  Private. Only the class can get and set the length of the list.
    // -------------------------------------------------------------------
    private int length = 0;

    // -------------------------------------------------------------------
    // Purpose:
    //  Internal generic class defining a generic node in the LinkedList.
    //  The node accepts any type of data.
    //
    // Visibility:
    //  Private. Only the LinkedList class can create Nodes.
    //
    // Generic Data:
    //  Both the LinkedList and the Node type are generic and accept an
    //  instance of any given class, as defined when declaring the list.
    // -------------------------------------------------------------------
    private class Node<K> {

        // -------------------------------------------------------------------
        // Purpose:
        //  Defining a reference to the data of a generic type `K`.
        //
        // Visibility:
        //  Private. Only the Node class can read and modify the node data.
        //  The Node class implements a setter design pattern.
        //  Private attributes are available to the LinkedList class but
        //  it is not a good practice to access them directly.
        // -------------------------------------------------------------------
        private K data;

        // -------------------------------------------------------------------
        // Purpose:
        //  Defining a reference to the next Node in the LinkedList.
        //
        // Visibility:
        //  Private. Only the Node class can read and modify the next node.
        //  The Node class implements a setter design pattern.
        //  Private attributes are available to the LinkedList class but
        //  it is not a good practice to access them directly.
        // -------------------------------------------------------------------
        private Node<K> next;

        // -------------------------------------------------------------------
        // Purpose:
        //  Constructor of the generic Node of the LinkedList.
        //
        // Input:
        //  It requires an instance of type `K` and a reference to the
        //  next Node.
        //
        // Output:
        //  Constructors must produce no output.
        // -------------------------------------------------------------------
        public Node(K o, Node<K> n) {
            set(o);
            link(n);
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Evaluates if this Node is the last element of the LinkedList.
        //
        // Visibility:
        //  Public. Any class can evaluate if this is the last Node.
        //
        // Input:
        //  No input required.
        //
        // Output:
        //  True if the Node has no link. False otherwise.
        // -------------------------------------------------------------------
        public boolean isLast() {
            if (next == null) {
                return true;
            }
            return false;
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Implements the setter method of the encapsulated data object
        //  of type `K`.
        //
        // Visibility:
        //  Public method implementing the setter design pattern.
        //
        // Input:
        //  An instance of type `K`.
        //
        // Output:
        //  No output.
        // -------------------------------------------------------------------
        public void set(K data) {
            this.data = data;
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Updates the reference to the next node in the LinkedList.
        //  of type `K`.
        //
        // Visibility:
        //  Public method implementing the setter design pattern.
        //
        // Input:
        //  An instance to a Node with of same generic class `K`.
        //
        // Output:
        //  No output.
        //
        // Complexity:
        //  O(1): Updates an attribute in memory.
        // -------------------------------------------------------------------
        public void link(Node<K> next) {
            this.next = next;
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Method to get the data of type `K` encapsulated in this Node.
        //
        // Visibility:
        //  Public method implementing the getter design pattern.
        //
        // Input:
        //  No input is required.
        //
        // Output:
        //  An instance of the generic class `K`.
        // -------------------------------------------------------------------
        public K get() {
            return data;
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Method to get a reference to the next Node in the LinkedList.
        //
        // Visibility:
        //  Public method implementing the getter design pattern.
        //
        // Input:
        //  No input is required.
        //
        // Output:
        //  An instance of a Node of the generic class `K`.
        //
        // Complexity:
        //  O(1): Reads an in-memory attribute.
        // -------------------------------------------------------------------
        public Node<K> follow() {
            return next;
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Casting Node to String.
        //
        // Visibility:
        //  Public. Any class can transform this Node into a string.
        //
        // Input:
        //  No input is required.
        //
        // Output:
        //  A string!
        // -------------------------------------------------------------------
        public String toString() {
            if (isLast()) {
                return "|" + get() + "|";
            }
            return "|" + get() + "|->";
        }

    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Constructing an empty LinkedList.
    //  The first Node is not defined and the length is 0, by default.
    //
    // Input:
    //  No input is required to create an empty Linked List.
    //
    // Output:
    //  Constructors must produce no output.
    // -------------------------------------------------------------------
    public LinkedList() {
        firstNode = null;
        length = 0;
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Returns the lenght of the LinkedList.
    //
    // Visibility:
    //  The getter function can be called by any class. It is public.
    //
    // Input:
    //  No input is required.
    //
    // Outpu:
    //  A positive integer (or zero) which is the size of the LinkedList.
    //
    // Complexity:
    //  O(1): Only java native operations.
    // -------------------------------------------------------------------
    public int length() {
        return length;
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Method to insert a Node to beginning of the LinkedList.
    //
    // Visibility:
    //  Public. Any class can add Nodes.
    //
    // Input:
    //  It requires an instance of the generic type `T`.
    //  For example, if the LinkedList contains Integers, then the
    //  input must be an integer.
    //
    // Output:
    //  No output is produced.
    //
    // Complexity:
    //  O(1): Only java native operations.
    // -------------------------------------------------------------------
    public void add(T data) {
        Node<T> node = new Node<T>(data, null);
        node.link(firstNode);
        firstNode = node;
        length++;
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Evaluates if the LinkedList is empty by checking whether the first
    //  Node in the LinkedList does not exist.
    //
    // Visibility:
    //  Any class cna check if this list is empty.
    //
    // Input:
    //  No input is required.
    //
    // Output:
    //  True if the list is empty. False otherwise.
    //
    // Complexity:
    //  O(1): Only java native operations.
    // -------------------------------------------------------------------
    public boolean isEmpty() {
        if (firstNode == null) {
          return true;
        }
        return false;
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Eliminates the Node at a given position in the list and decreases
    //  the LinkedList size.
    //
    // Visibility:
    //  Any class can remove Nodes from the LinkedList.
    //
    // Input:
    //  An integer `i` with the position to be removed.
    //
    // Output:
    //  True if the element was removed. False otherwise
    //  For example, if the position is larger than the length of the
    //  list, this function does not fail but does not return True either.
    //
    // Complexity:
    //  O(N)
    // -------------------------------------------------------------------
    public boolean remove(int  i) {
        if (i < 0 || i >= length) {
            return false;
        } else if (i == 0) {
            // Removing the first element has constant complexity.
            firstNode = firstNode.follow();
            length--;
            return true;
        } else {
            // Just a Java native operation.
            Node<T> node = firstNode;
            // Worst case-scenario starts here.
            // Removing the last element of the LinkedList takes N
            // operations.
            for (int j = 0; j < i - 1; j++) {
                // This is just another Java operation.
                node = node.follow();
            }
            // More java constant operations.
            node.link(node.follow().follow());
            length--;
            return true;
        }
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Inverting the LinkedList in O(N).
    //
    // Visbility:
    //  Any class can invert the LinkedList.
    //
    // Input:
    //  No input is required.
    //
    // Output:
    //  No output is required. The inversion is done "in place".
    //
    // Complexity:
    //  O(N) = O(1 + 1 + 1 + 1 + N x (1 + 1 + 1 + 1 + 1)
    // -------------------------------------------------------------------
    public void invert() {
        // One constant Java operation. O(1).
        Node<T> previous, next;
        // One constant Java operation. O(1).
        // Worst case scenario: evaluates to True.
        if (!isEmpty()) {
            // One constant Java operation. (1).
            previous = null;
            // One constant Java operation of complexity O(1).
            next = firstNode.follow();
            // Assuming N is the length of the LinkedList, in the worst-case
            // scenario, this evaluates to True N-1 times. It's O(N).
            while (next != null) {
                // One constant Java operation of complexity O(1).
                next = firstNode.follow();
                // One constant Java operation of complexity O(1).
                firstNode.link(previous);
                // One constant Java operation.
                previous = firstNode;
                // One constant Java operation. O(1).
                // In the worst-case scenario evaluates to True.
                if (next != null) {
                    // One constant Java operation.
                    firstNode = next;
                }
            }
        }
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Fetches the Node at a given position.
    //
    // Visibility:
    //  Any class can call this function.
    //
    // Input:
    //  A positive integer representing the position to retrieve.
    //
    // Output:
    //  An instance of the `T` class contained in the Node at position
    //  `i` or null if the Node does not exist..
    // -------------------------------------------------------------------
    public T get(int i) {
        if (i < 0 || i > length - 1) {
            return null;
        }
        Node<T> node = firstNode;
        for (int j = 0; j < i; j++) {
            node = node.follow();
        }
        return node.get();
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Transforms the LinkedList into a String.
    //
    // Input:
    //  No input is required.
    //
    // Output:
    //  A string representation of the LinkedList.
    //
    // Visibility:
    //  This method is public.
    //
    // Complexity:
    //  O(N): Iterating over each value in the list of N elements.
    // -------------------------------------------------------------------
    public String toString() {
        String output = "";
        Node<T> node = firstNode;
        while (node != null) {
            output += node;
            node = node.follow();
        }
        return output;
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Main method of the Java Class.
    //  This method retrieves a list of values from STDIN, prints the
    //  initial content of the LinkedList to STDOUT, then inverts the
    //  List and prints the results again to STDOUT.
    //  The elements of the LinkedList are declared of type String.
    // -------------------------------------------------------------------
    public static void main(String args[]) {

        // Declaring variables.
        Scanner scanner;
        LinkedList<String> list;
        String[] values;

        // Initializing variables.
        scanner = new Scanner(System.in);
        list = new LinkedList<String>();

        // Just a test here:
        /*
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.remove(2);
        */

        // Collecting list data from STDIN.
        System.out.println("Insert a comma separated list of values:");
        System.out.print(">>> ");
        values = scanner.next().split(",");

        // Adding elements to the LinkedList.
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        // Printing LinkedList before inverting it.
        System.out.println("LinkedList:");
        System.out.println(list);

        // Inverting the LinkedList.
        list.invert();

        // Printing LinkedList after inverting it.
        System.out.println("Inverted LinkedList:");
        System.out.println(list);

    }
}
