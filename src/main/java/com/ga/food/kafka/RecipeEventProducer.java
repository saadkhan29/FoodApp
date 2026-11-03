package com.ga.food.kafka;

import com.ga.food.config.KafkaTopicConfig;
import com.ga.food.event.RecipeCreatedEvent;
import com.ga.food.model.Recipe;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/** PRODUCER: writes events to Kafka. It does not know who will read them. */
@Service
@AllArgsConstructor
public class RecipeEventProducer {

    // KafkaTemplate = Spring's helper for sending messages (<key type, value type>)
    @Autowired
    private final KafkaTemplate<String, RecipeCreatedEvent> kafkaTemplate;

    public void sendRecipeCreated(Long categoryId, Recipe recipe) {
        RecipeCreatedEvent event =
                new RecipeCreatedEvent(recipe.getId(), recipe.getName(), categoryId);

        // The key decides the partition: same category -> same partition -> order is kept.
        String key = String.valueOf(categoryId);

        kafkaTemplate.send(KafkaTopicConfig.RECIPE_EVENTS_TOPIC, key, event)
                .whenComplete((result, error) -> {
                    if (error != null) {
                        System.out.println("PRODUCER: failed to send => " + error.getMessage());
                    } else {
                        System.out.println("PRODUCER: sent " + event
                                + " to partition " + result.getRecordMetadata().partition()
                                + ", offset " + result.getRecordMetadata().offset());
                    }
                });
    }
}
