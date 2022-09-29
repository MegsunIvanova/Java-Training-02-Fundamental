package FinalExam_Practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //n – the number of pieces
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String[]> collection = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            //"{piece}|{composer}|{key}"
            String input = scanner.nextLine();
            String piece = input.split("\\|")[0];
            String composer = input.split("\\|")[1];
            String key = input.split("\\|")[2];
            collection.putIfAbsent(piece, new String[2]);
            collection.get(piece)[0] = composer;
            collection.get(piece)[1] = key;
        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            if (input.contains("Add")) {
                addPieceToCollection(input, collection);
            } else if (input.contains("Remove")) {
                removePieceFromCollection(input, collection);
            } else if (input.contains("ChangeKey")) {
                changePieceKeyFromCollection(input, collection);
            }
            input = scanner.nextLine();
        }

        collection.entrySet().forEach(p -> {
            String piece = p.getKey();
            String composer = p.getValue()[0];
            String key = p.getValue()[1];
            System.out.printf("%s -> Composer: %s, Key: %s\n", piece, composer, key);
        });

    }

    private static void addPieceToCollection(String input, Map<String, String[]> collection) {
        String piece = input.split("\\|")[1];
        String composer = input.split("\\|")[2];
        String key = input.split("\\|")[3];
        if (collection.containsKey(piece)) {
            System.out.println(piece + " is already in the collection!");
        } else {
            collection.put(piece, new String[]{composer, key});
            System.out.printf("%s by %s in %s added to the collection!\n",
                    piece, composer, key);
        }
    }

    private static void removePieceFromCollection(String input, Map<String, String[]> collection) {
        String piece = input.split("\\|")[1];
        if (collection.containsKey(piece)) {
            collection.remove(piece);
            System.out.println("Successfully removed " + piece + "!");
        } else {
            System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
        }
    }

    private static void changePieceKeyFromCollection(String input, Map<String, String[]> collection) {
        String piece = input.split("\\|")[1];
        String newKey = input.split("\\|")[2];
        if (collection.containsKey(piece)) {
            collection.get(piece)[1] = newKey;
            System.out.printf("Changed the key of %s to %s!\n", piece, newKey);
        } else {
            System.out.println("Invalid operation! " + piece + " does not exist in the collection.");
        }
    }
}
