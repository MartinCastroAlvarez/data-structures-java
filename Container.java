
// -------------------------------------------------------------------
// Purpose:
//  Defines an interface of a Queue or Stack of type `T`.
// -------------------------------------------------------------------
public interface Container<T> {
    T next();
    boolean isEmpty();
    void empty();
    int length();
    String toString();
} 
