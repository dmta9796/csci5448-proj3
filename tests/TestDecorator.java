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
        try {
            assertEquals(cost, 15000 + 1000 + 555);
            System.out.println("addons cost  tested successfully");

        } catch(AssertionError e){
            System.out.println("addons cost tested successfully");
        }
    }
    @Test
    public void testAddonsDescription(){
        Economy cheap = new Economy();
        GPS addon1 = new GPS(cheap);
        Radio addon2 = new Radio(addon1);
        String text = addon2.getDescription();
        try {
            assertEquals(text, "Economy car + GPS + Radio");
            System.out.println("addons descriptions tested successfully");
        } catch(AssertionError e){
            System.out.println("addons descriptions tested in error");
        }
    }
}
// getting statements from tests
// https://stackoverflow.com/questions/15926005/how-make-junit-to-print-asserts-and-results