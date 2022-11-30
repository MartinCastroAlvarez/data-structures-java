import java.util.Scanner;

// -------------------------------------------------------------------
// Purpose:
//  Implements a Queue data structure using 2 stacks.
//
// Visibility:
//  This class is public. Any class can instantiate it.
// -------------------------------------------------------------------
public class StackedQueue<T> implements Queue<T> {

    // -------------------------------------------------------------------
    // Purpose:
    //  The constructor responsible for initializing an empty Queue.
    // -------------------------------------------------------------------
    public void StackedQueue() {
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Puts an instance of type `T` into the beginning the Queue.
    //
    // Input:
    //  An instance of type `T` to be added to the Stack.
    //
    // Output:
    //  No output is produced.
    //
    // Visibility:
    //  This method is public. Any class can call it.
    //
    // Complexity:
    //  TODO
    // -------------------------------------------------------------------
    public void shift(T x) {
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Removes an instance of type `T` from the end of the Queue.
    //
    // Input:
    //  No input is required.
    //
    // Output:
    //  No output is produced.
    //
    // Visibility:
    //  This method is public. Any class can call it.
    //
    // Complexity:
    //  TODO
    // -------------------------------------------------------------------
    public void unshift() {
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Returns a reference to the next value in the Queue.
    //
    // Input:
    //  No input is required.
    //
    // Output:
    //  An instance of type `T` at the first position of the Queue.
    //
    // Visibility:
    //  This method is public. Any class can call it.
    //
    // Complexity:
    //  TODO
    // -------------------------------------------------------------------
    public T next() {
    }

    // -------------------------------------------------------------------
    // Purpoe:
    //  Returns True if the Queue is empty.
    //
    // Input:
    //  No input is required.
    //
    // Output:
    //  True if the Queue is empty. False otherwise,
    //
    // Visibility:
    //  This method is public. Any class can call it.
    //
    // Complexity:
    //  TODO
    // -------------------------------------------------------------------
    public boolean isEmpty() {
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Removes all elements from the Queue.
    //
    // Input:
    //  No input is required.
    //
    // Output:
    //  No output is produced.
    //
    // Output:
    //  No output is produced.
    //
    // Visibility:
    //  This method is public. Any class can call it.
    //
    // Complexity:
    //  TODO
    // -------------------------------------------------------------------
    public void empty() {
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Returns the size of the Queue.
    //
    // Input:
    //  No input is required.
    //
    // Output:
    //  An integer representing the length of the Stack.
    //
    // Visibility:
    //  This method is public. Any class can call it.
    //
    // Complexity:
    //  TODO
    // -------------------------------------------------------------------
    public int length() {
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Transforms the Queue into a String.
    //
    // Input:
    //  No input is required.
    //
    // Output:
    //  A string representation of the Stack.
    //
    // Visibility:
    //  This method is public. Any class can call it.
    //
    // Complexity:
    //  TODO
    // -------------------------------------------------------------------
    public String toString() {
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Implements a Stack data structure.
    //
    // Visibility:
    //  Only the StackedQueue class can use the Stack.
    // -------------------------------------------------------------------
    class InternalStack<K> implements Stack<K> {

        // -------------------------------------------------------------------
        // Purpose:
        //  The constructor responsible for initializing an empty Stack.
        // -------------------------------------------------------------------
        public void InternalStack() {
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Puts an instance of type `K` into the beginning the Stack.
        //
        // Input:
        //  An instance of type `K` to be added to the Stack.
        //
        // Output:
        //  No output is produced.
        //
        // Visibility:
        //  This method is public. The LinkedList class can call it.
        //
        // Complexity:
        //  TODO
        // -------------------------------------------------------------------
        public void push(K x) {
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Removes an instance of type `K` from the end of the Stack.
        //
        // Input:
        //  No input is required.
        //
        // Output:
        //  No output is produced.
        //
        // Visibility:
        //  This method is public. The LinkedList class can call it.
        //
        // Complexity:
        //  TODO
        // -------------------------------------------------------------------
        public void pop() {
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Returns a reference to the next value in the Stack.
        //
        // Input:
        //  No input is required.
        //
        // Output:
        //  An instance of type `K` at the first position of the Stack.
        //
        // Visibility:
        //  This method is public. The LinkedList class can call it.
        //
        // Complexity:
        //  TODO
        // -------------------------------------------------------------------
        public K next() {
        }

        // -------------------------------------------------------------------
        // Purpoe:
        //  Returns True if the Stack is empty.
        //
        // Input:
        //  No input is required.
        //
        // Output:
        //  True if the Stack is empty. False otherwise,
        //
        // Visibility:
        //  This method is public. The LinkedList class can call it.
        //
        // Complexity:
        //  TODO
        // -------------------------------------------------------------------
        public boolean isEmpty() {
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Removes all elements from the Stack.
        //
        // Input:
        //  No input is required.
        //
        // Output:
        //  No output is produced.
        //
        // Output:
        //  No output is produced.
        //
        // Visibility:
        //  This method is public. The LinkedList class can call it.
        //
        // Complexity:
        //  TODO
        // -------------------------------------------------------------------
        public void empty() {
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Returns the size of the Stack..
        //
        // Input:
        //  No input is required.
        //
        // Output:
        //  An integer representing the length of the Stack.
        //
        // Visibility:
        //  This method is public. The LinkedList class can call it.
        //
        // Complexity:
        //  TODO
        // -------------------------------------------------------------------
        public int length() {
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Transforms the Stack into a String.
        //
        // Input:
        //  No input is required.
        //
        // Output:
        //  A string representation of the Stack.
        //
        // Visibility:
        //  This method is public. The LinkedList class can call it.
        //
        // Complexity:
        //  TODO
        // -------------------------------------------------------------------
        public String toString() {
        }

    }

}
