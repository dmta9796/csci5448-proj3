public class Ledger {
    private int dayNumber;

    Ledger(){
        dayNumber = 1;
    }

    public void PrintActivity(){
        System.out.println("Today's day number is: " + dayNumber);
    }
}
