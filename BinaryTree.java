import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// ------------------------------------------------------------------------------
// A Binary Tree data structure containing just a root integer, a left
// and a right leaf branches and a counter of the amount of times the
// root integer has been added to the Tree.
// The left and the right branches are implemented using recursion.
// ------------------------------------------------------------------------------
class BinaryTree {

    private int weight = 0;
    private int root = 0;
    private BinaryTree left;
    private BinaryTree right;

    // ------------------------------------------------------------------------------
    // Returns True if the BinaryTree is empty.
    //
    // That happens when the weight of the BinaryTree is 0, since the weight is
    // incremented every time the root value is added to the list.
    // ------------------------------------------------------------------------------
    public boolean isEmpty() {
        if (this.weight == 0) {
            return true;
        }
        return false;
    }

    // ------------------------------------------------------------------------------
    // Returns True if this Node has a left node.
    // ------------------------------------------------------------------------------
    public boolean hasLeft() {
        if (this.left != null) {
            return true;
        }
        return false;
    }

    // ------------------------------------------------------------------------------
    // Returns True if this Node has a right node.
    // ------------------------------------------------------------------------------
    public boolean hasRight() {
        if (this.right != null) {
            return true;
        }
        return false;
    }

    // ------------------------------------------------------------------------------
    // Method for adding a value to the BinaryTree.
    //
    // If the root value is currently null, then the root
    // value will be updated.
    //
    // If the new value is less than than the root value,
    // then a left BinaryTree is updated/created.
    //
    // If the new value is larger than than the root value,
    // then a right BinaryTree is updated/created.
    // ------------------------------------------------------------------------------
    public void add(int number) {
        if (this.isEmpty()) {
            this.root = number;
            this.weight++;
        } else if (number < this.root) {
            if (!this.hasLeft()) {
                this.left = new BinaryTree();
            }
            this.left.add(number);
        } else {
            if (!this.hasRight()) {
                this.right = new BinaryTree();
            }
            this.right.add(number);
        }
    }

    // ------------------------------------------------------------------------------
    // Method responsible for iterating over the sorted values in the BinaryTree.
    // ------------------------------------------------------------------------------
    public ArrayList<Integer> toList() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        if (this.hasLeft()) {
            numbers.addAll(this.left.toList());
        }
        for (int i = 0; i < this.weight; i++) {
            numbers.add(this.root);
        }
        if (this.hasRight()) {
            numbers.addAll(this.right.toList());
        }
        return numbers;
    }

    // ------------------------------------------------------------------------------
    // Main method.
    //
    // This just accepts integers from the STDIN and adds them to the BinaryTree
    // instance.
    //
    // Once the loop is broken, the BinaryTree is printed to STDOUT.
    // The output is a sorted list of integers in ascending mode.
    // ------------------------------------------------------------------------------
	public static void main(String [] args) {

        // Declaring variables.
		Scanner scanner;
        BinaryTree tree;
        int number;

        // Initializing variables.
		scanner = new Scanner(System.in);
        tree = new BinaryTree();

        // Reading integers from STDIN until the User introudces
        // an invalid value that can not be casted to integer.
        try {
            while (true) {
		        System.out.println("Insert a number or 'exit' to quit: ");
		        System.out.print(">>> ");
		        number = scanner.nextInt();
		        System.out.println("Added: " + number);
                tree.add(number);
            }
        } catch (java.util.InputMismatchException error) {}

        // Printing the results to STDOUT.
		System.out.println("Sorted values:");
        ArrayList<Integer> numbers = tree.toList();
        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");  
        }
	}
}
