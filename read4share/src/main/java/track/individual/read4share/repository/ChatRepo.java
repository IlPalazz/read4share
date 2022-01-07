package track.individual.read4share.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import track.individual.read4share.model.Message;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChatRepo extends JpaRepository<Message, Long> {

    /**
     * Find the start message of a specific chat
     * @param sellerId Seller id
     * @param buyerId Buyer id
     * @param advId Advertisement id
     * @return Message object whether the chat exists, null otherwise
     */
    @Query("select mess from Message mess where mess.sender.id=:buyerId and " +
            "mess.recipient.id=:sellerId and mess.adv.id=:advId and " +
            "mess.text=concat('START_', :buyerId,'_', :sellerId, '_', :advId) ")
    Optional<Message> findFirstMessage(UUID sellerId, UUID buyerId, Long advId);

    /**
     * Find all the chats of a specific user
     * @param userId User id
     * @return List of chats
     */
    @EntityGraph(value = "graph.MessageAdvBookUser")
    @Query("select mess from Message mess where (mess.sender.id=:userId " +
            "or mess.recipient.id=:userId) and mess.text like concat('START_%', :userId ,'%') ")
    List<Message> getAllChats(UUID userId);

    /**
     * Delete a chat between two users
     * @param senderId Request sender id
     * @param recipientId Recipient id
     * @param advId Advertisement id
     */
    @Modifying
    @Transactional
    @Query("delete from Message mess where mess.adv.id=:advId and " +
            "((mess.sender.id=:senderId and mess.recipient.id=:recipientId) or " +
            "(mess.sender.id=:recipientId and mess.recipient.id=:senderId))")
    void deleteChat(UUID senderId, UUID recipientId, Long advId);

    @EntityGraph(value = "graph.MessageAdvBookUser")
    @Query("select mess from Message mess where mess.adv.id=:advId and " +
            "mess.text not like 'START_%' and " +
            "((mess.sender.id=:senderId and mess.recipient.id=:recipientId) or " +
            "(mess.sender.id=:recipientId and mess.recipient.id=:senderId))")
    List<Message> getChat(UUID senderId, UUID recipientId, Long advId);
}
