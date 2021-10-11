package track.individual.read4share.model;

import lombok.Getter;

@Getter
public class City {
    private String cityCode;
    private String name;

    public City(String cityCode, String name) {
        this.cityCode = cityCode;
        this.name = name;
    }
}
