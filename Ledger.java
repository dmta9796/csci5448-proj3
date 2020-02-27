import automobiles.AbstractCar;
import users.User;

import java.util.ArrayList;
import java.util.List;

public class Ledger {
    private int dayNumber;
    private int moneyMadeToday;
    private int moneyMade;
    private int countOfCarsRentedToday;
    private int countCarsRented;
    private List<AbstractCar> inventory;
    private List<User> usersRentedToday;
    private List<AbstractCar> carsRentedToday;
    private List<User> usersRentedCurrently;


    Ledger(List<AbstractCar> allCars){
        dayNumber = 1;
        inventory = allCars;
        usersRentedToday = new ArrayList<User>();
        usersRentedCurrently = new ArrayList<User>();
        moneyMade = moneyMadeToday = countOfCarsRentedToday = countCarsRented = 0;

    }

    public void PrintActivity(){
        System.out.println("Today's day number is: " + dayNumber);
        System.out.println("Rentals Done today");
        if(usersRentedToday != null){
            //need to check to see if a car was rented today for the users
            System.out.println(countCarsRented + " cars rented today");
            for(int i = 0; i < usersRentedToday.size();i++){
                List<AbstractCar> curUserCarsRented = usersRentedToday.get(i).getCurRented();
                System.out.println(usersRentedToday.get(i).getname() + " has rented the following car/s");
                for(int j = 0; j < curUserCarsRented.size();j++){
                    System.out.println(curUserCarsRented.get(j).getDescription() + " with license plate " + curUserCarsRented.get(j).getPlate());
                }
            }
        }else{
            System.out.println("None");
        }
        System.out.println("Rentals currently active");
        if(usersRentedCurrently!= null){
            for(int i = 0; i < usersRentedCurrently.size();i++){
                List<AbstractCar> curUserCarsRented = usersRentedToday.get(i).getCurRented();
                System.out.println(usersRentedToday.get(i).getname() + " has rented the following car/s");
                for(int j = 0; j < curUserCarsRented.size();j++){
                    System.out.println(curUserCarsRented.get(j).getDescription() + " with license plate " + curUserCarsRented.get(j).getPlate());
                }
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

        System.out.println("The store made " + moneyMadeToday + " today");
        dayNumber = dayNumber + 1;


    }
}
