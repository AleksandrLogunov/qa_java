package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class LionTest {

    @Test
    void testLionThrowsExceptionOnInvalidSex() {
        Feline feline = mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Нечто", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    void testGetFoodFromPredator() throws Exception {
        Feline feline = mock(Feline.class);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо", "Рыба"));

        Lion lion = new Lion("Самец", feline);
        assertEquals(List.of("Мясо", "Рыба"), lion.getFood());
    }

    @Test
    void testGetKittensFromFeline() throws Exception {
        Feline feline = mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
    }

}
