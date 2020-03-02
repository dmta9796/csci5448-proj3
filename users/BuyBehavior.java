package users;

import java.util.List;
import java.util.Random;

public interface BuyBehavior {
    abstract List<RentRequest> createRentReq();
    abstract String type();
    abstract Random makeRandom();
}
