package users;
import java.util.List;
import automobiles.AbstractCar;

public class User{
    private String name = "";
    private BuyBehavior clienttype;
    private List<AbstractCar> curRentedCars;
    public User(){
        this.clienttype = new Casual();
    }
    public User(String name, BuyBehavior type){
        this.name = name;
        this.clienttype = type;
        curRentedCars = null;
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
        }
    };

    public void addOneCar(AbstractCar newRental){curRentedCars.add(newRental);};
    public void returnCar(AbstractCar carToReturn){curRentedCars.remove(carToReturn);};

    public void returnMultipleCars( List<AbstractCar> newRentals){
        for(int i = 0; i < newRentals.size();i++) {
            curRentedCars.remove(newRentals.get(i));
        }
    };

}