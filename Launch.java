import automobiles.*;
import users.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

//import java.lang.System;
public class Launch{
    public static AbstractCar car;
    public static String test;
    public static int price;
    public static final boolean debugMsgs = true;
    public static void main(String[] args) {
        //Factory to create inventory of cars
        RentalBusiness rentalBusiness = new RentalBusinessOne(24);
        rentalBusiness.buildInventory();

        //Using iterator explicitly over for loop interface for iterators
        ListIterator<AbstractCar> iterator = rentalBusiness.inventory.listIterator();
        while(iterator.hasNext()){
            AbstractCar car = iterator.next();
            if(debugMsgs) {
                System.out.println(car.getDescription() + " with license: " + car.plate);
            }
        }


        car = new Economy();
        car = new GPS(car);
        car = new ChildSeat(car);
        test = car.getDescription();
        price = car.getCost();
        System.out.println(test+":"+price);
        User will = new User("Will" , null);
        System.out.println("a");
        Ledger ledger = new Ledger(rentalBusiness.getInventory());
        System.out.println("b");
        will.registerObserver(ledger);
        System.out.println("c");
        will.addOneCar(car);
        ledger.PrintActivity();
    }
}