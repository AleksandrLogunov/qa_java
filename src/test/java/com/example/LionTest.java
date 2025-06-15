package com.example;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class LionTest {

    @Test
    void testLionThrowsExceptionOnInvalidSex() {
        Predator predator = Mockito.mock(Predator.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Нечто", predator));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void testGetFoodFromPredator() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Mockito.when(predator.eatMeat()).thenReturn(List.of("Мясо", "Рыба"));

        Lion lion = new Lion("Самец", predator);
        assertEquals(List.of("Мясо", "Рыба"), lion.getFood());
    }

    @Test
    void testGetKittensFromFeline() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
    }

    @Test
    void testGetKittensFromNonFelinePredator() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Lion lion = new Lion("Самка", predator);
        assertEquals(0, lion.getKittens());
    }

}
