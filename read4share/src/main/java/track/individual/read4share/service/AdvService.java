package track.individual.read4share.service;

import track.individual.read4share.model.Book;

import java.util.List;

public interface AdvService {

    /**
     * Get all books from the DB
     * @return List of books
     */
    List<Book> getBooks();

    /**
     * Get a particular book
     * @param isbn
     * @return Book with the specified ISBN, Null otherwise
     */
    Book getBook(String isbn);
}
