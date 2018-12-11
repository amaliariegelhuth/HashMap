import java.util.*;
/*
Amalia Riegelhuth
amaliariegelhuth

CSCI 1102 Computer Science 2

*/
public class HashMapCS2<Key extends Comparable<Key>, Value> implements MapCS2<Key, Value> {

  // _________________________________________
  // Note: Once you have implemented all the
  // interface methods, be sure to add implements
  // MapCS2 in the class declaration above.
  // _________________________________________


  // -----------------------------------------
  // Inner class: KeyValuePair
  // ------------------------------------------
  public class KeyValuePair {
    Key k;
    Value v;

    public KeyValuePair(Key k, Value v) {
      this.k = k;
      this.v = v;
    }
    public Key getKey() {
      return k;
    }
    public Value getValue(){
      return v;
    }
    public void setValue(Value value) {
      v = value;
    }
  }

  // -----------------------------------------
  // Member variables: storage array and size
  // ------------------------------------------

  // An ArrayList of LinkedLists.
  // The indices into the ArrayList will correspond
  // to hashcodes. At each index in the ArrayList, you will have
  // a LinkedList of KeyValuePairs. This is how you will implement
  // separate chaining when your hash function produces collisions.
  ArrayList<LinkedList<KeyValuePair>> storage;

  // A variable containing the size of the storage array.
  int size;

  // -----------------------------------------------
  // Constructor
  // -----------------------------------------------
  // I have written the HashMapCS2 constructor for you.
  // We create an ArrayList with 31 elements.
  // Each element is an empty LinkedList.
  // Each LinkedList will hold KeyValuePair objects,
  // one for each key you add with that hashcode.
  public HashMapCS2() {
    this.storage = new ArrayList<LinkedList<KeyValuePair>>();
    for (int i=0; i < 31; i++) {
      storage.add(new LinkedList<KeyValuePair>());
    }
    this.size = 0;
  }


  // -----------------------------------------------
  // Hash functions
  // -----------------------------------------------
  // Fill in the blanks below, following the instructions.
  int hashFunction(Key k) {
    int hashcode = 0;

    if (k instanceof String) {
      String s = (String) k;
      // implement this String hash function:
      /* for each char in the String s:
          multiply the int value of the char by its position in the String plus one
          add that to the current total
         hashcode is the remainder of the final divided by 31
      */
      int total = 0;
      for (int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        int n = Character.getNumericValue(c);
        int hashcodeC = n * (i + 1);
        total = total + hashcodeC;
      }
      hashcode = total / 31;

    } else if (k instanceof Double) {
      Double d = (Double) k;
      // implement this Double hash function:
      /* hashcode is the remainder of the absolute value d
         as an integer when divided by 31
      */
      hashcode = Math.abs(d.intValue()) / 31;


    } else if (k instanceof Integer) {
      Integer q = (Integer) k;
      // implement this Integer hash function:
      /* hashcode is the remainder of the absolute value of q
         when divided by 31
      */
      hashcode = (Math.abs(q)) / 31;


    } else {
      // If hashcode returns -1, you have a problem! Throw an exception
      throw new IllegalArgumentException("Invalid key type.");
    }
    return hashcode;
  }

  // -----------------------------------------------
  // Interface methods to implement
  // -----------------------------------------------

  // returns a Value for the specified key
  public Value get(Key key){
    int index = hashFunction(key); // hashcode
    LinkedList<KeyValuePair> ll = storage.get(index);
    for (int i = 0; i < ll.size(); i++) {
      if (ll.get(i).getKey().equals(key)) {
        return ll.get(i).getValue();
      }
    }
    return null; // if don't find match return null
  }

  // puts a Key-Value pair in the map
  public void put(Key key, Value val) {
    int index = hashFunction(key); // hashcode
    if (storage.get(index).contains(key)) { //check to see if value is already there
      for (int i = 0; i < storage.get(index).size(); i++) {
        if (storage.get(index).get(i).getKey().equals(key)) {
          storage.get(index).get(i).setValue(val);
        }
      }
    } else {
      storage.get(index).add(new KeyValuePair(key, val));
      size++;
    }
  }

  // returns the keys of the map as an ArrayList
  public ArrayList<Key> getKeys() {
    ArrayList<Key> alofKeys = new ArrayList<Key>();
    for (int i = 0; i < storage.size(); i++) {
      for (int j = 0; j < storage.get(i).size(); j++) {
        alofKeys.add(storage.get(i).get(j).getKey());
      }
    }
    return alofKeys;
  }

  // returns the minimum key in the map
  public Key min() {
    int comps = 0; // tracks comparisons
    Key min = storage.get(0).get(0).getKey();
    for (int i = 0; i < storage.size(); i++) {
      for (int j = 0; j < storage.get(i).size(); j++) {
        Key current = storage.get(i).get(j).getKey();
        comps++;
        if (current.compareTo(min) < 0) {
          min = current;
        }
      }
    }
    System.out.println(comps);
    return min;
  }

  // returns the maximum key in the map
  public Key max() {
    int comps = 0; // track comparisons
    Key max = storage.get(0).get(0).getKey();
    for (int i = 0; i < storage.size(); i++) {
      for (int j = 0; j < storage.get(i).size(); j++) {
        Key current = storage.get(i).get(j).getKey();
        comps++;
        if (current.compareTo(max) > 0) {
          max = current;

        }
      }
    }
    System.out.println(comps);
    return max;
  }

  // returns true if the map contains the key
  public boolean contains(Key key) {
    boolean contains = false;
    for (int i = 0; i < storage.size(); i++) {
      for (int j = 0; j < storage.get(i).size(); j++) {
        if (storage.get(i).get(j).getKey().equals(key)) {
          contains = true;
        }
      }
    }
    return contains;
  }

  // returns true if map is empty
  public boolean isEmpty() {
    boolean isEmpty = true;
    for (int i = 0; i < storage.size(); i++) {
      for (int j = 0; j < storage.get(i).size(); j++) {
        if (storage.get(i).get(j) != null) {
          isEmpty = false;
        }
      }
    }
    return isEmpty;
  }

  // returns size of map
  public int size() {
    return size;
  }

  // returns a string with each key : value pair
  public String toString() {
    String s = "";
    for (int i = 0; i < storage.size(); i++) {
      for (int j = 0; j < storage.get(i).size(); j++) {
        s = s + storage.get(i).get(j).getKey() + " : " + storage.get(i).get(j).getValue() + ", ";
      }
    }
    return s;
  }

  // -----------------------------------------------
  // Main method to test out your code
  // -----------------------------------------------
  public static void main (String[] args) {
    HashMapCS2<String, Integer> hm = new HashMapCS2<String, Integer>();
    if (hm.isEmpty()) {
      System.out.println("Empty!");
    }
    hm.put("cake", 5);
    hm.put("ice cream", 6);
    hm.put("salad", 90);
    hm.put("pasta", 45);
    hm.put("bread", 3);
    hm.put("chips", 57);
    System.out.println(hm.size());
    if (hm.contains("hi")) {
      System.out.println("There is a 4.");
    }
    System.out.println(hm.get("salad"));


  }

}
