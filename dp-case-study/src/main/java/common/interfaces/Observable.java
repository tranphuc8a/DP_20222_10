package common.interfaces;

/**
 * @author
 */
public interface Observable {

    //functional cohesion
    void attach(Observer observer);
    void remove(Observer observer);
    void notifyObservers();

}
