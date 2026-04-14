package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTest {

    private final String animalKind;
    private final java.util.List<String> expectedFood;

    public AnimalTest(String animalKind, java.util.List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Parameterized.Parameters
    public static Object[][] getFoodData() {
        return new Object[][] {

                {"Травоядное", java.util.List.of("Трава", "Различные растения")},
                {"Хищник", java.util.List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Test
    public void getFoodReturnsCorrectList() throws Exception {
        Animal animal = new Animal();
        assertEquals(expectedFood, animal.getFood(animalKind));
    }

    @Test(expected = Exception.class)
    public void getFoodThrowsExceptionForUnknownAnimal() throws Exception {
        Animal animal = new Animal();
        animal.getFood("НеизвестноеСущество");
    }

    @Test
    public void getFamilyReturnsCorrectString() {
        Animal animal = new Animal();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }
}