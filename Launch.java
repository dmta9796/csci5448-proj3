import automobiles.*;
//import java.lang.System;
public class Launch{
    public static AbstractCar car;
    public static String test;
    public static void main(String[] args) {
        car = new Economy();
        car = new GPS(car);
        test = car.getDescription();
        System.out.println(test);
    }
}