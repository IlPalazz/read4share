package track.individual.read4share.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import track.individual.read4share.model.Category;

import javax.transaction.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceFakeTest {

    @Autowired
    private CategoryService catService;

    @Test
    @DisplayName("Should successfully check the category id")
    @Transactional
    void isValid() {
        // ARRANGE
        catService.addCategory("Matematica");
        Optional<Category> cat = catService.getByName("Matematica");
        System.out.println("cat.get() = " + cat.get());
    }
}