package com.ga.food.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    public static final String RECIPE_EVENTS_TOPIC = "recipe-events";

    // On startup Spring creates this topic if it does not exist yet
    // (same as running kafka-topics.sh --create by hand).
    @Bean
    public NewTopic recipeEventsTopic() {
        return TopicBuilder.name(RECIPE_EVENTS_TOPIC)
                .partitions(3)   // 3 "lanes": up to 3 consumers of one group can work in parallel
                .replicas(1)     // 1 copy only, because our cluster has a single broker
                .build();
    }
}
