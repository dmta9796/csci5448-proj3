import automobiles.AbstractCar;
import users.Observer;
import users.User;

import java.util.ArrayList;
import java.util.List;

public class Ledger implements Observer {
    private int dayNumber;
    private int moneyMadeToday;
    private int moneyMade;
    private int countOfCarsRentedToday;
    private int countCarsRented;
    private List<AbstractCar> inventory;
    private List<User> usersCompletedRentalToday;
    private List<AbstractCar> carsCompletedToday;
    private List<User> usersRentedCurrently;


    Ledger(List<AbstractCar> allCars){
        dayNumber = 1;
        inventory = allCars;
        usersCompletedRentalToday = new ArrayList<User>();
        usersRentedCurrently = new ArrayList<User>();
        moneyMade = moneyMadeToday = countOfCarsRentedToday = countCarsRented = 0;

    }
    public boolean checkIfUserInList(User theUser, List<User> list ){
        for(int i = 0; i < list.size();i++){
            if(theUser == list.get(i)){
                return true;
            }
        }
        return false;
    }
    public boolean checkIfCarInList(AbstractCar theCar, List<AbstractCar> list ){
        for(int i = 0; i < list.size();i++){
            if(theCar == list.get(i)){
                return true;
            }
        }
        return false;
    }
    public void addUserToActiveRentals(User user){
        if(!checkIfUserInList(user, usersRentedCurrently)){
            usersRentedCurrently.add(user);
        }
    }
    public void removeFromInventory(AbstractCar car){
        inventory.remove(car);
    }
    public void addCarAndUserToCompleted(AbstractCar car, User user){
        usersCompletedRentalToday.add(user);
        carsCompletedToday.add(car);

    }

    public void addCarBackToInventory(AbstractCar car){
        inventory.add(car);
    }
    public void checkUserStillHasRental(User user){
        if(user.getCurRented().size() == 0){
            usersRentedCurrently.remove(user);
        }
    }

    public void update(boolean newRental, AbstractCar theCar, User theUser) {
        if(newRental){
            addUserToActiveRentals(theUser);
            removeFromInventory(theCar);
        }else{
            addCarAndUserToCompleted(theCar,theUser);
            addCarBackToInventory(theCar);
            checkUserStillHasRental(theUser);
        }
    }

    public void PrintActivity(){
        System.out.println("Today's day number is: " + dayNumber);
        System.out.println("Rentals Done today");
        printCompletedRentals();
        printCurrentRentals();
        printInventory();
        System.out.println("The store made " + moneyMadeToday + " today");
        dayNumber = dayNumber + 1;
        cleanDayActivities();
    }
    public void cleanDayActivities(){

    }
    public void printInventory(){
        System.out.println("Cars in inventory");
        if(inventory!= null){
            for(int i = 0; i < inventory.size();i++){
                System.out.println(inventory.get(i).getDescription() + " with license plate " + inventory.get(i).getPlate());
            }
        }else{
            System.out.println("None");
        }

    }
    public void printCompletedRentals(){
        if(usersCompletedRentalToday != null){
            //need to check to see if a car was rented today for the users
            System.out.println(countCarsRented + " cars rented today");
            for(int i = 0; i < usersCompletedRentalToday.size();i++){
                List<AbstractCar> curUserCarsRented = usersCompletedRentalToday.get(i).getCurRented();
                System.out.println(usersCompletedRentalToday.get(i).getname() + " has rented the following car/s");
                for(int j = 0; j < curUserCarsRented.size();j++){
                    System.out.println(curUserCarsRented.get(j).getDescription() + " with license plate " + curUserCarsRented.get(j).getPlate());
                }
            }
        }else{
            System.out.println("None");
        }
    }

    public void printCurrentRentals(){
        System.out.println("Rentals currently active");
        if(usersRentedCurrently!= null){
            for(int i = 0; i < usersRentedCurrently.size();i++){
                List<AbstractCar> curUserCarsRented = usersRentedCurrently.get(i).getCurRented();
                System.out.println(usersRentedCurrently.get(i).getname() + " has rented the following car/s");
                for(int j = 0; j < curUserCarsRented.size();j++){
                    System.out.println(curUserCarsRented.get(j).getDescription() + " with license plate " + curUserCarsRented.get(j).getPlate());
                }
            }
        }else{
            System.out.println("None");
        }
    }

}
