package theme09_RegularExpressions.Exersices;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_WinningTicket_me {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] tickets = scanner.nextLine().split("(\\s)*,(\\s)*");
        for (int i = 0; i < tickets.length; i++) {
            String ticket = tickets[i];
            if (ticket.length() == 20) {
                String winInfo = checkForWin(ticket);
                System.out.println(winInfo);
            } else {
                System.out.println("invalid ticket");
            }
        }
    }

    private static String checkForWin(String ticket) {
        String ticketForCheck = ticket.substring(0, 10) + " " + ticket.substring(10);
        String regex = "(?<winSymbols>[$|@|#|\\^]{6,10})[\\s\\S]+?\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ticketForCheck);
        String winInfo = "";
        if (matcher.find()) {
            String winSymbols = matcher.group("winSymbols");
            int profit = winSymbols.length();
            char matchSymbol = winSymbols.charAt(0);
            if (profit < 10) {
                winInfo = String.format("ticket \"%s\" - %d%c", ticket, profit, matchSymbol);
            } else {
                winInfo = String.format("ticket \"%s\" - %d%c Jackpot!", ticket, profit, matchSymbol);
            }
        } else {
            winInfo = String.format("ticket \"%s\" - no match", ticket);
        }
        return winInfo;
    }
}


