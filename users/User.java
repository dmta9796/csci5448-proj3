package users;
import java.util.ArrayList;
import java.util.List;
import automobiles.AbstractCar;

public class User{
    private String name = "";
    private BuyBehavior buyBehavior;
    private List<AbstractCar> curRentedCars;
    public User(String name, BuyBehavior type){
        this.name = name;
        this.buyBehavior = type;
        curRentedCars = new ArrayList<AbstractCar>();
    }
    public String getName(){
        return this.name;
    }
    public String getType() { return buyBehavior.type(); }

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