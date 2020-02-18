package automobiles;
class Minivan extends AbstractCar{
    String description;
    public Minivan(){
        description = "Minivan";
    }
    int getCost(){
        int cost = 25000;
        return cost;
    }
}