package track.individual.read4share.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import track.individual.read4share.dto.response.AdvOverviewResp;
import track.individual.read4share.model.Adv;
import track.individual.read4share.repository.AdvRepo;
import track.individual.read4share.repository.CategoryRepo;
import track.individual.read4share.utils.Converter;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class AdvServiceMockTest {

    // Mock creation
    @Mock
    private AdvRepo advRepo;
    @Mock
    private Converter converter;
    private AdvService advService;
    @Mock
    private CategoryService catService;


    @BeforeEach
    void initAdvService() {
        // Enable Mockito annotations
        MockitoAnnotations.initMocks(this);
        // Inject mock repository
        advService = new AdvServiceImpl(advRepo, converter, catService);
    }

    @Test
    @DisplayName("Should return the latest published advertisements")
    void getLatest() {

        // ARRANGE
        // Create a list of fake objects
        List<AdvOverviewResp> mockList = new ArrayList<>();
        mockList.add(AdvOverviewResp.builder().bookTitle("test_book1").build());
        mockList.add(AdvOverviewResp.builder().bookTitle("test_book2").build());

        // Mock the findLatest method
        when(advService.getLatest(2)).thenReturn(mockList);

        // ACT
        List<AdvOverviewResp> results = advService.getLatest(2);

        // ASSERT
        // Check the number of returned elements
        Assertions.assertThat(results.size()).isEqualTo(2);

        // Verify number of calls to the convert method
        verify(converter, times(1)).convert(anyListOf(Adv.class));
    }

}