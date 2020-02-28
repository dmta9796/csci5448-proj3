package users;

import automobiles.AbstractCar;

import java.util.ArrayList;
import java.util.List;

public class RentRequest {
    public boolean carSeats;
    public boolean gps;
    public boolean satRadio;
    public int nights;

    public RentRequest(int _nights, boolean _carSeats, boolean _gps, boolean _satRadio){
        carSeats = _carSeats;
        gps = _gps;
        satRadio = _satRadio;
        nights = _nights;
    }
}
