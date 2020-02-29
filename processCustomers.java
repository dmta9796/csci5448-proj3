import automobiles.AbstractCar;
import automobiles.ChildSeat;
import automobiles.GPS;
import automobiles.Radio;
import users.RentRequest;
import users.User;

import java.util.List;

public class processCustomers {
    public void processRentRequest(User customer, List<RentRequest> rentRequests, List<AbstractCar> inventory ){
        AbstractCar baseCar;
        AbstractCar decoratedCar;
        String test;
        int price;
        for(RentRequest req : rentRequests){
            if(inventory.size() > 0){

                //decorator pattern
                baseCar = decoratedCar = inventory.get(0);
                if(req.carSeats){decoratedCar = new ChildSeat(decoratedCar);}
                if(req.gps){decoratedCar = new GPS(decoratedCar);}
                if(req.satRadio){decoratedCar = new Radio(decoratedCar);}


                customer.addOneCar(decoratedCar, req.nights);

            }
        }
    }
}
