package track.individual.read4share.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import track.individual.read4share.model.Category;

import javax.transaction.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceFakeTest {

    @Autowired
    private CategoryService catService;

    @Test
    @DisplayName("Should successfully check the category id")
    @Transactional
    void validInsertedCategory() {
        // ARRANGE
        catService.addCategory("Maths");

        // ACT
        Optional<Category> cat = catService.getByName("Maths");

        // ASSERT
        Assertions.assertThat(cat.isPresent()).isTrue();
        Assertions.assertThat(cat.get().getName()).isEqualTo("Maths");
    }

    @Test
    @DisplayName("Should throw an exception when checking the category")
    @Transactional
    void invalidInsertedCategory() {
        // ARRANGE
        catService.addCategory("Maths");

        // ACT
        Optional<Category> cat = catService.getByName("Engineering");

        // ASSERT
        Assertions.assertThat(cat.isPresent()).isFalse();
        Assertions.assertThatExceptionOfType(NoSuchElementException.class).isThrownBy(() -> {
                    Category testCategory = cat.get();
                }
        );
    }
}