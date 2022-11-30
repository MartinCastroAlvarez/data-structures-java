
// -------------------------------------------------------------------
// Purpose:
//  Defines an interface of a generic Stack of type `T`.
// -------------------------------------------------------------------
public interface Stack<T> extends Container<T> {
    void push(T x);
    void pop();
} 
