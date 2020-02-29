package users;
import java.util.List;
import automobiles.AbstractCar;
import java.util.ArrayList;
import java.util.Iterator;

public class User implements Subject{
    private String name = "";
    private BuyBehavior buyBehavior;
    private List<AbstractCar> curRentedCars;

    ArrayList<Observer> observerList;
    public User(){
        this.buyBehavior = new Casual();
    }
    public User(String name, BuyBehavior type){
        this.name = name;
        this.buyBehavior = type;
        curRentedCars = new ArrayList<AbstractCar>();
        observerList = new ArrayList<Observer>();

    }
    public String getname(){
        return this.name;
    };
    public void setname(String name){
        this.name = name;
    };
    public String getType() { return buyBehavior.type(); }
    public List<AbstractCar> getCurRented(){return curRentedCars;};


    public void addOneCar(AbstractCar newRental, int daysOfRental){
        newRental.setDaysToBeRented(daysOfRental);
        curRentedCars.add(newRental);
        notifyObservers(true,newRental);

    };
    public void returnCar(AbstractCar carToReturn){

        curRentedCars.remove(carToReturn);
        notifyObservers(false,carToReturn);

    };




    //observer override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }


    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }

    public void notifyObservers(boolean newRental,AbstractCar car){
        for (Iterator<Observer> it =
             observerList.iterator(); it.hasNext();)
        {
            Observer o = it.next();
            o.update(newRental, car, this);
        }
    }
    public List<RentRequest> rentCarReq(){
        return buyBehavior.createRentReq();
    }


}