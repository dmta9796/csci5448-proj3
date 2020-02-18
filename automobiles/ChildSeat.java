package automobiles;
class ChildSeat extends Decorator{
    AbstractCar car;
    public ChildSeat(AbstractCar car){
        this.car = car;
    }
    public int getCost(){
        int cost = car.getCost() + 111;
        return cost;
    }
}