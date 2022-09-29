package theme08_TextProcessing.Exercises;

import java.util.Scanner;

public class P03_ExtractFile_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        String[] foldersName = path.split("\\\\"); //Сплит по '\'
        String fullFileName = foldersName[foldersName.length - 1];
        String fileName = fullFileName.split("\\.")[0];
        String extension = fullFileName.split("\\.")[1];
        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}
