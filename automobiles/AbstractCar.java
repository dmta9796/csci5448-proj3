package automobiles;
public abstract class AbstractCar{
    String description;
    public String plate;
    private String extras;
    public abstract int getCost();
    public String getDescription(){
        return description;
    }
    public String getPlate(){
        return plate;
    }


}

//Economy,  Standard,  Luxury,  SUV,  Minivan)