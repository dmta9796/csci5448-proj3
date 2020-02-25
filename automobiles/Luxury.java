package automobiles;
public class Luxury extends AbstractCar{
    public Luxury(){
        description = "Luxury car";
    }
    
    public int getCost(){
        int cost = 30000;
        return cost;
    }
}