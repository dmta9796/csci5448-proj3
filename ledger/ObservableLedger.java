package ledger;

import automobiles.AbstractCar;
import automobiles.ChildSeat;
import automobiles.GPS;
import automobiles.Radio;
import users.RentRequest;
import users.User;

import java.util.ArrayList;
import java.util.List;

public class ObservableLedger implements Observable{
    public int dayNumber;
    private int moneyMadeToday;
    private int moneyMade;
    private int carsRentedToday;
    private int carsRented;
    public List<AbstractCar> inventory;
    public List<User> usersRentedToday;
    public List<User> usersRentedCurrently;
    private List<Observer> observers;
    private boolean changed;

    public ObservableLedger(List<AbstractCar> allCars){
        observers = new ArrayList<Observer>();
        dayNumber = 1;
        inventory = allCars;
        usersRentedToday = new ArrayList<User>();
        usersRentedCurrently = new ArrayList<User>();
        moneyMade = moneyMadeToday = carsRentedToday = carsRented = 0;
    }
    public void registerObs(Observer obs){
        if(observers.contains(obs)){
            return;
        }
        else{
            observers.add(obs);
        }
    }
    public void unregisterObs(Observer obs){
        if(observers.contains(obs)){
            observers.remove(obs);
        }
    }
    public void notifyObservers(){
        if(!changed) {
            return;
        }
        for (Observer obs : observers){
            obs.update();
        }
    }

    public void finishDay(){
        moneyMade += moneyMadeToday;
        carsRented += carsRentedToday;
        this.changed = true;
        notifyObservers();

        usersRentedToday.clear();
        moneyMadeToday = 0;
        carsRentedToday = 0;
        dayNumber ++;
    }

    public List<AbstractCar> processRentRequest(User customer, List<RentRequest> rentRequests){
        AbstractCar baseCar;
        AbstractCar decoratedCar;
        String test;
        int price;
        List<AbstractCar> carsRented = new ArrayList<AbstractCar>();
        for(RentRequest req : rentRequests){
            if(inventory.size() > 0){

                //decorator pattern
                baseCar = decoratedCar = inventory.get(0);
                if(req.carSeats){decoratedCar = new ChildSeat(decoratedCar);}
                if(req.gps){decoratedCar = new GPS(decoratedCar);}
                if(req.satRadio){decoratedCar = new Radio(decoratedCar);}

                if(!usersRentedToday.contains(customer)){
                    usersRentedToday.add(customer);
                }
                if(!usersRentedCurrently.contains(customer)){
                    usersRentedCurrently.add(customer);
                }
                carsRented.add(decoratedCar);
                customer.addCurRentedCars(decoratedCar);

                inventory.remove(baseCar);
            }
        }
        return carsRented;
    }

}
