package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import track.individual.read4share.dto.Converter;
import track.individual.read4share.dto.response.ChatPreviewResponse;
import track.individual.read4share.dto.response.ChatResponse;
import track.individual.read4share.model.Adv;
import track.individual.read4share.model.Message;
import track.individual.read4share.model.User;
import track.individual.read4share.repository.ChatRepo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepo chatRepo;
    private final UserService userService;
    private final AdvService advService;
    private final Converter converter;

    @Override
    public boolean alreadyExist(UUID sellerId, UUID buyerId, Long advId) {
        Optional<Message> firstMessage = chatRepo.findFirstMessage(sellerId, buyerId, advId);
        return firstMessage.isPresent();
    }

    @Override
    public void startChat(UUID sellerId, UUID buyerId, Long advId) {
        // Check whether the chat already exists
        if (this.alreadyExist(sellerId,buyerId,advId))
            return;
        // Insert the first message
        User buyer = userService.getById(buyerId);
            User seller = userService.getById(sellerId);
        Adv adv = advService.getById(advId);
        Message firstMess = Message.builder()
                .text("START_" + buyerId + "_" + sellerId + "_" + advId.toString())
                .timestamp(LocalDateTime.now())
                .read(true)
                .sender(buyer)
                .recipient(seller)
                .adv(adv)
                .build();
        chatRepo.save(firstMess);
    }

    @Override
    public List<ChatPreviewResponse> getChatPreviews(UUID userId) {
        // Get all chat messages
        List<Message> chats = chatRepo.getAllChats(userId);
        return converter.toChatPreviewResponse(userId, chats);
    }

    @Override
    public void deleteChat(UUID senderId, UUID recipientId, Long advId) {
        chatRepo.deleteChat(senderId, recipientId, advId);
    }

    @Override
    public void saveMessage(Message mess) {
        chatRepo.save(mess);
    }

    @Override
    public List<ChatResponse> getChat(UUID senderId, UUID recipientId, Long advId) {
        return converter.toChatResponse(chatRepo.getChat(senderId, recipientId, advId));
    }
}
