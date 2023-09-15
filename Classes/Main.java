package Classes;

public class Main {
    int x;  // Create a class attribute
    public Main() {
        x = 5; //Create an object of class Main (This will call the constructor)
    }
    public static void main(String[] args) {
        Main myObj = new Main(); // Create an object of class Main (This will call the constructor)
        System.out.println(myObj.x); // Print the value of x
    }
}


// Outputs 5