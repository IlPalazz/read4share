package track.individual.read4share.repository;

import org.springframework.stereotype.Repository;
import track.individual.read4share.model.Book;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class LibraryDaoImpl implements LibraryDao{

    private static ArrayList<Book> books;

    public LibraryDaoImpl() {
        books = new ArrayList<>();
        // Fill with fake data
        books.add(new Book("demoTitle1", "auth1", "1", "gen1", new Date()));
        books.add(new Book("demoTitle2", "auth2", "2", "gen2", new Date()));

    }

    public void AddBook(Book book) {
        books.add(book);
    }

    public Book GetBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN))
                return book;
        }
        return null;
    }

    public void DeleteBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN))
                books.remove(book);
        }
    }

    @Override
    public List<Book> GetBooks() {
        return books;
    }
}
