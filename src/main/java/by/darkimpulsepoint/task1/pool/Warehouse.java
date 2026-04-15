package by.darkimpulsepoint.task1.pool;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse<T> {

    private static Warehouse<?> instance;
    private final Map<SimpleArray<T>, ArrayParameters<T>> storage = new HashMap<>();

    private Warehouse() {
    }

    public static <T> Warehouse<T> getInstance() {
        if (instance == null) {
            instance = new Warehouse<T>();
        }
        return (Warehouse<T>) instance;
    }

    public void put(SimpleArray<T> array, ArrayParameters<T> parameters) {
        if (array != null && parameters != null) {
            storage.put(array, parameters);
        }
    }

    public Optional<ArrayParameters<T>> getParameters(SimpleArray<T> array) {
        return Optional.ofNullable(storage.get(array));
    }

    public void clear() {
        storage.clear();
    }
}