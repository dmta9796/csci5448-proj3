package automobiles;
public abstract class AbstractCar{
    String description;
    String plate;
    private String extras;
    public abstract int getCost();
    public String getDescription(){
        return description;
    }
    public String getPlate(){
        return plate;
    }
    public void setPlate(String _plate) { plate = _plate; }


}

//Economy,  Standard,  Luxury,  SUV,  Minivan)