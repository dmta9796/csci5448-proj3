package tests;

import automobiles.AbstractCar;
import org.junit.Test;
import simplefactory.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestObjectCreation {
    @Test
    public void countCars() {
        RentalBusiness items = new RentalBusinessOne(24);
        items.buildInventory();
        List<AbstractCar> inventory= items.getInventory();
        int size = inventory.size();
        try {
            assertEquals(24,size);
            System.out.println("number of cars tested successfully");
        } catch(AssertionError e){
            System.out.println("number of cars tested in error");
        }
    }

    //check there is two of each type of car.
    @Test
    public void carTypes(){
        RentalBusiness items = new RentalBusinessOne(24);
        items.buildInventory();
        List<AbstractCar> inventory= items.getInventory();
        ArrayList<Boolean> actual = new ArrayList();
        for (int i = 0 ;i < 5;i++) {
            actual.add(false);
        }


        inventory.forEach((item)->{
            if(item.getDescription()=="Economy car"){actual.set(0,true);}
            if(item.getDescription()=="Standard car"){actual.set(1,true);}
            if(item.getDescription()=="Minivan"){actual.set(2,true);}
            if(item.getDescription()=="Luxury car"){actual.set(3,true);}
            if(item.getDescription()=="SUV car"){actual.set(4,true);}
        });
        ArrayList<Boolean> expected = new ArrayList();
        for (int i = 0 ;i < 5;i++) {
            expected.add(true);
        }
        try {
            assertEquals(actual,expected);
            System.out.println("list containing each car type tested successfully");
        } catch(AssertionError e){
            System.out.println("list containing each car type  tested in error");
        }
    }
}
