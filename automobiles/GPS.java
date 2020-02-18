package automobiles;
public class GPS extends Decorator{
    AbstractCar car;
    public GPS(AbstractCar car){
        this.car = car;
    }
    public int getCost(){
        int cost = car.getCost() + 1000;
        return cost;
    }
    public String getDescription(){
        return car.getDescription() + " + GPS";
    }
}