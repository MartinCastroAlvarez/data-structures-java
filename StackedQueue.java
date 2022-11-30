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
    //  Defining 2 private stacks used to implement the Queue
    //  data structure.
    //
    // Visibility:
    //  Only the StackedQueue can access the state of the stacks.
    // -------------------------------------------------------------------
    private InternalStack<T> stack1;
    private InternalStack<T> stack2;

    // -------------------------------------------------------------------
    // Purpose:
    //  The constructor responsible for initializing an empty Queue.
    // -------------------------------------------------------------------
    public void StackedQueue() {
        empty();
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
        // Removing the next element in the Queue and adding
        // it to the next element to the second Stack.
        while (!stack1.isEmpty()) {
            stack2.push(stack1.next());
            stack1.pop();
        }
        // Now that it is empty, adding an element to the first stack
        stack1.push(x);
        // Now putting the elements of the second stack back into
        // the first stack.
        while (!stack2.isEmpty()) {
            stack1.push(stack2.next());
            stack2.pop();
        }
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Removes an instance of type `T` from the end of the Queue.
    //  The first Stack is always arranged in a way that the first
    //  element is the next element of the Queue.
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
    //  O(1): The complexity of removing the first value of the LinkedList
    //        in the InternalStack class is 1.
    // -------------------------------------------------------------------
    public void unshift() {
        stack1.pop();
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Returns a reference to the next value in the Queue.
    //  The first Stack is always arranged in a way that the first
    //  element is the next element of the Queue.
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
    //  O(1): The complexity of reading the first value of the LinkedList
    //        in the InternalStack class is 1.
    // -------------------------------------------------------------------
    public T next() {
        return stack1.next();
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
    //  O(1): All simple Java operations.
    // -------------------------------------------------------------------
    public boolean isEmpty() {
        if (length() == 0) {
            return true;
        }
        return false;
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
    //  O(1): Just 2 simple constant Java operations.
    // -------------------------------------------------------------------
    public void empty() {
        stack1 = new InternalStack<T>();
        stack2 = new InternalStack<T>();
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
    //  O(1): The size of the first Stack is stored in memory.
    // -------------------------------------------------------------------
    public int length() {
        return stack1.length();
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
        // Removing the next element in the Queue and adding
        // it to the next element to the second Stack.
        while (!stack1.isEmpty()) {
            stack2.push(stack1.next());
            stack1.pop();
        }
        // Creating a String to append to.
        String output = "";
        T value;
        // Now putting the elements of the second stack back into
        // the first stack.
        while (!stack2.isEmpty()) {
            value = stack2.next();
            output += value + ", ";
            stack1.push(value);
            stack2.pop();
        }
        // Returning the String representation of the Stack.
        return output;
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
        //  Reusing the LinkedList class as an internal representation of
        //  the Stack.
        //
        // Visibility:
        //  Private. Only the InternalStack can modify the state of the list.
        // -------------------------------------------------------------------
        private LinkedList<K> list;

        // -------------------------------------------------------------------
        // Purpose:
        //  The constructor responsible for initializing an empty Stack.
        // -------------------------------------------------------------------
        public void InternalStack() {
            empty();
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
        //  This method is public. The StackedQueue class can call it.
        //
        // Complexity:
        //  O(1): Adding an element to LinkedList is pretty straight-forward.
        //        Only simple Java operations are required.
        // -------------------------------------------------------------------
        public void push(K x) {
            list.add(x);
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
        //  This method is public. The StackedQueue class can call it.
        //
        // Complexity:
        //  O(1) when removing the first element of a LinkedList.
        // -------------------------------------------------------------------
        public void pop() {
            list.remove(0);
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
        //  This method is public. The StackedQueue class can call it.
        //
        // Complexity:
        //  O(1): The first element of the list is always available as
        //        a reference in memory.
        // -------------------------------------------------------------------
        public K next() {
            list.get(0);
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
        //  This method is public. The StackedQueue class can call it.
        //
        // Complexity:
        //  O(1): Only Java native operations.
        // -------------------------------------------------------------------
        public boolean isEmpty() {
            if (list.length() == 0) {
                return true;
            }
            return false;
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
        //  This method is public. The StackedQueue class can call it.
        //
        // Complexity:
        //  O(1): Only Java native operations.
        // -------------------------------------------------------------------
        public void empty() {
            list = new LinkedList<K>();
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
        //  This method is public. The StackedQueue class can call it.
        //
        // Complexity:
        //  O(1): The lenght of the LinkedList is stored in memory in the
        //        LinkedList Class. No need to iterate or recurse.
        // -------------------------------------------------------------------
        public int length() {
            return list.length();
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
        //  O(N): Given a list of N elements, it takes N operations to read
        //        every element on that list.
        // -------------------------------------------------------------------
        public String toString() {
            return list.toString();
        }

    }

}
