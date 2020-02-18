package automobiles;
public class Radio extends Decorator{
    AbstractCar car;
    public Radio(AbstractCar car){
        this.car = car;
    }
    public int getCost(){
        int cost = car.getCost() + 555;
        return cost;
    }
    public String getDescription(){
        return car.getDescription() + " + Radio";
    }
}