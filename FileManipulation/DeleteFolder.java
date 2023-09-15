package FileManipulation;
import java.io.File;
public class DeleteFolder {
    public  static void main (String[] args) {
        File myObj = new File("C:\\Users\\carlo\\IdeaProjects\\Java\\Test");
        if(myObj.delete()) {
            System.out.printf("Deleted the folder: %s",myObj.getName());
        } else {
            System.out.println("Failed to delete the folder. \nDoes it exist ?");
        }
    }

}
