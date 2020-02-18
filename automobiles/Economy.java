package automobiles;
class Economy extends AbstractCar{
    String description;
    public Economy(){
        description = "Economy car";
    }
    int getCost(){
        int cost = 15000;
        return cost;
    }
}