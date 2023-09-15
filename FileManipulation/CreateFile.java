package FileManipulation;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    static void init() {
        try {
            File myObj = new File("FileManipulation/filename.txt");
            if(myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("Error creating the file.");
        }
    }
    public static void main(String[] args) {
        init();
    }
}
