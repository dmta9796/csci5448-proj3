package automobiles;
class Standard extends AbstractCar{
    String description;
    public Standard(){
        description = "Standard car";
    }
    int getCost(){
        int cost = 15000;
        return cost;
    }
}