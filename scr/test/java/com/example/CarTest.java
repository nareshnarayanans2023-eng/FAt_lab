package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void testInheritance() {
        Car myCar = new Car();
        assertEquals("Tuut, tuut!", myCar.honk());
        assertEquals("Ford Mustang", myCar.getFullName());
    }
}
