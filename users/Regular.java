package users;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Regular implements BuyBehavior{
    public List<RentRequest> createRentReq(){
        int carSeats;
        boolean gps;
        boolean satRadio;

        List<RentRequest> rentRequests = new ArrayList<RentRequest>();
        Random random = makeRandom();;
        for(int i = 0; i< random.nextInt(3) + 1; i++) {
            carSeats = random.nextInt(5);
            gps = random.nextBoolean();
            satRadio = random.nextBoolean();

            RentRequest req = new RentRequest(random.nextInt(3) + 3, carSeats, gps, satRadio);
            rentRequests.add(req);
        }
        return rentRequests;
    }

    public String type(){
        return "Regular";
    }

    public Random makeRandom(){
        return new Random();
    }

}