
// -------------------------------------------------------------------
// Purpose:
//  Defines an interface of a generic Queue of type `T`.
// -------------------------------------------------------------------
public interface Queue<T> extends Container<T> {
    void shift(T x);
    void unshift();
}
