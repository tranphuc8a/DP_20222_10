package common.interfaces;

/**
 * @author
 */
// Functional cohesion
public interface Observable {
    void attach(Observer observer);
    void remove(Observer observer);
    void notifyObservers();
}
