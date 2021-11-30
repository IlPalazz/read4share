package track.individual.read4share.service;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import track.individual.read4share.model.Advertisement;
import track.individual.read4share.model.response.AdvOverview;
import track.individual.read4share.repository.AdvRepo;
import track.individual.read4share.utils.QueryMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

//@ExtendWith(MockitoExtension.class)
public class AdvServiceImplTest {

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
        List<Object[]> mockList = new ArrayList<>();
        Object[] arr1 = {"adv1", "Amsterdam"};
        Object[] arr2 = {"adv2", "Rotterdam"};
        mockList.add(arr1);
        mockList.add(arr2);

        // Mock the findLatest method
        when(advRepo.findLatest(PageRequest.of(0,2))).thenReturn(mockList);

        List<Object[]> objArray = advRepo.findLatest(PageRequest.of(0,2));

        // Check the number of returned elements
        Assertions.assertThat(objArray.size()).isEqualTo(2);

        // Verify number of calls
        verify(advRepo, times(1)).findLatest(PageRequest.of(0,2));
    }

}