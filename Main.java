

public class Main {
    static void myMethod() {
        System.out.print("Welcome to Java");

    }

    static void myStaticMethod() {
        System.out.println("Static methods can be called without creating objects");
    }


    // Public method
    public void myPublicMethod() {
        System.out.println("Public methods must be called by creating objects");
    }


    public static void main(String[] args) {
        CreateFile.init();
    }
}
