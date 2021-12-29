package track.individual.read4share.service;

import track.individual.read4share.dto.response.AdvDetailsResponse;
import track.individual.read4share.exception.ItemNotFoundException;
import track.individual.read4share.model.Adv;

public interface AdvService {

    /**
     * Return a DTO response of the adv with the given id
     * @param id Adv id
     * @return ActiveAdvResponse of the requested adv
     * @throws ItemNotFoundException Whether the adv with the given id does not exist
     */
    AdvDetailsResponse getDetailsById(Long id) throws ItemNotFoundException;

    /**
     * Return a specific Advertisement
     * @param id Advertisement id
     * @return Advertisement object
     * @throws ItemNotFoundException If the item does not exist
     */
    Adv getById(Long id) throws ItemNotFoundException;
}
