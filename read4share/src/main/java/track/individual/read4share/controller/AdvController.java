package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.model.response.AdvOverview;
import track.individual.read4share.service.AdvService;
import track.individual.read4share.service.CategoryService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/adv")
@RequiredArgsConstructor
public class AdvController {

    private final AdvService advService;
    private final CategoryService categoryService;

    /**
     * Overview of the most recently posted advertisements
     * @param size Number of elements to return to the client
     * @return List of Advertisements
     */
    @GetMapping("/latest")
    public ResponseEntity<List<AdvOverview>> getLatest(@RequestParam int size) {
        List<AdvOverview> temp = advService.getLatest(size);
        return ResponseEntity.ok().body(temp);
    }

    /**
     * Overview of the advertisements with the best rated books
     * @param size Number of elements to return to the client
     * @return List of AdvOverview
     */
    @GetMapping("/bestrate")
    public ResponseEntity<List<AdvOverview>> getBestRating(@RequestParam int size) {
        return ResponseEntity.ok().body(advService.getBestRating(size));
    }

    /**
     * Overview of the latest free advertisements
     * @param size Number of elements to return to the client
     * @return List of AdvOverview
     */
    @GetMapping("/free")
    public ResponseEntity<List<AdvOverview>> getFreeOverview(@RequestParam int size) {
        return ResponseEntity.ok().body(advService.getFree(size));
    }

    /**
     * Overview of the latest advertisements with no delivery fees
     * @param size Number of elements to return to the client
     * @return List of AdvOverview
     */
    @GetMapping("/freedel")
    public ResponseEntity<List<AdvOverview>> getFreeDeliveryOverview(@RequestParam int size) {
        return ResponseEntity.ok().body(advService.getFreeDel(size));
    }

    /**
     * Advertisements overview with books marked as new
     * @param size Number of elements to return to the client
     * @return List of AdvOverview
     */
    @GetMapping("/asnew")
    public ResponseEntity<List<AdvOverview>> getAsNewOverview(@RequestParam int size) {
        return ResponseEntity.ok().body(advService.getAsNew(size));
    }

    /**
     * Advertisements with books that belong to a specific category
     * @param catId Category id
     * @param page Requested page of Advertisements
     * @param size Number of elements to return to the client
     * @return List of Advertisements
     */
    @GetMapping("/cat") // TODO: Implement method in AdvServiceImpl
    public ResponseEntity<List<AdvOverview>> getByCategory(@RequestParam("id") Long catId,
                                                           @RequestParam int page,
                                                           @RequestParam int size) {
        return ResponseEntity.ok().body(advService.getByCategoryId(catId, page, size));
    }
}
