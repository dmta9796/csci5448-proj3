package users;
import java.util.List;
import automobiles.AbstractCar;
import java.util.ArrayList;
import java.util.Iterator;

public class User implements Subject{
    private String name = "";
    private BuyBehavior clienttype;
    private List<AbstractCar> curRentedCars;
    ArrayList<Observer> observerList;
    public User(){
        this.clienttype = new Casual();
    }
    public User(String name, BuyBehavior type){
        this.name = name;
        this.clienttype = type;
        curRentedCars = new ArrayList<AbstractCar>();
        observerList = new ArrayList<Observer>();
    }
    public String getname(){
        return this.name;
    }
    public void setname(String name){
        this.name = name;
    }

    public List<AbstractCar> getCurRented(){return curRentedCars;};

    public void addManyCars( List<AbstractCar> newRentals){
        for(int i = 0; i < newRentals.size();i++) {
            curRentedCars.add(newRentals.get(i));
            notifyObservers(true,newRentals.get(i));
        }
    };

    public void addOneCar(AbstractCar newRental){
        curRentedCars.add(newRental);
        notifyObservers(true,newRental);
    };
    public void returnCar(AbstractCar carToReturn){
        curRentedCars.remove(carToReturn);
        notifyObservers(false,carToReturn);

    };

    public void returnMultipleCars( List<AbstractCar> returns){
        for(int i = 0; i < returns.size();i++) {
            curRentedCars.remove(returns.get(i));
            notifyObservers(false,returns.get(i));
        }
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


}