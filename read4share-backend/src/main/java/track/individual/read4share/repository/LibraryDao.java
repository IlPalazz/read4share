package track.individual.read4share.repository;

import track.individual.read4share.model.Book;

import java.util.List;

public interface LibraryDao {
    Book GetBook(String ISBN);
    void AddBook(Book book);
    void DeleteBook(String ISBN);
    List<Book> GetBooks();
}
