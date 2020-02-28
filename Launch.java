import automobiles.*;
import ledger.Ledger;
import ledger.LedgerObserver;
import ledger.ObservableLedger;
import ledger.Observer;
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
        ListIterator<AbstractCar> iterator = rentalBusiness.getInventory().listIterator();
        while(iterator.hasNext()){
            AbstractCar car = iterator.next();
            if(debugMsgs) {
                System.out.println(car.getDescription() + " with license: " + car.getPlate());
            }
        }

        Ledger ledger = new Ledger(rentalBusiness.getInventory());
        //ledger.PrintActivity();

        ObservableLedger obsLedger = new ObservableLedger(rentalBusiness.getInventory());
        Observer obs = new LedgerObserver(obsLedger);
        obsLedger.registerObs(obs);

        //Using strategy to create regular customers
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

        //customers rent for up to 7 nights
        //12 reg customers. casual 1-3 nights, business 3 for 7 nights, reg 1-3 cars for 3-5 nights
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
                    obsLedger.processRentRequest(customer, rentRequests);
                }
            }
            obsLedger.finishDay();
        }
    }

    public static User getRandomCustomer(List<User> regularCustomers){
        Random rand = new Random();
        return regularCustomers.get(rand.nextInt(regularCustomers.size()));
    }

}