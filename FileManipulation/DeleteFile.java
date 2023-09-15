package FileManipulation;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        File myObj = new File("FileManipulation/filename.txt");
        if (!myObj.exists()) {
            CreateFile.init();
        }

        if (myObj.delete()) {
            System.out.printf("Deleted the file: %s", myObj.getName());
        } else {
            System.out.printf("Failed to delete %s. Does it exist ? ", myObj.getName());
        }

    }


}
