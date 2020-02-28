package automobiles;
public class ChildSeat extends Decorator{
    AbstractCar car;
    public ChildSeat(AbstractCar car){
        this.car = car;
    }
    public String getPlate(){ return car.getPlate(); }
    public int getCost(){
        return car.getCost() + 111;
    }
    public String getDescription(){
        return car.getDescription() + " + Child seat";
    }
}