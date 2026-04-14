package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensReturnsOne() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);

        Lion lion = new Lion("Самец", feline);
        int actualKittens = lion.getKittens();

        assertEquals(1, actualKittens);
    }

    @Test
    public void getFoodReturnsPredatorFoodList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", feline);
        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test(expected = Exception.class)
    public void constructorThrowsExceptionOnInvalidSex() throws Exception {
        new Lion("Неизвестно", feline);
    }
}