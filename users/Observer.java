package users;
import automobiles.AbstractCar;
public interface Observer {
    public void update(boolean newRental, AbstractCar theCar, User theUser);
}
