package automobiles;
public class Radio extends Decorator{
    AbstractCar car;
    public Radio(AbstractCar car){
        this.car = car;
    }
    public String getPlate(){ return car.getPlate(); }
    public int getCost(){
        return car.getCost() + 555;
    }
    public String getDescription(){
        return car.getDescription() + " + Radio";
    }
}