package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import track.individual.read4share.dto.request.CreateChatRequest;
import track.individual.read4share.dto.response.ChatPreviewResponse;
import track.individual.read4share.security.UserDetailsImpl;
import track.individual.read4share.service.AdvService;
import track.individual.read4share.service.ChatService;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final AdvService advService;
    private final ChatService chatService;

    @GetMapping("/preview")
    public ResponseEntity<List<ChatPreviewResponse>> getChatPreview() {
        // Get user details
        UserDetailsImpl userDetails =
                (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(this.chatService.getChatPreviews(userDetails.getId()));
    }

    @PostMapping("/start")
    public ResponseEntity<?> startNewChat(@RequestBody CreateChatRequest request) {
        // Get adv seller id
        UUID sellerId = advService.getById(request.getAdvId()).getSeller().getId();

        // Create the chat
        chatService.startChat(sellerId, request.getBuyerId(), request.getAdvId());
        return ResponseEntity.ok().build();
    }
}
