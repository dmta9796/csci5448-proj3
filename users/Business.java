package users;

import ledger.ObservableLedger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Business implements BuyBehavior{
    public List<RentRequest> createRentReq(){
        List<RentRequest> rentRequests = new ArrayList<RentRequest>();
        Random random = new Random();
        boolean carSeats = random.nextBoolean();
        boolean gps = random.nextBoolean();
        boolean satRadio = random.nextBoolean();
        for(int i = 0; i< 3; i++) {
            RentRequest req = new RentRequest(7, carSeats, gps, satRadio);
            rentRequests.add(req);
        }
        return rentRequests;
    }
    public String type(){
        return "Business";
    }
}