package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlexTest {

    @Test
    void testAlexHasNoKittens() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Alex alex = new Alex(predator);
        assertEquals(0, alex.getKittens());
    }

    @Test
    void testAlexHasCorrectFriends() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Alex alex = new Alex(predator);
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    void testAlexLivesInZoo() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Alex alex = new Alex(predator);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void testAlexDoesHaveMane() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Alex alex = new Alex(predator);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    void testAlexCanGetFoodFromPredator() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Mockito.when(predator.eatMeat()).thenReturn(List.of("Стейк", "Курица"));
        Alex alex = new Alex(predator);
        assertEquals(List.of("Стейк", "Курица"), alex.getFood());
    }
}
