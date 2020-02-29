import automobiles.*;
import users.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

//import java.lang.System;
public class Launch{
    public static AbstractCar car;
    public static String test;
    public static int price;
    public static final boolean debugMsgs = true;
    public static void main(String[] args) {
        List<User> regularCustomers = new ArrayList<User>();
        int inventorySize;
        User customer;
        List<RentRequest> rentRequests;

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
        car.plate = "LUX246";
        test = car.getDescription();
        price = car.getCost();
        System.out.println(test+":"+price);
        BuyBehavior casualBehavior = new Casual();
        BuyBehavior regularBehavior = new Regular();
        BuyBehavior businessBehavior = new Business();
        regularCustomers.add(new User("Jim", casualBehavior));
        regularCustomers.add(new User("Bob", casualBehavior));
        regularCustomers.add(new User("Sally", casualBehavior));
        regularCustomers.add(new User("Tod", casualBehavior));
        regularCustomers.add(new User("Liz", regularBehavior));
        regularCustomers.add(new User("Gary", regularBehavior));
        regularCustomers.add(new User("Sara", regularBehavior));
        regularCustomers.add(new User("Chris", regularBehavior));
        regularCustomers.add(new User("Jess", businessBehavior));
        regularCustomers.add(new User("Nick", businessBehavior));
        regularCustomers.add(new User("Schmidt", businessBehavior));
        regularCustomers.add(new User("Winston", businessBehavior));
        Ledger ledger = new Ledger(rentalBusiness.getInventory());
        for(User user: regularCustomers){
            user.registerObserver(ledger);
        }
        processCustomers processer = new processCustomers();
        for(int i=0;i<35;i++){
            inventorySize = rentalBusiness.getInventory().size();
            if(inventorySize > 0){
                //get random number of customers
                Random r = new Random();
                for(int j = 0; j<r.nextInt(regularCustomers.size()); j++){
                    customer = getRandomCustomer(regularCustomers);
                    if(customer.getType().equals("Business") && inventorySize < 3) {
                        continue;
                    }
                    rentRequests = customer.rentCarReq();
                    //process rent request
                    processer.processRentRequest(customer, rentRequests,rentalBusiness.getInventory());
                    //

                }
            }
            ledger.PrintActivity();
        }

    }
    public static User getRandomCustomer(List<User> regularCustomers){
        Random rand = new Random();
        return regularCustomers.get(rand.nextInt(regularCustomers.size()));
    }




}