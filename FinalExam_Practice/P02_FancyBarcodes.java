package FinalExam_Practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("^(@#+)(?<item>[A-Z][A-Za-z0-9]{4,}[A-Z])(@#+)$");

        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                String item = matcher.group("item");
                String group = getGroup(item);
                System.out.println("Product group: " + group);
            } else {
                System.out.println("Invalid barcode");
            }

        }

    }

    private static String getGroup(String item) {
        StringBuilder group = new StringBuilder();
        for (char symbol : item.toCharArray()) {
            if (Character.isDigit(symbol)) {
                group.append(symbol);
            }
        }
        if (group.length()==0) {
            return "00";
        } else return group.toString();
    }
}
