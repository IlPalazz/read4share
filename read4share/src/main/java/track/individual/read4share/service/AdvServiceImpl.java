package track.individual.read4share.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import track.individual.read4share.model.response.AdvOverview;
import track.individual.read4share.repository.AdvRepo;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdvServiceImpl implements AdvService {

    private final AdvRepo advRepo;

    @Override
    public List<AdvOverview> getLatest() {
        return this.fromObjToAdvOverview(advRepo.findLatest());
    }

    @Override
    public List<AdvOverview> getBestRating() {
        return null;
    }

    @Override
    public List<AdvOverview> getFree() {
        return null;
    }

    @Override
    public List<AdvOverview> getFreeDel() {
        return null;
    }

    @Override
    public List<AdvOverview> getAsNew() {
        return null;
    }

    @Override
    public List<AdvOverview> getByCategoryId(Long id) {
        return null;
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
}
