package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class CatTest {

    @Test
    void testGetSound() {
        Feline feline = mock(Feline.class);
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFood() throws Exception {
        Feline feline = mock(Feline.class);
        List<String> foodList = List.of("Мясо", "Птица");
        Mockito.when(feline.eatMeat()).thenReturn(foodList);

        Cat cat = new Cat(feline);
        assertEquals(foodList, cat.getFood());
    }


}
