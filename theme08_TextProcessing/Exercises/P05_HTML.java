package theme08_TextProcessing.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05_HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String content = scanner.nextLine();
        List<String> comments = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end of comments")) {
            comments.add(input);
            input = scanner.nextLine();
        }
        System.out.printf("<h1>\n" +
                "    %s\n" +
                "</h1>\n",title);
        System.out.printf("<article>\n" +
                "    %s\n" +
                "</article>\n",content);
        for (String comment : comments) {
            System.out.printf("<div>\n" +
                    "    %s\n" +
                    "</div>\n",comment);
        }

    }
}
