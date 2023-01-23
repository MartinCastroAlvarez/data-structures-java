import java.util.ArrayList;
import java.util.InputMismatchException;

// -------------------------------------------------------------------
// Purpose:
//  Implements a HashMap data structure using LinkedLists.
//
// Visibility:
//  This class is public. Any class can instantiate it.
// -------------------------------------------------------------------
public class HashTable<T> {

    // -------------------------------------------------------------------
    // Purpose:
    //  Defining a list of values to hash;
    //
    // Visibility:
    //  Private. Only the HashMap can modify the state of the list.
    // -------------------------------------------------------------------
    private ArrayList<HashEntry<T>> list;

    // -------------------------------------------------------------------
    // Purpose:
    //  Storing the size of the hash table in memory.
    // -------------------------------------------------------------------
    Integer size = 10;

    // -------------------------------------------------------------------
    // Purpose:
    //  The constructor responsible for initializing an empty HashMap.
    // -------------------------------------------------------------------
    public HashTable() {
        initialize();
    }
    public HashTable(Integer size) {
        this.size = size;
        initialize();
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Initializing the Array with empty data.
    //
    // Visibility:
    //  This method is intended to be only executable by the constructor.
    // -------------------------------------------------------------------
    private void initialize() {
        list = new ArrayList<HashEntry<T>>(size);
        for (int i = 0; i < size; i++) {
            list.add(i, null);
        }
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Adding a new entry to the hash table.
    //
    // Visibility:
    //  This method is public. Any class can call it.
    // -------------------------------------------------------------------
    public void add(T value) {
        HashEntry entry = new HashEntry(value);
        Integer code = ((Hashable)value).getHash();
        Integer position = code % size;
        if (list.get(position) == null || list.get(position).equals(value)) {
            list.set(position, entry);
            return;
        }
        for (int i = 1; i < size; i++) {
            code += (2 * i - 1);
            position = code % size;
            if (list.get(position) == null || list.get(position).equals(value)) {
                list.set(position, entry);
                return;
            }
        }
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Transforms the HashMap into a String.
    //
    // Input:
    //  No input is required.
    //
    // Output:
    //  A string representation of the Stack.
    //
    // Visibility:
    //  This method is public. Any class can call it.
    // -------------------------------------------------------------------
    public String toString() {
        String output = "";
        for (int i = 0; i < size; i++) {
            if (list.get(i) == null) {
                output += i + " -> \n";
            } else {
                output += i + " -> " +  list.get(i).toString() + "\n";
            }
        }
        return output;
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Main method of the Java Class.
    //  This method retrieves a list of values from STDIN, prints the
    //  contents of the HashMap to STDOUT.
    // -------------------------------------------------------------------
    public static void main(String args[]) {

        // Declaring variables.
        String[] values;
        HashTable<Person> map;

        // Initializing variables.
        map = new HashTable<Person>(10);

        // Just a test here:
        map.add(new Person("96-14145", "Steven", "Andrea", 4.5));
        map.add(new Person("96-12087", "Alberto", "Mendoza", 4.5));
        map.add(new Person("96-14477", "Oscar", "Meza", 3.0));
        map.add(new Person("96-13955", "Maria", "Ortega", 5.0));
        map.add(new Person("96-11797", "Emely", "Arraiz", 5.0));
        map.add(new Person("96-14878", "Maria", "Fuenmayor", 5.0));
        map.add(new Person("96-14556", "Delia", "Gutiérrez", 5.0));
        map.add(new Person("96-14551", "Martha", "Arteaga", 4.5));
        map.add(new Person("96-12965", "Lázaro", "Rech", 4.5));
        map.add(new Person("96-11052", "Wilmer", "Pereira", 4.5));

        // Printing LinkedList before inverting it.
        System.out.println("HashMap:");
        System.out.println(map);

    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Implements the internal HashEntry data structure.
    //
    // Visibility:
    //  Only the HashMap class can use the Stack.
    // -------------------------------------------------------------------
    class HashEntry<K> {

        // -------------------------------------------------------------------
        // Purpose:
        //  Defining the value in the Hash Entry.
        // -------------------------------------------------------------------
        private K value;

        // -------------------------------------------------------------------
        // Purpose:
        //  Defining the constructor fo the HashEntry.
        // -------------------------------------------------------------------
        public HashEntry(K value) {
            this.value = value;
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Implementing the getter of the entry value.
        //
        // Visibility:
        //  Public. Any class with a reference to a HashEntry instance has
        //  access to these methods.
        // -------------------------------------------------------------------
        public K getValue() { return value; }

        // -------------------------------------------------------------------
        // Purpose:
        //  Casting the HashEntry to String.
        //
        // Visibility:
        //  Public. Any class with a reference to a HashEntry instance has
        //  access to these methods.
        // -------------------------------------------------------------------
        public String toString() {
            return this.getValue().toString();
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Implementing the methods required to evaluate the Hash of a
        //  HashEntry instance.
        //
        // Visibility:
        //  Public. Any class with a reference to a HashEntry instance has
        //  access to these methods.
        // -------------------------------------------------------------------
        public Integer getHash() {
            return ((Hashable)this.getValue()).getHash();
        }

        // -------------------------------------------------------------------
        // Purpose:
        //  Implementing the methods required to evaluate if the object
        //  is equal to another object.
        //
        // Visibility:
        //  Public. Any class with a reference to a HashEntry instance has
        //  access to these methods.
        // -------------------------------------------------------------------
        public boolean equals(Object obj) {
            return ((Hashable)this.getValue()).equals(obj);
        }
    }
}

// -------------------------------------------------------------------
// Purpose:
//  Implements the Person class used in the main example.
// -------------------------------------------------------------------
class Person implements Hashable {

    // -------------------------------------------------------------------
    // Purpose:
    //  Defining the record identifier, used to calculate the hash.
    // -------------------------------------------------------------------
    private String id;

    // -------------------------------------------------------------------
    // Purpose:
    //  Defining the record name.
    // -------------------------------------------------------------------
    private String firstName;
    private String lastName;

    // -------------------------------------------------------------------
    // Purpose:
    //  Defining the record score.
    // -------------------------------------------------------------------
    private double score;

    // -------------------------------------------------------------------
    // Purpose:
    //  Implementing the constructor of the Person.
    //
    // Visibility:
    //  Public. Any class with a reference to a Personinstance has
    //  access to these methods.
    // -------------------------------------------------------------------
    public Person(String id) {
        this.id = id;
    }
    public Person(String id, String firstName, String lastName, double score) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setScore(score);
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Implementing the getter and setter methods for the record id.
    //
    // Visibility:
    //  Public. Any class with a reference to a Person instance has
    //  access to these methods.
    // -------------------------------------------------------------------
    public String getId() { return id; }

    // -------------------------------------------------------------------
    // Purpose:
    //  Implementing the getter and setter methods for the record name.
    //
    // Visibility:
    //  Public. Any class with a reference to a Person instance has
    //  access to these methods.
    // -------------------------------------------------------------------
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    // -------------------------------------------------------------------
    // Purpose:
    //  Implementing the getter and setter methods for the record score.
    //
    // Visibility:
    //  Public. Any class with a reference to a Person instance has
    //  access to these methods.
    // -------------------------------------------------------------------
    public void setScore(double score) { this.score = score; }
    public double getScore() { return score; }

    // -------------------------------------------------------------------
    // Purpose:
    //  Casting the Person to String.
    //
    // Visibility:
    //  Public. Any class with a reference to a Person instance has
    //  access to these methods.
    // -------------------------------------------------------------------
    public String toString() {
        String output = "";
        output += this.getId();
        output += " ";
        output += this.getFirstName();
        output += " ";
        output += this.getLastName();
        output += " ";
        output += this.getScore();
        return output;
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Implementing the methods required to evaluate the Hash of a
    //  Person instance.
    //
    // Visibility:
    //  Public. Any class with a reference to a Person instance has
    //  access to these methods.
    // -------------------------------------------------------------------
    public Integer getHash() {
        return Integer.parseInt(this.getId().substring(3));
    }

    // -------------------------------------------------------------------
    // Purpose:
    //  Implementing the methods required to evaluate if the object
    //  is equal to another object.
    //
    // Visibility:
    //  Public. Any class with a reference to a Person instance has
    //  access to these methods.
    // -------------------------------------------------------------------
    public boolean equals(Object obj) {

        // Checking if the other object is null.
        if (obj == null) {
            return false;
        }
      
        // Checking if both the object references are 
        // referring to the same object.
        if(this == obj) {
            return true;
        }

        // Checking if the class names are different.
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        // Casting the other object to Person.
        Person person = (Person) obj;

        // Comparing the attributes of the 2 entries.
        if (this.getId() == person.getId()) {
            return true;
        }

        // By default, the objects are different.
        return false;
    }

}
