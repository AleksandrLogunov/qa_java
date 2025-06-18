package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class AlexTest {

    @Test
    void testAlexHasNoKittens() throws Exception {
        Feline feline = mock(Feline.class);
        Alex alex = new Alex(feline);
        assertEquals(0, alex.getKittens());
    }

    @Test
    void testAlexHasCorrectFriends() throws Exception {
        Feline feline = mock(Feline.class);
        Alex alex = new Alex(feline);
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    void testAlexLivesInZoo() throws Exception {
        Feline feline = mock(Feline.class);
        Alex alex = new Alex(feline);
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void testAlexDoesHaveMane() throws Exception {
        Feline feline = mock(Feline.class);
        Alex alex = new Alex(feline);
        assertTrue(alex.doesHaveMane());
    }

    @Test
    void testAlexCanGetFoodFromPredator() throws Exception {
        Feline feline = mock(Feline.class);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Стейк", "Курица"));
        Alex alex = new Alex(feline);
        assertEquals(List.of("Стейк", "Курица"), alex.getFood());
    }
}
