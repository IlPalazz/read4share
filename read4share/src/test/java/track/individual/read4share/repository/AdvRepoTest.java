package track.individual.read4share.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdvRepoTest {
    
    @Autowired
    private AdvRepo advRepo;

    @Test
    public void getLatest() {
        
        List<Object[]> list = advRepo.findLatest(PageRequest.of(0, 10));
        System.out.println("list count = " + list.size());
    }

}