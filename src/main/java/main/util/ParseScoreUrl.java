package main.util;

import main.dto.ScoreDto;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ParseScoreUrl {

    public Optional<ScoreDto> parseUrl(long id, String message) {
        if (message.contains("nytimes") && message.contains("t=")) {
            try {
                URIBuilder uriBuilder = new URIBuilder(message);
                Map<String, String> queryParams = uriBuilder.getQueryParams().stream().collect(Collectors.toMap(NameValuePair::getName, NameValuePair::getValue));

                ScoreDto scoreDto = new ScoreDto();
                scoreDto.setId(id);
                scoreDto.setDate(LocalDate.parse(queryParams.get("d")));
                scoreDto.setScore(Long.parseLong(queryParams.get("t")));

                return Optional.of(scoreDto);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        return Optional.empty();
    }

}
