package theme08_TextProcessing.Exercises;

import java.util.Scanner;

public class P03_ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        int startIndex = path.lastIndexOf("\\")+1;
        String fileName = path.substring(startIndex).split("\\.")[0];
        String extension = path.substring(startIndex).split("\\.")[1];
        System.out.println("File name: "+fileName);
        System.out.println("File extension: "+extension);
    }
}
