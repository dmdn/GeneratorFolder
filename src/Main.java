import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int folderNumber = 0;
        String nameFolder = "\\test00";
        boolean created;

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the path to an existing folder (d:\\myTest): ");
        String path = in.nextLine();

       if (path.equals("")){
           path = System.getProperty("user.dir");
        }


        File file = new File(path + nameFolder);
        created = file.mkdir();
        File dir = file;

        while (!created) {
            folderNumber++;
            if (folderNumber > 0 && folderNumber <= 9) {
                nameFolder = "\\test0" + Integer.toString(folderNumber);
            } else {
                nameFolder = "\\test" + Integer.toString(folderNumber);
            }

            File file2 = new File(path + nameFolder);
            created = file2.mkdir();
            dir = file2;
        }

        File parentDir = dir.getParentFile();
        for (File item : parentDir.listFiles()) {
            System.out.println(item.getName());
        }

    }

}
