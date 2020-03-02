package tests;
import org.junit.Test;
import static org.junit.Assert.*;
import automobiles.*;
public class TestDecorator{
    @Test
    public void testAddonsPrice() {
        Economy cheap = new Economy();
        GPS addon1 = new GPS(cheap);
        Radio addon2 = new Radio(addon1);
        int cost = addon2.getCost();
        assertEquals(cost, 15000 + 1000 + 555);
    }
    @Test
    public void testAddonsDescription(){
        Economy cheap = new Economy();
        GPS addon1 = new GPS(cheap);
        Radio addon2 = new Radio(addon1);
        String text = addon2.getDescription();
        assertEquals(text,"Economy car + GPS + Radio");
    }
}
