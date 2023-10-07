package Keywords.Super;

public class Animal {
    int age;
    String name;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public void makeNoise() {
        System.out.println("Hello, i'm an animal");
    }

    public void eat() {
        System.out.println("Munch");
    }

}
