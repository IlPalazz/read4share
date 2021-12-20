package track.individual.read4share.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.ResultMatcher;
import track.individual.read4share.dto.response.HttpMessageResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResponseBodyMatcher {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public <T> ResultMatcher containsObjectAsJson(
            Object expectedObject,
            Class<T> targetClass) {
        return mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            T actualObject = objectMapper.readValue(json, targetClass);
//            assertThat(actualObject).isEqualToComparingFieldByField(expectedObject);
            assertThat(actualObject).usingRecursiveComparison().isEqualTo(expectedObject);
        };
    }

    static ResponseBodyMatcher responseBody(){
        return new ResponseBodyMatcher();
    }
}
