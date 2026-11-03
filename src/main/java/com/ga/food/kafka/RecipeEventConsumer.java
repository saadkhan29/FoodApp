package com.ga.food.kafka;

import com.ga.food.config.KafkaTopicConfig;
import com.ga.food.event.RecipeCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * CONSUMERS: each @KafkaListener is a worker that reads the topic.
 * Spring calls the method once for every new message.
 * Two DIFFERENT groupIds = two teams, and each team receives EVERY message.
 */
@Component
public class RecipeEventConsumer {

    @KafkaListener(topics = KafkaTopicConfig.RECIPE_EVENTS_TOPIC, groupId = "notification-service")
    public void sendNotification(RecipeCreatedEvent event,
                                 @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                                 @Header(KafkaHeaders.OFFSET) long offset) {
        System.out.println("NOTIFICATION: new recipe '" + event.name() + "' (id " + event.recipeId()
                + ") [partition " + partition + ", offset " + offset + "]");
    }

}
