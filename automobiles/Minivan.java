package automobiles;
public class Minivan extends AbstractCar{
    public Minivan(){
        description = "Minivan";
    }
    public int getCost(){
        int cost = 25000;
        return cost;
    }
}