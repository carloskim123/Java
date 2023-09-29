package Projects;
import java.io.File;

public class FileRenamer {
    public static void main(String[] args) {
        // Get the current working directory
        String currentDirectory = System.getProperty("user.dir");

        // Specify the directory where your files are located (relative to the current directory)
        String directoryPath = currentDirectory + "/your_directory";

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Check if the directory exists
        if (directory.exists() && directory.isDirectory()) {
            // List all files in the directory
            File[] files = directory.listFiles();

            if (files != null) {
                // Define the criteria for renaming files
                String fileExtensionToRename = ".txt"; // Change to your desired file extension
                String newFileExtension = ".csv"; // Change to your desired new file extension

                // Iterate through the files in the directory
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(fileExtensionToRename)) {
                        // Construct the new file name with the new extension
                        String newFileName = file.getName().replace(fileExtensionToRename, newFileExtension);

                        // Create a new File object with the updated file name
                        File newFile = new File(directoryPath, newFileName);

                        // Rename the file
                        if (file.renameTo(newFile)) {
                            System.out.println("Renamed: " + file.getName() + " to " + newFile.getName());
                        } else {
                            System.out.println("Failed to rename: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}
