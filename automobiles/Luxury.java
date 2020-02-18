package automobiles;
class Luxury extends AbstractCar{
    String description;
    public Luxury(){
        description = "Luxury car";
    }
    int getCost(){
        int cost = 30000;
        return cost;
    }
    String getDescription(){
        return description;
    }
}