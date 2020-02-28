package users;

import java.util.List;

public interface BuyBehavior {
    abstract List<RentRequest> createRentReq();
    abstract String type();
}
