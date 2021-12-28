package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.dto.response.ChatPreviewResponse;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    @GetMapping("/preview/{userId}")
    public List<ChatPreviewResponse> getChatPreview(@PathVariable UUID userId) {
        return null; // TODO
    }
}
