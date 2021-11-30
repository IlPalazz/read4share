package track.individual.read4share.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import track.individual.read4share.model.response.AdvOverview;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@Slf4j
public class QueryMapper {


    /**
     * Parse the custom query to a List of AdvOverview
     * @param records Result of the query
     * @return List of AdvOverview
     */
    public static List<AdvOverview> parseToAdvOverview(List<Object[]> records) {
        List<AdvOverview> advs = new ArrayList<>();
        for (Object[] record : records) {
            advs.add(
                    AdvOverview.builder()
                            .bookTitle(String.valueOf(record[0]))
                            .bookAuthor(String.valueOf(record[1]))
                            .sellerUsername(String.valueOf(record[2]))
                            .advLocation(String.valueOf(record[3]))
                            .advPrice(Double.parseDouble(String.valueOf(record[4])))
                            .bookCoverUrl(String.valueOf(record[5]))
                            .build()
            );
        }
        return advs;
    }

}
