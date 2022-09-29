package theme06_ObjectsAndClasses.Exercises;

import java.util.*;

public class P01_AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> phrases = new ArrayList<>(Arrays.asList(
                "Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."));
        List<String> events = new ArrayList<>(Arrays.asList(
                "Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"));
        List<String> authors = new ArrayList<>(Arrays.asList(
                "Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"));
        List<String> cities = new ArrayList<>(Arrays.asList(
                "Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"));

        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= n; i++) {
            String phrase = getText(phrases);
            String event = getText(events);
            String author = getText(authors);
            String city = getText(cities);

            System.out.printf("%s %s %s %s\n",phrase,event,author,city);
        }


    }

    private static String getText(List<String> stringList) {
        Random rnd = new Random();
        int index = rnd.nextInt(stringList.size());
        String text = stringList.get(index);
        stringList.remove(index);
        return text;
    }
}
