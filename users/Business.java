package users;

import ledger.ObservableLedger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Business implements BuyBehavior{
    public List<RentRequest> createRentReq(){
        int carSeats;
        boolean gps;
        boolean satRadio;

        List<RentRequest> rentRequests = new ArrayList<RentRequest>();
        Random random = new Random();
        for(int i = 0; i< 3; i++) {
            carSeats = random.nextInt(5);
            gps = random.nextBoolean();
            satRadio = random.nextBoolean();

            RentRequest req = new RentRequest(7, carSeats, gps, satRadio);
            rentRequests.add(req);
        }
        return rentRequests;
    }
    public String type(){
        return "Business";
    }
}