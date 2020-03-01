package users;

import automobiles.AbstractCar;

import java.util.ArrayList;
import java.util.List;

public class RentRequest {
    public int carSeats;
    public boolean gps;
    public boolean satRadio;
    public int duration;

    public RentRequest(int _duration, int _carSeats, boolean _gps, boolean _satRadio){
        carSeats = _carSeats;
        gps = _gps;
        satRadio = _satRadio;
        duration = _duration;
    }
}

