package automobiles;
public abstract class AbstractCar{
    String description;
    public String plate;
    private String extras;
    private int daysToBeRented;
    public abstract int getCost();
    public String getDescription(){
        return description;
    }
    public String getPlate(){
        return plate;
    }
    public int getLeftInRental(){
        return daysToBeRented;
    }
    public void setDaysToBeRented(int days){daysToBeRented = days;};
    public void decrementDaysToBeRented(){daysToBeRented = daysToBeRented -1;};



}

//Economy,  Standard,  Luxury,  SUV,  Minivan)