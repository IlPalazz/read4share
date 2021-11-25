package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import track.individual.read4share.model.response.AdvOverview;
import track.individual.read4share.repository.AdvRepo;
import track.individual.read4share.config.GlobalConstants;
import track.individual.read4share.utils.QueryMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvServiceImpl implements AdvService {

    private final AdvRepo advRepo;

    @Override
    public List<AdvOverview> getLatest(int size) {
        return QueryMapper.parseToAdvOverview(advRepo.findLatest(PageRequest.of(
                0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverview> getBestRating(int size) {
        return QueryMapper.parseToAdvOverview(advRepo.findBestRating(PageRequest.of(
                0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverview> getFree(int size) {
        return QueryMapper.parseToAdvOverview(advRepo.findFree(PageRequest.of(
                0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverview> getFreeDel(int size) {
        return QueryMapper.parseToAdvOverview(advRepo.findFreeDel(PageRequest.of(
                0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverview> getAsNew(int size) {
        return QueryMapper.parseToAdvOverview(advRepo.findAsNew(PageRequest.of(
                0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverview> getByCategoryId(Long id, int page, int size) {
        return null; // TODO: Implement method
    }

    /**
     * Check whether the size parameter respects the maximum allowed
     * @param size Value to be validated
     * @return Validated int value
     */
    private int validateRecordsNumber(int size) {
        return Math.min(size, GlobalConstants.maxRecordsAdvOverview);
    }
}
