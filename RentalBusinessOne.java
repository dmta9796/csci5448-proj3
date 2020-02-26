import automobiles.*;

public class RentalBusinessOne extends RentalBusiness{

    public RentalBusinessOne(int _inventorySize){
        super(_inventorySize);
    }

    protected AbstractCar createCar(String type){
        if(type.equals("Economy")){
            return new Economy();
        }
        if(type.equals("Standard")){
            return new Standard();
        }
        if(type.equals("Luxury")){
            return new Luxury();
        }
        if(type.equals("SUV")){
            return new SUV();
        }
        else{
            return new Minivan();
        }
    }

    protected void licenseCar(AbstractCar car){
        //will make this randomized without replacement
        car.plate = "LUX246";
    }
}
