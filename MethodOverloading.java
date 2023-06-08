/**
 * MethodOverloading
 * You can have methods with the same name but different parameters, this is how
 * a method can handle differing types of input
 */
public class MethodOverloading {
  public static void main(String[] args) {
    System.out.println("\033[1;34m" + "Max function for integers:\t" + max(5,2));
    System.out.println("\033[1;35m" + "Max function for double:\t" + max(5.0,2.0));
    
  }

  static public int max(int a, int b) {
    return a > b ? a : b;
  }
  static public double max(double a, double b) {
    return a > b ? a : b;
  }
  
}