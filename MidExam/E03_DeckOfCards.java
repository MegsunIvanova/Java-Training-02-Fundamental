package MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03_DeckOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> deck = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfCommands; i++) {
            String[] commandLine = scanner.nextLine().split(", ");
            String command = commandLine[0];

            switch (command) {
                case "Add":
                    String addCardName = commandLine[1];
                    addNewCardToTheDeck(deck, addCardName);
                    break;

                case "Remove":
                    String removeCardName = commandLine[1];
                    removeCardFromTheDeck(deck, removeCardName);
                    break;

                case "Remove At":
                    int removeAtIndex = Integer.parseInt(commandLine[1]);
                    removeCardAtIndexFromTheDeck(deck, removeAtIndex);
                    break;

                case "Insert":
                    int insertAtIndex = Integer.parseInt(commandLine[1]);
                    String insertCardName = commandLine[2];
                    insertCardAtIndexToTheDeck(deck, insertAtIndex, insertCardName);
                    break;
            }

        }

        //print
        System.out.println(String.join(", ", deck));


    }

    private static boolean isCardAlreadyInTheDeck(List<String> deck, String cardName) {
        return deck.contains(cardName);
    }

    private static void addNewCardToTheDeck(List<String> deck, String cardName) {
        if (isCardAlreadyInTheDeck(deck, cardName)) {
            System.out.println("Card is already in the deck");
        } else {
            deck.add(cardName);
            System.out.println("Card successfully added");
        }
    }

    private static void removeCardFromTheDeck(List<String> deck, String cardName) {
        if (!isCardAlreadyInTheDeck(deck, cardName)) {
            System.out.println("Card not found");
        } else {
            deck.remove(cardName);
            System.out.println("Card successfully removed");
        }
    }

    private static boolean isIndexInRange(List<String> deck, int index) {
        return (index >= 0 && index < deck.size());
    }

    private static void removeCardAtIndexFromTheDeck(List<String> deck, int index) {
        if (isIndexInRange(deck, index)) {
            deck.remove(index);
            System.out.println("Card successfully removed");
        } else {
            System.out.println("Index out of range");
        }
    }

    private static void insertCardAtIndexToTheDeck
            (List<String> deck, int index, String cardName) {

        if (isIndexInRange(deck, index)) {
            if (!isCardAlreadyInTheDeck(deck, cardName)) {
                deck.add(index, cardName);
                System.out.println("Card successfully added");

            } else {
                System.out.println("Card is already added");
            }
        } else {
            System.out.println("Index out of range");
        }

    }
}
