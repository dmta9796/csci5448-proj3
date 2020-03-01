package users;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Casual implements BuyBehavior{

    public List<RentRequest> createRentReq(){
        List<RentRequest> rentRequests = new ArrayList<RentRequest>();
        Random random = new Random();
        int carSeats = random.nextInt(5);
        boolean gps = random.nextBoolean();
        boolean satRadio = random.nextBoolean();
        RentRequest req = new RentRequest(random.nextInt(3) + 1, carSeats, gps, satRadio);
        rentRequests.add(req);
        return rentRequests;
    }

    public String type(){
        return "Casual";
    }
}