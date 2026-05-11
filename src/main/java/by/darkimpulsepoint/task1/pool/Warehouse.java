package by.darkimpulsepoint.task1.pool;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Warehouse {

    private static Warehouse instance;
    private final Map<Long, ArrayParameters> storage = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void put(IntegerArray array, ArrayParameters parameters) {
        if (array != null && parameters != null) {
            storage.put(array.getId(), parameters);
        }
    }

    public Optional<ArrayParameters> getParameters(IntegerArray array) {
        if (array == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(storage.get(array.getId()));
    }

    public Optional<ArrayParameters> getParameters(long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public void clear() {
        storage.clear();
    }
}