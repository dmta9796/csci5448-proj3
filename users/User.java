package users;
import java.util.ArrayList;
import java.util.List;
import automobiles.AbstractCar;

public class User{
    protected String name = "";
    private BuyBehavior buyBehavior;
    private List<AbstractCar> curRentedCars;
    private int numRentals;
    public User(String _name, BuyBehavior type){
        name = _name;
        buyBehavior = type;
        curRentedCars = new ArrayList<AbstractCar>();
        numRentals = 0;
    }
    public String getName(){
        return name;
    }
    public String getType() { return buyBehavior.type(); }
    public int getNumCars() { return numRentals; }
    public void addCar() { numRentals++; }
    public void returnCar() { numRentals--; }

    public void setName(String name){
        this.name = name;
    }

    public List<AbstractCar> getCurRented(){return curRentedCars;};
    public void addCurRentedCars(AbstractCar car){
        curRentedCars.add(car);
    };

    public List<RentRequest> rentCarReq(){
        return buyBehavior.createRentReq();
    }

}