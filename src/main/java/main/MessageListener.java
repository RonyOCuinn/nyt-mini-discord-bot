package main;

import main.dto.ScoreDto;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import main.util.ParseScoreUrl;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MessageListener extends ListenerAdapter {

    private final ParseScoreUrl parseScoreUrl;

    public MessageListener(ParseScoreUrl parseScoreUrl) {
        this.parseScoreUrl = parseScoreUrl;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Optional<ScoreDto> scoreDto = parseScoreUrl.parseUrl(event.getAuthor().getIdLong(), event.getMessage().getContentRaw());
//        scoreDto.ifPresent();
    }
}
