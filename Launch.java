import automobiles.*;
import ledger.*;
import users.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.lang.System;

public class Launch{
    public static AbstractCar car;
    public static String test;
    public static int price;
    public static final boolean debugMsgs = false;

    public static void main(String[] args) {
        List<User> regularCustomers = new ArrayList<User>();
        int inventorySize;
        User customer;
        List<RentRequest> rentRequests;
        int simDays;
        int casRentals = 0, busRentals = 0, regRentals = 0;

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

        //Observers and observable object creation. The observable ledger is responsable for all accounting and records
        ObservableLedger obsLedger = new ObservableLedger(rentalBusiness.getInventory());
        Observer obs = new LedgerObserver(obsLedger);
        obsLedger.registerObs(obs);

        //Using strategy to create regular customers rental behaviors
        BuyBehavior casualBehavior = new Casual();
        BuyBehavior regularBehavior = new Regular();
        BuyBehavior businessBehavior = new Business();
        regularCustomers.add(new User("Jimmy", casualBehavior));
        regularCustomers.add(new User("Creed", casualBehavior));
        regularCustomers.add(new User("Kevin", casualBehavior));
        regularCustomers.add(new User("Toby", casualBehavior));
        regularCustomers.add(new User("Micheal", regularBehavior));
        regularCustomers.add(new User("Pamela", regularBehavior));
        regularCustomers.add(new User("Sara", regularBehavior));
        regularCustomers.add(new User("Chris", regularBehavior));
        regularCustomers.add(new User("Jess", businessBehavior));
        regularCustomers.add(new User("Nick", businessBehavior));
        regularCustomers.add(new User("Schmidt", businessBehavior));
        regularCustomers.add(new User("Winston", businessBehavior));

        //simulation execution
        simDays = 35;
        for(int i=0;i<simDays;i++){
            obsLedger.startDay();
            inventorySize = rentalBusiness.getInventory().size();
            if(inventorySize > 0){
                //get random number of customers for the day
                Random r = new Random();
                for(int j = 0; j<r.nextInt(regularCustomers.size()); j++){
                    customer = getRandomCustomer(regularCustomers);
                    if((customer.getType().equals("Business") && inventorySize < 3) || customer.getNumCars() >= 3 ) {
                        continue;
                    }
                    rentRequests = customer.rentCarReq();
                    obsLedger.processRentRequest(customer, rentRequests);
                }
            }
            obsLedger.finishDay();
        }

        //Final tally of money and rentals from simulation
        System.out.println("Simulation Over");
        for(RentRecord rec : obsLedger.getRentalRecords()){
            switch (rec.user.getType()) {
                case "Casual":
                    casRentals++;
                    break;
                case "Business":
                    busRentals++;
                    break;
                case "Regular":
                    regRentals++;
                    break;
            }
        }
        System.out.println("TOTAL RENTALS: " + obsLedger.getRentalRecords().size());
        System.out.println("\t" + casRentals + " By Casual Customers");
        System.out.println("\t" + busRentals + " By Business Customers");
        System.out.println("\t" + regRentals + " By Regular Customers");
        System.out.println("TOTAL MONEY MADE: $" + obsLedger.getMoneyMade());

    }

    public static User getRandomCustomer(List<User> regularCustomers){
        Random rand = new Random();
        return regularCustomers.get(rand.nextInt(regularCustomers.size()));
    }

}