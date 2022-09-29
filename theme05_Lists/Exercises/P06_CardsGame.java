package theme05_Lists.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayerDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayerDeck = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (firstPlayerDeck.size() > 0 && secondPlayerDeck.size() > 0) {
            int firstPlayerCard = firstPlayerDeck.get(0);
            int secondPlayerCard = secondPlayerDeck.get(0);
            firstPlayerDeck.remove(0);
            secondPlayerDeck.remove(0);
            if (firstPlayerCard > secondPlayerCard) {
                putCardsAtBackOfHand(firstPlayerDeck,
                        firstPlayerCard, secondPlayerCard);

            } else if (secondPlayerCard > firstPlayerCard) {
                putCardsAtBackOfHand(secondPlayerDeck,
                        secondPlayerCard, firstPlayerCard);
            }

        }

        if (firstPlayerDeck.size() > 0) {
            System.out.printf("First player wins! Sum: %d", sumOfDeck(firstPlayerDeck));
        } else if (secondPlayerDeck.size() > 0) {
            System.out.printf("Second player wins! Sum: %d", sumOfDeck(secondPlayerDeck));
        }

    }

    public static void putCardsAtBackOfHand
            (List<Integer> winningPlayerDeck,
             int winningCard, int otherPlayerCard) {
        winningPlayerDeck.add(winningCard);
        winningPlayerDeck.add(otherPlayerCard);


    }

    public static int sumOfDeck(List<Integer> deck) {
        int sumOfDeck = 0;
        for (Integer card : deck) {
            sumOfDeck += card;
        }
        return sumOfDeck;
    }
}
