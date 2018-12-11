public class TestMyMaps {
  /*
Amalia Riegelhuth
amaliariegelhuth

CSCI 1102 Computer Science 2

*/
  public static void main (String[] args) {
    // your code goes here
    HashMapCS2<Integer, String> hm1 = new HashMapCS2<Integer, String>();
    TreeMapCS2<Integer, String> tm1 = new TreeMapCS2<Integer, String>();
    hm1.put(5, "dog");
    hm1.put(22, "lion");
    hm1.put(36, "cat");
    hm1.put(73, "elephant");
    hm1.put(89, "monkey");
    hm1.put(177, "donkey");
    hm1.put(215, "cheetah");
    hm1.put(315, "panda");
    hm1.put(470, "alligator");
    hm1.put(496, "koala");

    tm1.put(5, "dog");
    tm1.put(22, "lion");
    tm1.put(36, "cat");
    tm1.put(73, "elephant");
    tm1.put(89, "monkey");
    tm1.put(177, "donkey");
    tm1.put(215, "cheetah");
    tm1.put(315, "panda");
    tm1.put(470, "alligator");
    tm1.put(496, "koala");

    System.out.println("Order 1: ");
    System.out.print("The number of comparisons to find the minimum is: ");
    hm1.min();
    System.out.print(" for the hashmap, and ");
    tm1.min();
    System.out.println(" for the treemap.");
    System.out.print("The number of comparisons to find the maximum is: ");
    hm1.max();
      System.out.print(" for the hashmap, and ");
    tm1.max();
    System.out.println(" for the treemap.");

    HashMapCS2<Integer, String> hm2 = new HashMapCS2<Integer, String>();
    TreeMapCS2<Integer, String> tm2 = new TreeMapCS2<Integer, String>();

    hm2.put(177, "donkey");
    hm2.put(215, "cheetah");
    hm2.put(89, "monkey");
    hm2.put(315, "panda");
    hm2.put(73, "elephant");
    hm2.put(470, "alligator");
    hm2.put(22, "lion");
    hm2.put(5, "dog");
    hm2.put(36, "cat");
    hm2.put(496, "koala");

    tm2.put(177, "donkey");
    tm2.put(215, "cheetah");
    tm2.put(89, "monkey");
    tm2.put(315, "panda");
    tm2.put(73, "elephant");
    tm2.put(470, "alligator");
    tm2.put(22, "lion");
    tm2.put(5, "dog");
    tm2.put(36, "cat");
    tm2.put(496, "koala");

    System.out.println("Order 2: ");
    System.out.print("The number of comparisons to find the minimum is: ");
    hm2.min();
    System.out.print(" for the hashmap, and ");
    tm2.min();
    System.out.println(" for the treemap.");
    System.out.print("The number of comparisons to find the maximum is: ");
    hm2.max();
    System.out.print(" for the hashmap, and ");
    tm2.max();
    System.out.println(" for the treemap.");


    /*
    The number of comparisons for HashMap is linear and is the same in all
    cases of a Hashmap of the same size whereas the number of comparisons
    greatly depends on the order the items are inserted for a TreeMap.
    This is because for a HashMap you perform n(number of keys) comparisons no
    matter what but in a TreeMap you traverse down either the left or the right
    side so it depends on the depth of the leftmost or rightmost node.
    */



  }
}
