package track.individual.read4share.service;

import track.individual.read4share.model.Book;
import track.individual.read4share.model.User;

import java.util.List;

public interface ServiceInt {
    Book GetBook(String ISBN);
    List<Book> GetBooks();
    Book GetFirstBook();
    void AddUser(User user);
    User GetUser(String username);
    void DeleteUser(String username);
}
