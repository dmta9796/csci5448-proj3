package automobiles;
class SUV extends AbstractCar{
    String description;
    public SUV(){
        description = "SUV car";
    }
    int getCost(){
        int cost = 22000;
        return cost;
    }
}