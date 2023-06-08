import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Using iterators with Java
 * <b>from Enki</b>
 * 
 * @author Lucas Cekan
 */
class Iterators {
  public static void main(String[] args) {
    List<String> fruit = Arrays.asList("apple", "orange", "dragon fruit");

    // iterating over a list using a while loop
    Iterator<String> fruitIt = fruit.iterator();

    while (fruitIt.hasNext()) {
      System.out.println(fruitIt.next());
    }

    // iterating over a list using a for loop
    for (Iterator<String> fruitItFor = fruit.iterator(); fruitItFor.hasNext();) {
      System.out.println(fruitItFor.next());
    }

    // Using a iterator can be way more efficient with a for loop than with a index
    List<String> colors = Arrays.asList("red", "green", "blue");

    for (String color : colors) {
      System.out.println(color + "\t\033[33;1;41m with better for loop syntax \033[0m");
    }
    // rather than
    for (int i = 0; i < colors.size(); i++) {
      System.out.println(colors.get(i));
    }
  }
}