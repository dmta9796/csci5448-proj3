package ledger;

import automobiles.AbstractCar;
import users.User;

public class LedgerObserver implements Observer{
    private ObservableLedger ledger = null;
    public LedgerObserver(ObservableLedger obj){
        this.ledger = obj;
    }
    public void update(){
        System.out.println("\n" + "Recap of day " + this.ledger.dayNumber + ":" + "\n");
        for(User user : this.ledger.usersRentedToday){
            System.out.println(user.getName());
        }
        System.out.println("Complete Record of Active Rentals:");
        for(User user : this.ledger.usersRentedCurrently){
            System.out.println("\t" + user.getName() + " has rented:");
            for(AbstractCar car : user.getCurRented()){
                System.out.println("\t\t" + car.getDescription() + ", License: " + car.getPlate());
            }
        }
        System.out.println(this.ledger.inventory.size() + " Vehicles Left In Inventory: ");
        for(AbstractCar car : this.ledger.inventory){
            System.out.println("\t" + car.getDescription() + " " + car.getPlate());
        }
    }
}
