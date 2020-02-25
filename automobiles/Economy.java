package automobiles;
public class Economy extends AbstractCar{
    public Economy(){
        description = "Economy car";
    }
    
    public int getCost(){
        int cost = 15000;
        return cost;
    }
}