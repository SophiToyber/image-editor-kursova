package io.ibot.image.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ImageBotStoreConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
