package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.dto.request.PublishAdvRequest;
import track.individual.read4share.dto.response.AdvDetailsResponse;
import track.individual.read4share.service.AdvService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/adv/details")
@RequiredArgsConstructor
public class AdvController {

    private final AdvService advService;

    @GetMapping("/{id}")
    public ResponseEntity<AdvDetailsResponse> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(this.advService.getDetailsById(id));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/publish")
    public ResponseEntity<?> publishAdv(@RequestBody PublishAdvRequest request) {
        this.advService.publishAdv(request);
        return ResponseEntity.ok().build();
    }
}
