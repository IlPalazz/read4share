package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.service.AdvService;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/adv")
@RequiredArgsConstructor
public class AdvController {

    private final AdvService advService;

    /**
     * Most recently posted advertisements
     * @return List of Advertisements
     */
    @GetMapping("/latest")
    public ResponseEntity getLatest() {
        return null;
    }

    /**
     * Advertisements with the best rated books
     * @return List of Advertisements
     */
    @GetMapping("/best")
    public ResponseEntity getBest() {
        return null;
    }

    /**
     * Free advertisements
     * @return List of Advertisements
     */
    @GetMapping("/free")
    public ResponseEntity getFree() {
        return null;
    }

    /**
     * Advertisements with no delivery fees
     * @return List of Advertisements
     */
    @GetMapping("/freedel")
    public ResponseEntity getFreeDelivery() {
        return null;
    }

    /**
     * Advertisements with books marked as new
     * @return List of Advertisements
     */
    @GetMapping("/asnew")
    public ResponseEntity getAsNew() {
        return null;
    }

    /**
     * Advertisements with books that belong to a specific category
     * @return List of Advertisements
     */
    @GetMapping("/cat")
    public ResponseEntity getByCategory(@RequestParam("id") Long catId) {
        return null;
    }
}
