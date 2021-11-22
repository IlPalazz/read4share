package track.individual.read4share.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import track.individual.read4share.model.Category;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {
    
    @Autowired
    private CategoryRepo catRepo;
    
    @Test
    public void getAllCategories() {
        List<Category> catList = catRepo.findAll();
        assertNotNull(catList);
        for (Category cat : catList)
            System.out.println("cat.getName() + \" \" = " + cat.getName() + " ");
    }
    
    @Test
    public void getById() {
        Optional<Category> cat = catRepo.findById((long) 25);
        assertTrue(cat.isPresent());
        System.out.println("cat = " + cat);
    }

}