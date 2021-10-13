package track.individual.read4share.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.model.Book;
import track.individual.read4share.model.User;
import track.individual.read4share.service.ServiceInt;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/")
public class Controller {

    private final ServiceInt service;

    @Autowired
    public Controller(ServiceInt service) {
        this.service = service;
    }

    // Return a specific user
    @GetMapping("user/{username}")
    public ResponseEntity<User> GetUser(@PathVariable(value = "username") String username) {
        User user = service.GetUser(username);
        if(user != null) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Return all users
    @GetMapping("user/all")
    public ResponseEntity<List<User>> GetAllUsers() {
        List<User> users = service.GetUsers();
        if(users != null) {
            return ResponseEntity.ok().body(users);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Return all books
    @GetMapping("book/all")
    public ResponseEntity<List<Book>> GetAllBooks() {
        List<Book> books = service.GetBooks();
        if(books != null) {
            return ResponseEntity.ok().body(books);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("book/{ISBN}")
    public ResponseEntity<Book> GetBook(@PathVariable(value = "ISBN") String ISBN) {
        Book book = service.GetBook(ISBN);
        if(book != null) {
            return ResponseEntity.ok().body(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add a new user
    @PostMapping("user/add")
    public ResponseEntity<User> AddUser(@RequestBody User user) {
        if (service.GetUser(user.getUsername()) != null) // User doesn't exist
            return new ResponseEntity("User already exists!", HttpStatus.CONFLICT);
        else {
            service.AddUser(user);
            String url = "/user/" + user.getUsername(); // url of the created student
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }

    }
}
