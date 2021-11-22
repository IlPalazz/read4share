package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.model.Advertisement;
import track.individual.read4share.model.Category;
import track.individual.read4share.model.response.AdvOverview;
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
     * Overview of the most recently posted advertisements
     * @return List of Advertisements
     */
    @GetMapping("/latest")
    public ResponseEntity<List<AdvOverview>> getLatest() {
        List<AdvOverview> temp = advService.getLatest();
        return ResponseEntity.ok().body(temp);
    }

    /**
     * Overview of the advertisements with the best rated books
     * @return List of AdvOverview
     */
    @GetMapping("/bestrate")
    public ResponseEntity<List<AdvOverview>> getBestRating() {
        return ResponseEntity.ok().body(advService.getBestRating());
    }

    /**
     * Overview of the latest free advertisements
     * @return List of AdvOverview
     */
    @GetMapping("/free")
    public ResponseEntity<List<AdvOverview>> getFreeOverview() {
        return ResponseEntity.ok().body(advService.getFree());
    }

    /**
     * Overview of the latest advertisements with no delivery fees
     * @return List of AdvOverview
     */
    @GetMapping("/freedel")
    public ResponseEntity<List<AdvOverview>> getFreeDeliveryOverview() {
        return ResponseEntity.ok().body(advService.getFreeDel());
    }

    /**
     * Advertisements overview with books marked as new
     * @return List of AdvOverview
     */
    @GetMapping("/asnew")
    public ResponseEntity<List<AdvOverview>> getAsNewOverview() {
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
