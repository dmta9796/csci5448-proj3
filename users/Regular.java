package users;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Regular implements BuyBehavior{
    public List<RentRequest> createRentReq(){
        List<RentRequest> rentRequests = new ArrayList<RentRequest>();
        Random random = new Random();
        boolean carSeats = random.nextBoolean();
        boolean gps = random.nextBoolean();
        boolean satRadio = random.nextBoolean();
        for(int i = 0; i< random.nextInt(3) + 1; i++) {
            RentRequest req = new RentRequest(random.nextInt(3) + 3, carSeats, gps, satRadio);
            rentRequests.add(req);
        }
        return rentRequests;
    }

    public String type(){
        return "Regular";
    }

}