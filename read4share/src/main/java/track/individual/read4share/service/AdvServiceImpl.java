package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import track.individual.read4share.dto.Converter;
import track.individual.read4share.dto.response.AdvDetailsResponse;
import track.individual.read4share.exception.ItemNotFoundException;
import track.individual.read4share.model.Adv;
import track.individual.read4share.repository.AdvRepo;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdvServiceImpl implements AdvService {

    private final AdvRepo advRepo;
    private final Converter converter;

    @Override
    public AdvDetailsResponse getDetailsById(Long id) throws ItemNotFoundException {
        Optional<Adv> adv = this.advRepo.findById(id);
        if (adv.isEmpty())
            throw new ItemNotFoundException("Error: Adv with the given id does not exist!");
        return converter.toActiveAdvResponse(adv.get());
    }

    @Override
    public Adv getById(Long id) throws ItemNotFoundException {
        Optional<Adv> adv = this.advRepo.findById(id);
        if (adv.isEmpty())
            throw new ItemNotFoundException("Error: Adv with the given id does not exist!");
        return adv.get();    }
}
