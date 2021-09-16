package track.individual.read4share.model;

import lombok.Getter;

import java.util.Date;

@Getter
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private String genre;
    private Date pubDate;

    public Book(String title, String author, String ISBN, String genre, Date pubDate) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.pubDate = pubDate;
    }
}
