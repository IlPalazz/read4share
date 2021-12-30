package track.individual.read4share.service;

import track.individual.read4share.dto.response.ChatPreviewResponse;

import java.util.List;
import java.util.UUID;

public interface ChatService {

    /**
     * Check whether a chat for an adv between two users already exists
     * @param sellerId Seller id
     * @param buyerId Buyer id
     * @param advId Advertisement id
     * @return True if a record is found, false otherwise
     */
    boolean alreadyExist(UUID sellerId, UUID buyerId, Long advId);

    /**
     * Start a new chat
     * @param sellerId Seller id
     * @param buyerId Buyer id
     * @param advId Advertisement id
     */
    void startChat(UUID sellerId, UUID buyerId, Long advId);

    /***
     * Retrieve all the chat previews for a particular user
     * @param userId User id
     * @return List of chat previews
     */
    List<ChatPreviewResponse> getChatPreviews(UUID userId);

    /**
     * Delete a specific chat between two users
     * @param senderId Request sender id
     * @param recipientId Conversation recipient id
     * @param advId Advertisement id
     */
    void deleteChat(UUID senderId, UUID recipientId, Long advId);
}
