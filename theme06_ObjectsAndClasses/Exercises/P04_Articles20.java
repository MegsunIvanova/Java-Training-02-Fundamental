package theme06_ObjectsAndClasses.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04_Articles20 {
    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String toString() {
            return this.title + " - " + this.content + ": " + this.author;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Article> articleList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] articleArr = scanner.nextLine().split(", ");
            String title = articleArr[0];
            String content = articleArr[1];
            String author = articleArr[2];
            Article article = new Article(title, content, author);
            articleList.add(article);

        }
        String input = scanner.nextLine();
        if (input.equals("title") || input.equals("content") || input.equals("author")) {
            for (Article article : articleList) {
                System.out.println(article.toString());
            }
        }
    }
}
