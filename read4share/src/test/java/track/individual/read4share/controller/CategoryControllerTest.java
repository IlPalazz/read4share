package track.individual.read4share.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import track.individual.read4share.model.Category;
import track.individual.read4share.service.CategoryService;
import track.individual.read4share.service.CategoryServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static track.individual.read4share.controller.ResponseBodyMatcher.responseBody;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryControllerTest {

    private final String API_URL = "http://localhost:8080/api/cat";
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CategoryService categoryService;
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @DisplayName("It should return a successful response")
    public void successResponseTest() throws Exception {
        // ACT
        mvc.perform(get(API_URL + "/all")
                .contentType("application/json"))
                // ASSERT
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("It should return all the saved categories successfully")
    public void getAllCategorySuccessTest() throws Exception {
        // ARRANGE
        List<Category> mockList = new ArrayList<>();
        mockList.add(Category.builder().id(1L).name("Engineering").build());
        mockList.add(Category.builder().id(2L).name("Math").build());

        when(this.categoryService.getAll()).thenReturn(mockList);

        // ACT
        MvcResult mvcResult = mvc.perform(get(API_URL + "/all")
                .contentType("application/json"))
                .andReturn();

        // ASSERT
        String expectedResponseBody = objectMapper.writeValueAsString(mockList);
        String actualResponseBody = mvcResult.getResponse().getContentAsString();

        Assertions.assertThat(expectedResponseBody).isEqualTo(actualResponseBody);
        verify(categoryService, times(1)).getAll();

    }

}