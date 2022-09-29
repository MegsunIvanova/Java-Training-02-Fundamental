package theme06_ObjectsAndClasses.Exercises.P02_Articles_v02;

public class Article {
    //характеристики, полета
    private String title;
    private String content;
    private String author;

    //конструктор->създаваме обекти
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

    public void rename(String newTitle) {
        this.title = newTitle;
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

    @Override
    public String toString() {
        return this.title + " - " + this.content + ": " + this.author;
    }

}

