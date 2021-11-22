package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.model.Advertisement;
import track.individual.read4share.model.Category;
import track.individual.read4share.service.AdvService;
import track.individual.read4share.service.CategoryService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/adv")
@RequiredArgsConstructor
public class AdvController {

    private final AdvService advService;
    private final CategoryService categoryService;

    /**
     * Most recently posted advertisements
     * @return List of Advertisements
     */
    @GetMapping("/latest")
    public ResponseEntity<List<Advertisement>> getLatest() {
        List<Advertisement> temp = advService.getLatest();
        return ResponseEntity.ok().body(temp);
    }

    /**
     * Advertisements with the best rated books
     * @return List of Advertisements
     */
    @GetMapping("/bestrate")
    public ResponseEntity<List<Advertisement>> getBestRating() {
        return ResponseEntity.ok().body(advService.getBestRating());
    }

    /**
     * Latest free advertisements
     * @return List of Advertisements
     */
    @GetMapping("/free")
    public ResponseEntity<List<Advertisement>> getFree() {
        return ResponseEntity.ok().body(advService.getFree());
    }

    /**
     * Latest advertisements with no delivery fees
     * @return List of Advertisements
     */
    @GetMapping("/freedel")
    public ResponseEntity<List<Advertisement>> getFreeDelivery() {
        return ResponseEntity.ok().body(advService.getFreeDel());
    }

    /**
     * Advertisements with books marked as new
     * @return List of Advertisements
     */
    @GetMapping("/asnew")
    public ResponseEntity<List<Advertisement>> getAsNew() {
        return ResponseEntity.ok().body(advService.getAsNew());
    }

    /**
     * Advertisements with books that belong to a specific category
     * @return List of Advertisements
     */
    @GetMapping("/cat")
    public ResponseEntity<?> getByCategory(@RequestParam("id") Long catId) {
        Optional<Category> category = categoryService.findByid(catId);  // Get category by id
        if (category.isEmpty()) // If category doesn't exist
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specified category not found");
        // TODO: Implements custom exception handler
        // Else return the related advertisements list
        return ResponseEntity.ok().body(advService.getByCategoryId(category.get().getId()));
    }
}
