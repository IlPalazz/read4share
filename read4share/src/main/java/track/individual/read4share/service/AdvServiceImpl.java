package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import track.individual.read4share.model.Advertisement;
import track.individual.read4share.repository.AdvRepo;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdvServiceImpl implements AdvService {

    private final AdvRepo advRepo;

    @Override
    public List<Advertisement> getLatest() {
        List<Advertisement> temp = advRepo.findAll();
        return temp;
    }

    @Override
    public List<Advertisement> getBestRating() {
        return null;
    }

    @Override
    public List<Advertisement> getFree() {
        return null;
    }

    @Override
    public List<Advertisement> getFreeDel() {
        return null;
    }

    @Override
    public List<Advertisement> getAsNew() {
        return null;
    }

    @Override
    public List<Advertisement> getByCategoryId(Long id) {
        return null;
    }
}
