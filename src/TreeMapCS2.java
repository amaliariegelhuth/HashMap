import java.util.*;
/*
Amalia Riegelhuth
amaliariegelhuth

CSCI 1102 Computer Science 2

*/

public class TreeMapCS2<Key extends Comparable<Key>, Value> implements MapCS2<Key, Value> {

  // _________________________________________
  // Note: Once you have implemented all the
  // interface methods, be sure to add implements
  // MapCS2 in the class declaration above.
  // _________________________________________


  // -----------------------------------------
  // Member variables:
  // ------------------------------------------
  // Create pointer to top Node and a size variable
  Node top;
  int size;

  // -----------------------------------------------
  // Node inner class
  // -----------------------------------------------
  // Create an inner class called Node which has the
  // following instance variable:
  // Key k, Value v, Node rightchild, Node leftchild
  // Also create one or more constructors for the Node class.
  // Remember that your binary search tree will be organized
  // according to the Key only (not the value).
  public class Node {
    Key k;
    Value v;
    Node rightchild;
    Node leftchild;

    public Node (Key k, Value v) { //constructor for Node
      this.k = k;
      this.v = v;
    }
  }

  // -----------------------------------------------
  // Constructor(s)
  // -----------------------------------------------
  // Write a constructor for TreeMapCS2, if you wish.
  public TreeMapCS2 () { //constructor for TreeMapCS2
  this.top = null; //instantiates top Node
  size = 0; //sets size to zero
  }

  // -----------------------------------------------
  // Interface methods to implement
  // -----------------------------------------------

  // returns a Value for the specified key
  public Value get(Key key) {
    Node p = top; // pointer Node
    while (p != null) {
      if (p.k.compareTo(key) == 0){
        return p.v;
      } else if (p.k.compareTo(key) > 0) {
        p = p.leftchild;
      } else {
        p = p.rightchild;
      }
    }
    return null;
  }

  // puts a Key-Value pair in the map
  public void put(Key key, Value val) {
    Node n = new Node(key, val); // Node to be inserted
    Node p = top; // pointer Node
    if (top == null) { // if top is null, insert there
      top = n;
      size++;
    } else {
      while (p != null) {
        if (p.k.compareTo(key) == 0) {
          p.v = n.v; //change value if key already present
          break;
        } else if (p.k.compareTo(key) > 0) {
          if (p.leftchild == null) {
            p.leftchild = n; // insert
            size++;
            break;
          } else {
            p = p.leftchild;
          }
        } else {
          if (p.rightchild == null) {
            p.rightchild = n; // insert
            size++;
             break;
          } else {
            p = p.rightchild;
          }
        }
      }
    }
  }

  // returns the *SORTED* keys as an ArrayList
  public ArrayList<Key> getKeys() {
    ArrayList<Key> alofKeys = new ArrayList<Key>();
    Node p = top;
    return inOrderKeys(p, alofKeys); // calls recursive function
  }
  public ArrayList<Key> inOrderKeys(Node n, ArrayList<Key> keys) {
    if (n == null) {
      return null; // stop when there are no more nodes to traverse
    }
    inOrderKeys(n.leftchild, keys);
    keys.add(n.k); // add the key to the array
    inOrderKeys(n.rightchild, keys);
    return keys;
  }

  // returns the minimum key in the map
  public Key min() {
    int comps = 1; // tracks comparisons
    Node p = top;
    while (p.leftchild != null) {
      comps++;
      p = p.leftchild;
    }
    System.out.print(comps);
    return p.k;
  }

  // returns the maximum key in the map
  public Key max() {
    int comps = 1; // tracks comparisons
    Node p = top;
    while (p.rightchild != null) {
      comps++;
      p = p.rightchild;
    }
    System.out.print(comps);
    return p.k;
  }

  // returns true if the map contains the key
  public boolean contains(Key key) {
    Node p = top; // pointer
    boolean contains = false;
    while (p != null) {
      if (p.k.compareTo(key) == 0){
        contains = true;
      } else if (p.k.compareTo(key) > 0) {
        p = p.leftchild;
      } else {
        p = p.rightchild;
      }
    }
    return contains;
  }

  // returns true if map is empty
  public boolean isEmpty() {
    return top == null;
  }

  // returns size of map
  public int size() {
    return size;
  }

  // returns a string with each key : value pair
  public String toString() {
    Node p = top;
    String s = "";
    return inOrder(p, s); // calls recursive function
  }
  public String inOrder(Node n, String s) { // helper recursive method
    if (n == null) {
      return "";
    }
      return inOrder(n.leftchild, s) +
      s + n.k + " : " + n.v + ", " +
      inOrder(n.rightchild, s);
  }

  // -----------------------------------------------
  // Main method to test your code
  // -----------------------------------------------
  public static void main (String[] args) {
    TreeMapCS2<String, Integer> tm = new TreeMapCS2<String, Integer>();
    if (tm.isEmpty()) {
      System.out.println("Empty!");
    }
    tm.put("cake", 5);
    tm.put("ice cream", 6);
    tm.put("salad", 90);
    tm.put("pasta", 45);
    tm.put("bread", 3);
    tm.put("chips", 57);
    System.out.println(tm.size());
    if (tm.contains("hi")) {
      System.out.println("There is a 4.");
    }
    System.out.println(tm.get("salad"));


  }

}
