package track.individual.read4share.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import track.individual.read4share.model.Book;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepoTest {
    
    @Autowired
    private BookRepo bookRepo;

    //@Transactional
    //@Query("select b from book b left join b.category c where c.id = :catId")
    //@EntityGraph(attributePaths = { "category"})
    @Test
    public void findBookByIsbn() {
        Optional<Book> books = bookRepo.findBookByIsbn("1111111111111");
        System.out.println("books = " + books.get().getCategory());
    }

}