package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import track.individual.read4share.dto.AdvOverviewDTO;
import track.individual.read4share.repository.AdvRepo;
import track.individual.read4share.utils.Config;
import track.individual.read4share.utils.Converter;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvServiceImpl implements AdvService {

    private final AdvRepo advRepo;
    private final Converter converter;

    @Override
    public List<AdvOverviewDTO> getLatest(int size) {
        return converter.convert(advRepo.findLatest(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewDTO> getBestRating(int size) {
        return converter.convert(advRepo.findBestRating(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewDTO> getFree(int size) {
        return converter.convert(advRepo.findFree(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewDTO> getFreeDel(int size) {
        return converter.convert(advRepo.findFreeDel(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewDTO> getAsNew(int size) {
        return converter.convert(advRepo.findAsNew(
                PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverviewDTO> getByCategoryId(Long id, int page, int size) {
        return null; // TODO: Implement method
    }

    /**
     * Check whether the size parameter respects the maximum allowed
     * @param size Value to be validated
     * @return Validated int value
     */
    private int validateRecordsNumber(int size) {
        return Math.min(size, Config.maxRecordsAdvOverview);
    }
}
