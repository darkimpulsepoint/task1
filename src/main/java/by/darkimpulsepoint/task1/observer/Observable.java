package by.darkimpulsepoint.task1.observer;

public interface Observable<T> {
    void addObserver(SimpleArrayObserver<T> observer);
    void removeObserver(SimpleArrayObserver<T> observer);
    void notifyObservers();
}