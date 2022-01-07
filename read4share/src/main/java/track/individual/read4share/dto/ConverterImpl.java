package track.individual.read4share.dto;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import track.individual.read4share.dto.response.AdvDetailsResponse;
import track.individual.read4share.dto.response.AdvOverviewResponse;
import track.individual.read4share.dto.response.ChatPreviewResponse;
import track.individual.read4share.dto.response.ChatResponse;
import track.individual.read4share.model.Adv;
import track.individual.read4share.model.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@NoArgsConstructor
public class ConverterImpl implements Converter {

    @Override
    public List<AdvOverviewResponse> toAdvOverviewResponse(List<Adv> advs) {
        List<AdvOverviewResponse> listDto = new ArrayList<>();
        for (Adv adv : advs)
            listDto.add(this.toAdvOverviewResponse(adv));
        return listDto;
    }

    @Override
    public AdvOverviewResponse toAdvOverviewResponse(Adv adv) {
        return AdvOverviewResponse.builder()
                .advId(adv.getId())
                .bookTitle(adv.getBook().getTitle())
                .bookAuthor(adv.getBook().getAuthor())
                .sellerUsername(adv.getSeller().getUsername())
                .advLocation(adv.getCity().getName())
                .advPrice(adv.getPrice())
                .bookCoverUrl(adv.getBook().getCoverUrl())
                .advPublDate(adv.getPublDate())
                .build();
    }

    @Override
    public List<AdvDetailsResponse> toActiveAdvResponse(List<Adv> advs) {
        List<AdvDetailsResponse> listDto = new ArrayList<>();
        for (Adv adv : advs)
            listDto.add(this.toActiveAdvResponse(adv));
        return listDto;
    }

    @Override
    public AdvDetailsResponse toActiveAdvResponse(Adv adv) {
        return AdvDetailsResponse.builder()
                .advId(adv.getId())
                .advDescr(adv.getDescr())
                .advPrice(adv.getPrice())
                .advShipCost(adv.getShipCost())
                .advPublDate(adv.getPublDate())
                .advSaleDate(adv.getSaleDate())
                .advPicPath(adv.getPicPath())
                .advLocation(adv.getCity())
                .book(adv.getBook())
                .condition(adv.getCondition())
                .sellerUsername(adv.getSeller().getUsername())
                .build();
    }

    @Override
    public List<ChatPreviewResponse> toChatPreviewResponse(UUID userId, List<Message> chats) {
        List<ChatPreviewResponse> listDTO = new ArrayList<>();
        for (Message chat : chats)
            listDTO.add(this.toChatPreviewResponse(userId, chat));
        return listDTO;
    }

    @Override
    public ChatPreviewResponse toChatPreviewResponse(UUID userId, Message chat) {
        ChatPreviewResponse chatPreview = ChatPreviewResponse.builder()
                .advId(chat.getAdv().getId())
                .bookTitle(chat.getAdv().getBook().getTitle())
                .bookCoverUrl(chat.getAdv().getBook().getCoverUrl())
                .sellerId(chat.getAdv().getSeller().getId())
                .build();
        // If the message sender is the client of the request, then take the id on the adv side
        if (chat.getSender().getId().equals(userId)) {
            chatPreview.setRecipientId(chat.getAdv().getSeller().getId());
            chatPreview.setRecipientUsername(chat.getAdv().getSeller().getUsername());
        }
        else {
            chatPreview.setRecipientId(chat.getSender().getId());
            chatPreview.setRecipientUsername(chat.getSender().getUsername());
        }
        return chatPreview;
    }

    @Override
    public List<ChatResponse> toChatResponse(List<Message> chat) {
        List<ChatResponse> listDTO = new ArrayList<>();
        for (Message mess : chat)
            listDTO.add(this.toChatResponse(mess));
        return listDTO;
    }

    @Override
    public ChatResponse toChatResponse(Message chat) {
        return ChatResponse.builder()
                .senderId(chat.getSender().getId())
                .recipientId(chat.getRecipient().getId())
                .timestamp(chat.getTimestamp())
                .read(chat.isRead())
                .message(chat.getText())
                .build();
    }


}
