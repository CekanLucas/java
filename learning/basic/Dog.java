package learning.basic;

public class Dog {
    private String name; 
    private int age;

    // constructor method 
    public Dog(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    
    //methods
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public void setName(String value) {
        name = value;
    }
}
