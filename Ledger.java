import automobiles.AbstractCar;
import users.User;

import java.util.List;

public class Ledger {
    private int dayNumber;
    private List<AbstractCar> inventory;
    private List<User> usersRentedToday;
    private List<User> usersRentedCurrently;


    Ledger(List<AbstractCar> allCars){
        dayNumber = 1;
        inventory = allCars;
        usersRentedToday = null;
        usersRentedCurrently = null;
    }

    public void PrintActivity(){
        System.out.println("Today's day number is: " + dayNumber);
        System.out.println("Rentals Done today");
        if(usersRentedToday!= null){
            for(int i = 0; i < usersRentedToday.size();i++){
                System.out.println("Rentals today");
            }
        }else{
            System.out.println("None");
        }
        System.out.println("Rentals currently active");
        if(usersRentedCurrently!= null){
            for(int i = 0; i < usersRentedCurrently.size();i++){
                System.out.println("Rentals Currently");
            }
        }else{
            System.out.println("None");
        }
        System.out.println("Cars in inventory");
        if(inventory!= null){
            for(int i = 0; i < inventory.size();i++){
                System.out.println(inventory.get(i).getDescription() + " with license plate " + inventory.get(i).getPlate());
            }
        }else{
            System.out.println("None");
        }


    }
}
