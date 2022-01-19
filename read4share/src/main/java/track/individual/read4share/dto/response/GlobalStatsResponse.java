package track.individual.read4share.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GlobalStatsResponse {
    private int activeAdvs;
    private int lastMonthAdvs;
    private int totalUsers;
    private double userAverageAdv;
    private int totalChats;
}
