package users;

import automobiles.AbstractCar;

public interface Subject {
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);

    public void notifyObservers(boolean newRental,AbstractCar car);

}
