import automobiles.*;
import java.util.Random;

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
        String license = "";
        //https://stackoverflow.com/questions/2626835/is-there-functionality-to-generate-a-random-character-in-java
        for(int i=0;i<3;i++){
            Random r = new Random();
            char c = (char)(r.nextInt(26) + 'a');
            license += c;
        }
        for(int i=0;i<3;i++){
            Random r = new Random();
            int n = (r.nextInt(9));
            license += Integer.toString(n);
        }
        //make sure license isn't already in use
        if(!licenses.contains(license)){
            licenses.add(license);
            car.setPlate(license);
        } else{
            licenseCar(car);
        }
    }


}
