package ledger;

import automobiles.AbstractCar;
import users.User;

public class RentRecord {
    public AbstractCar car;
    public AbstractCar carWithOptions;
    public int duration;
    public int totalDuration;
    public User user;
    public boolean returned;

    public RentRecord(User _user, AbstractCar _car, AbstractCar _decoratedCar, int _duration){
        user = _user;
        car = _car;
        carWithOptions = _decoratedCar;
        duration = _duration;
        totalDuration = _duration;
        returned = false;
    }

    public void returnCar(){
        returned = true;
    }
}
