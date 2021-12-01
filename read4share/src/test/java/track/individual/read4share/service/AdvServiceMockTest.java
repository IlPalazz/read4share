package track.individual.read4share.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageRequest;
import track.individual.read4share.model.Adv;
import track.individual.read4share.repository.AdvRepo;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class AdvServiceMockTest {

    // Mock creation
    @Mock
    private AdvRepo advRepo;
    private AdvService advService;


    @BeforeEach
    void initAdvService() {
        // Enable Mockito annotations
        MockitoAnnotations.initMocks(this);
        // Inject mock repository
        advService = new AdvServiceImpl(advRepo);
    }

    @Test
    @DisplayName("Should return the latest published advertisements")
    void getLatest() {

        // Create a list of fake objects
        List<Adv> mockList = new ArrayList<>();
        mockList.add(new Adv());
        mockList.add(new Adv());

        // Mock the findLatest method
        when(advRepo.findLatest(PageRequest.of(0,2))).thenReturn(mockList);

        List<Adv> results = advRepo.findLatest(PageRequest.of(0,2));

        // Check the number of returned elements
        Assertions.assertThat(results.size()).isEqualTo(2);

        // Verify number of calls
        verify(advRepo, times(1)).findLatest(PageRequest.of(0,2));
    }

}