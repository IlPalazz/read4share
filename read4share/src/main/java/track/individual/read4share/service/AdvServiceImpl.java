package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import track.individual.read4share.model.response.AdvOverview;
import track.individual.read4share.repository.AdvRepo;
import track.individual.read4share.utils.Config;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvServiceImpl implements AdvService {

    private final AdvRepo advRepo;

    @Override
    public List<AdvOverview> getLatest(int size) {
        return this.fromObjToAdvOverview(
                advRepo.findLatest(
                        PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverview> getBestRating(int size) {
        return this.fromObjToAdvOverview(
                advRepo.findBestRating(
                        PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverview> getFree(int size) {
        return this.fromObjToAdvOverview(
                advRepo.findFree(
                        PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverview> getFreeDel(int size) {
        return this.fromObjToAdvOverview(
                advRepo.findFreeDel(
                        PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverview> getAsNew(int size) {
        return this.fromObjToAdvOverview(
                advRepo.findAsNew(
                        PageRequest.of(0, this.validateRecordsNumber(size))));
    }

    @Override
    public List<AdvOverview> getByCategoryId(Long id, int page, int size) {
        return null; // TODO: Implement method
    }

    private List<AdvOverview> fromObjToAdvOverview(List<Object[]> records) {

        List<AdvOverview> advs = new ArrayList<AdvOverview>();
        for (Object[] record : records) {
            advs.add(
                    AdvOverview.builder()
                            .bookTitle(String.valueOf(record[0]))
                            .bookAuthor(String.valueOf(record[1]))
                            .sellerUsername(String.valueOf(record[2]))
                            .advLocation(String.valueOf(record[3]))
                            .advPrice(Double.parseDouble(String.valueOf(record[4])))
                            .build()
            );
        }
        return advs;
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
