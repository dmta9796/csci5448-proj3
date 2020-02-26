import automobiles.*;
import java.util.*;

public abstract class RentalBusiness {
    protected abstract AbstractCar createCar(String type);
    protected abstract void licenseCar(AbstractCar car);
    private int inventorySize;
    List<AbstractCar> inventory;

    public RentalBusiness(int _inventorySize){
        inventorySize = _inventorySize;
        inventory = new ArrayList<AbstractCar>();
    }

    public void buildInventory(){
        for(int i = 0; i < 5; i++){
            inventory.add(orderCar("Economy"));
        }
        for(int i = 0; i < 5; i++){
            inventory.add(orderCar("Standard"));
        }
        for(int i = 0; i < 5; i++){
            inventory.add(orderCar("Luxury"));
        }
        for(int i = 0; i < 5; i++){
            inventory.add(orderCar("SUV"));
        }
        for(int i = 0; i < 4; i++){
            inventory.add(orderCar("Minivan"));
        }
    }

    public AbstractCar orderCar(String type){
        AbstractCar car = createCar(type);
        licenseCar(car);
        return car;
    }

}
