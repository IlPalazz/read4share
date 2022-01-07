package track.individual.read4share.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import track.individual.read4share.dto.request.SendMessageRequest;
import track.individual.read4share.dto.response.ChatResponse;
import track.individual.read4share.model.Adv;
import track.individual.read4share.model.Message;
import track.individual.read4share.model.User;
import track.individual.read4share.service.AdvService;
import track.individual.read4share.service.ChatService;
import track.individual.read4share.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class ChatWebSocketController {

    private final AdvService advService;
    private final ChatService chatService;
    private final UserService userService;

    @SubscribeMapping("/sub/{advId}/{senderId}/{recipientId}")
    public List<ChatResponse> sub(@DestinationVariable Long advId,
                      @DestinationVariable UUID senderId,
                      @DestinationVariable UUID recipientId) {
        return chatService.getChat(senderId, recipientId, advId);
    }

    @MessageMapping("/send/{advId}/{sellerId}/{buyerId}")
    @SendTo("/chats/message/{advId}/{sellerId}/{buyerId}")
    public ChatResponse sendMessage(SendMessageRequest request,
                                    @DestinationVariable Long advId,
                                    @DestinationVariable UUID sellerId,
                                    @DestinationVariable UUID buyerId) {
        // Create message from request
        Message message = Message.builder()
                .text(request.getText())
                .adv(advService.getById(request.getAdvId()))
                .sender(userService.getById(request.getSenderId()))
                .recipient(userService.getById(request.getRecipientId()))
                .timestamp(LocalDateTime.now())
                .read(false)
                .build();

        // Save message
        chatService.saveMessage(message);

        // Publish the response
        return ChatResponse.builder()
                .message(request.getText())
                .senderId(request.getSenderId())
                .recipientId(request.getRecipientId())
                .read(false)
                .timestamp(message.getTimestamp())
                .build();
    }

}
