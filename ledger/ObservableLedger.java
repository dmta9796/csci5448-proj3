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
    private int dayNumber;
    private int moneyMadeToday;
    private int moneyMade;
    private List<RentRecord> completedRentals;
    private List<AbstractCar> inventory;
    private List<RentRecord> rentalRecords;
    private List<Observer> observers;
    private boolean changed;

    public ObservableLedger(List<AbstractCar> allCars){
        observers = new ArrayList<Observer>();
        dayNumber = 0;
        inventory = allCars;
        rentalRecords = new ArrayList<RentRecord>();
        moneyMade = moneyMadeToday = 0;
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

    public void startDay(){
        returnRentals();
        dayNumber ++;
        notifyObservers();
        this.changed = false;
        updateRentals();
        this.changed = true;
        moneyMadeToday = 0;
    }

    public void finishDay(){
        moneyMade += moneyMadeToday;
    }

    public List<AbstractCar> processRentRequest(User customer, List<RentRequest> rentRequests){
        AbstractCar baseCar;
        AbstractCar decoratedCar;
        RentRecord record;
        List<AbstractCar> carsRented = new ArrayList<AbstractCar>();
        for(RentRequest req : rentRequests){
            if(inventory.size() > 0){

                //decorator pattern
                baseCar = decoratedCar = inventory.get(0);
                if(req.carSeats){decoratedCar = new ChildSeat(decoratedCar);}
                if(req.gps){decoratedCar = new GPS(decoratedCar);}
                if(req.satRadio){decoratedCar = new Radio(decoratedCar);}

                record = new RentRecord(customer, baseCar, decoratedCar, req.duration);
                rentalRecords.add(record);
                carsRented.add(decoratedCar);
                customer.addCurRentedCars(decoratedCar);
                customer.addCar();

                inventory.remove(baseCar);
                moneyMadeToday += decoratedCar.getCost();
            }
        }
        return carsRented;
    }

    public void updateRentals(){
        for(RentRecord rec : rentalRecords){
            if(rec.duration > 0){
                rec.duration --;
            }
        }
    }

    public void returnRentals(){
        for(RentRecord rec : rentalRecords){
            if(rec.duration == 0 && !rec.returned){
                rec.returnCar();
                rec.user.returnCar();
                if(!inventory.contains(rec.car)){
                    inventory.add(rec.car);
                }
            }
        }
    }

    public List<RentRecord> getRentalRecords(){
        return rentalRecords;
    }

    public List<AbstractCar> getInventory(){
        return inventory;
    }

    public int getDayNumber(){
        return dayNumber;
    }

    public int getMoneyMadeToday(){
        return moneyMadeToday;
    }
    public int getMoneyMade(){
        return moneyMade;
    }

}
