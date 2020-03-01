package ledger;

import automobiles.AbstractCar;
import users.User;

public class LedgerObserver implements Observer{
    private ObservableLedger ledger = null;
    public LedgerObserver(ObservableLedger obj){
        this.ledger = obj;
    }
    public void update(){
        System.out.println("\n" + "Day " + this.ledger.getDayNumber() + ":");
        System.out.println("The Store Made $" + this.ledger.getMoneyMadeToday() +  " Yesterday" + "\n");
        System.out.println("Record of Complete Rentals:");
        for(RentRecord rec : this.ledger.getRentalRecords()){
            if(rec.returned){
                System.out.println("\t\t" + rec.user.getName() + "\t\t" + rec.carWithOptions.getDescription() + "\t\t" + rec.totalDuration + " Days" + "\t\t" + "$" + rec.car.getCost());
            }
        }
        System.out.println("Record of Active Rentals:");
        for(RentRecord rec : this.ledger.getRentalRecords()){
            if(!rec.returned){
                System.out.println("\t\t" + rec.user.getName() + "\t\t" + rec.car.getDescription() + "\t\t" + rec.car.getPlate() + "\t\t" + "Due in " + rec.duration + " Days");
            }
        }
        System.out.println(this.ledger.getInventory().size() + " Vehicles Left In Inventory: ");
        for(AbstractCar car : this.ledger.getInventory()){
            System.out.println("\t\t" + car.getDescription() + " " + car.getPlate());
        }
    }
}
