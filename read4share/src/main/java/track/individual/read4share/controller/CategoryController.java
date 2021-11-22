package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.repository.CategoryRepo;
import track.individual.read4share.service.CategoryService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/cat")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    /**
     * Returns all the categories
     * @return List of Category
     */
    @GetMapping("/all")
    public ResponseEntity<List<String>> getAll() {
        return ResponseEntity.ok().body(categoryService.getAll());
    }
}
