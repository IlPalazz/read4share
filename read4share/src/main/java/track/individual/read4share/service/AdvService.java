package track.individual.read4share.service;

import track.individual.read4share.dto.response.ActiveAdvResponse;
import track.individual.read4share.exception.ItemNotFoundException;

public interface AdvService {

    /**
     * Return a DTO response of the adv with the given id
     * @param id Adv id
     * @return ActiveAdvResponse of the requested adv
     * @throws ItemNotFoundException Whether the adv with the given id does not exist
     */
    ActiveAdvResponse getById(Long id) throws ItemNotFoundException;
}
