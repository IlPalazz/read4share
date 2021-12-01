package track.individual.read4share.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import track.individual.read4share.dto.response.AdvOverviewResp;
import track.individual.read4share.model.Adv;
import track.individual.read4share.model.Book;
import track.individual.read4share.model.City;
import track.individual.read4share.model.User;

import java.time.LocalDateTime;
import java.util.List;

class ConverterTest {

    private Converter converter;

    @BeforeEach
    void init() {
        // Enable Mockito annotations
        MockitoAnnotations.initMocks(this);
        converter = new ConverterImpl();
    }

    @Test
    @DisplayName("Should successfully convert a List of Adv into a List of AdvOverviewDTO")
    void convertSucc() {
        // ARRANGE
        // List of fake advertisements
        List<Adv> advList = List.of(
                Adv.builder()
                        .price(27.5).publDate(LocalDateTime.now())
                        .city(City.builder().name("Eindhoven").build())
                        .book(Book.builder().title("book1").author("author1").coverUrl("").build())
                        .seller(User.builder().username("Test_user1").build())
                        .build(),
                Adv.builder().price(32).publDate(LocalDateTime.now())
                        .city(City.builder().name("Eindhoven").build())
                        .book(Book.builder().title("book2").author("author2").coverUrl("").build())
                        .seller(User.builder().username("Test_user2").build())
                        .build()
        );

        // ACT
        List<AdvOverviewResp> advDTOList = converter.convert(advList);

        // ASSERT
        Assertions.assertThat(advDTOList.size()).isEqualTo(2);
        Assertions.assertThat(advDTOList.get(0).getBookTitle()).isEqualTo("book1");
        Assertions.assertThat(advDTOList.get(1).getBookTitle()).isEqualTo("book2");
    }

    @Test()
    @DisplayName("Should throw an Exception during the conversion")
    void convertFail() {
        // ARRANGE
        // List of fake advertisements
        List<Adv> advList = List.of(new Adv(), new Adv());

        // ASSERT
        Assertions.assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> {
                    // ACT
                    List<AdvOverviewResp> advDTOList = converter.convert(advList);
        });
    }
}