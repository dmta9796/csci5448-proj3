package automobiles;
public class Standard extends AbstractCar{
    public Standard(){
        description = "Standard car";
    }
    public int getCost(){
        int cost = 15000;
        return cost;
    }
}