import automobiles.*;
//import java.lang.System;
public class Launch{
    public static AbstractCar car;
    public static String test;
    public static int price;
    public static void main(String[] args) {
        car = new Economy();
        car = new GPS(car);
        car = new ChildSeat(car);
        test = car.getDescription();
        price = car.getCost();
        System.out.println(test+":"+price);
    }
}