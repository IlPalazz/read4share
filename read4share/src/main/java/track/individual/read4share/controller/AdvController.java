package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.dto.response.ActiveAdvResponse;
import track.individual.read4share.service.AdvOverviewService;
import track.individual.read4share.service.AdvService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/adv/details")
@RequiredArgsConstructor
public class AdvController {

    private final AdvService advService;

    @GetMapping("/{id}")
    public ResponseEntity<ActiveAdvResponse> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.advService.getById(id));
    }
}
