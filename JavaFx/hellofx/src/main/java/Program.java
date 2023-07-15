public class Program {
  public static void main(String[] args) {
    method(new C());    
    method(new B());    
    method(new A());      
    
  }
  public static void method(Object o) {
    System.out.println(o.toString());
  }
}

class C extends B {}

class B extends A {
  public String toString() {
    return "B";
  }
}

class  A {
  public String toString() {
    return "A";
  }
}