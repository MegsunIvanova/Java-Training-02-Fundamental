package theme06_ObjectsAndClasses.Exercises;

import java.util.Scanner;

public class P02_Articles {
    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void edit(String newContent) {
            this.content = newContent;
        }

        public void changeAuthor(String author) {
            this.author = author;
        }

        public void rename(String title) {
            this.title = title;
        }

        private String getTitle() {
            return this.title;
        }

        private String getContent() {
            return this.content;
        }

        private String getAuthor() {
            return this.author;
        }

        public String toString() {
            return getTitle() + " - " + getContent() + ": " + getAuthor();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] articleArr = scanner.nextLine().split(", ");

        Article article = new Article(articleArr[0], articleArr[1], articleArr[2]);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] commandArr = scanner.nextLine().split(": ");
            String command = commandArr[0];
            String item = commandArr[1];
            switch (command) {
                case "Edit":
                    article.edit(item);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(item);
                    break;
                case "Rename":
                    article.rename(item);
                    break;
            }

        }

        System.out.println(article.toString());
    }
}
