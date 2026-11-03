package com.ga.food.event;

/**
 * The "letter" we put into Kafka. It describes something that already happened,
 * so the name is in the past tense. A record is immutable, just like a Kafka message.
 */
public record RecipeCreatedEvent(Long recipeId, String name, Long categoryId) {
}
