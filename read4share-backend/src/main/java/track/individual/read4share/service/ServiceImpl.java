package track.individual.read4share.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import track.individual.read4share.model.Book;
import track.individual.read4share.model.User;
import track.individual.read4share.repository.LibraryDao;
import track.individual.read4share.repository.UserDao;

import java.lang.annotation.Annotation;
import java.util.List;

@Service
public class ServiceImpl implements ServiceInt{

    @Autowired
    private UserDao userDao;
    @Autowired
    private LibraryDao libraryDao;

    public ServiceImpl() {

    }

    @Override
    public Book GetBook(String ISBN) {
        return libraryDao.GetBook(ISBN);
    }

    @Override
    public List<Book> GetBooks() {
        return libraryDao.GetBooks();
    }

    @Override
    public Book GetFirstBook() {
        return libraryDao.GetBooks().get(0);
    }

    @Override
    public void AddUser(User user) {
        userDao.AddUser(user);
    }

    @Override
    public User GetUser(String username) {
        return userDao.GetUser(username);
    }

    @Override
    public void DeleteUser(String username) {
        userDao.DeleteUser(username);
    }

    @Override
    public List<User> GetUsers() {
        return userDao.GetUsers();
    }

}
