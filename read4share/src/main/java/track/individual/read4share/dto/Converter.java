package track.individual.read4share.dto;

import track.individual.read4share.dto.response.AdvDetailsResponse;
import track.individual.read4share.dto.response.AdvOverviewResponse;
import track.individual.read4share.dto.response.ChatPreviewResponse;
import track.individual.read4share.model.Adv;
import track.individual.read4share.model.Message;

import java.util.List;
import java.util.UUID;

public interface Converter {

    /**
     * Convert a list of Adv into a list of AdvOverviewResponse
     * @param advs List of Adv to convert
     * @return List of AdvOverviewResponse
     */
    List<AdvOverviewResponse> toAdvOverviewResponse(List<Adv> advs);

    /**
     * Convert an Adv object into an AdvOverviewResponse object
     * @param adv Advertisement to convert
     * @return AdvOverviewResponse object
     */
    AdvOverviewResponse toAdvOverviewResponse(Adv adv);

    /**
     * Convert a list of Adv into a list of ActiveAdvResponse
     * @param advs List of Adv to convert
     * @return List of ActiveAdvResponse
     */
    List<AdvDetailsResponse> toActiveAdvResponse(List<Adv> advs);

    /**
     * Convert an Adv object into an ActiveAdvResponse object
     * @param adv Advertisement to convert
     * @return ActiveAdvResponse object
     */
    AdvDetailsResponse toActiveAdvResponse(Adv adv);

    /**
     * Convert a list of Messages into a list of ChatPreviewResponse
     * @param chats User's chats
     * @return List of ChatPreviewResponse
     */
    List<ChatPreviewResponse> toChatPreviewResponse(UUID userId, List<Message> chats);

    /**
     * Convert an Message object into a ChatPreviewResponse object
     * @param chat Message to convert
     * @return ChatPreviewResponse object
     */
    ChatPreviewResponse toChatPreviewResponse(UUID userId, Message chat);
}
