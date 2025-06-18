package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class LionParameterizedTest {
    @ParameterizedTest
    @CsvSource({
            "Самец,true",
            "Самка,false"
    })
    void lionHasCorrectManeBySex(String sex, boolean expected) throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion(sex, feline);
        assertEquals(expected, lion.doesHaveMane());
    }
}
