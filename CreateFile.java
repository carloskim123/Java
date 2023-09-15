
import java.io.File;
import java.io.IOException;

public class CreateFile {

    static void init() {
        System.out.print("Initialized successfully!");
    }
    public static void main(String[] args) {
        try {
            File myObj = new File("filename.txt");
            if(myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("Error creating the file.");
            e.printStackTrace();
        }
    }
}
