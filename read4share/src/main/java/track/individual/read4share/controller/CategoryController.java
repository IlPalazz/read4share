package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.model.Category;
import track.individual.read4share.repository.CategoryRepo;
import track.individual.read4share.service.CategoryService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/cat")
@RequiredArgsConstructor
public class CategoryController {

    // TODO: Move getAllCategories into AdvController
    private final CategoryService categoryService;

    /**
     * Returns all the categories
     * @return List of categories
     */
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity.ok().body(categoryService.getAll());
    }


}
