package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import track.individual.read4share.service.AdvService;

@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/adv")
@RequiredArgsConstructor
public class AdvController {

    private final AdvService advService;

    @GetMapping("/all")
    public ResponseEntity getBooks() {
        return ResponseEntity.ok(advService.getBooks());
    }
}
