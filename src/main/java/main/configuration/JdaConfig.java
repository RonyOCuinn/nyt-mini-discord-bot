package main.configuration;

import main.MessageListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JdaConfig {

    final MessageListener messageListener;

    public JdaConfig(MessageListener messageListener) {
        this.messageListener = messageListener;
    }

    @Bean
    public JDA jda() {
        JDA jda = JDABuilder.createDefault("token")
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
        jda.addEventListener(messageListener);
        return jda;
    }
}
