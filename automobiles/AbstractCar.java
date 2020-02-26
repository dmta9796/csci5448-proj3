package automobiles;
public abstract class AbstractCar{
    String description;
    public String plate;
    private String extras;
    public abstract int getCost();
    public String getDescription(){
        return description;
    }


}

//Economy,  Standard,  Luxury,  SUV,  Minivan)