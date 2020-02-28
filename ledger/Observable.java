package ledger;

import java.util.ArrayList;
import java.util.List;

public interface Observable {
    public void registerObs(Observer obs);
    public void unregisterObs(Observer obs);
    public void notifyObservers();
}
