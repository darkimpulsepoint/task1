package by.darkimpulsepoint.task1.observer;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.observer.impl.IntegerArrayObserverImpl;
import by.darkimpulsepoint.task1.pool.ArrayParameters;
import by.darkimpulsepoint.task1.pool.Warehouse;
import by.darkimpulsepoint.task1.service.impl.ArrayMathServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayObserverImplTest {

    private Warehouse warehouse;
    private ArrayMathServiceImpl mathService;

    @BeforeEach
    void setUp() {
        warehouse = Warehouse.getInstance();
        warehouse.clear();
        mathService = new ArrayMathServiceImpl();
    }

    @Test
    void testArrayStatisticsObserverUpdatesWarehouseOnAdd() {
        IntegerArray array = new IntegerArray();
        array.setId(1L);

        IntegerArrayObserverImpl observer = new IntegerArrayObserverImpl(mathService);
        array.addObserver(observer);

        array.add(10);
        array.add(20);
        array.add(30);

        Optional<ArrayParameters> params = warehouse.getParameters(array);
        assertTrue(params.isPresent());
        assertEquals(10, params.get().getMin());
        assertEquals(30, params.get().getMax());
        assertEquals(60, params.get().getSum());
    }

    @Test
    void testArrayStatisticsObserverUpdatesWarehouseOnSet() throws Exception {
        IntegerArray array = new IntegerArray();
        array.setId(2L);
        array.add(10);
        array.add(20);
        array.add(30);

        IntegerArrayObserverImpl observer = new IntegerArrayObserverImpl(mathService);
        array.addObserver(observer);

        array.set(1, 100);

        Optional<ArrayParameters> params = warehouse.getParameters(array);
        assertTrue(params.isPresent());
        assertEquals(10, params.get().getMin());
        assertEquals(100, params.get().getMax());
        assertEquals(140, params.get().getSum());
    }

    @Test
    void testArrayStatisticsObserverSkipsArrayWithoutId() {
        IntegerArray array = new IntegerArray();

        IntegerArrayObserverImpl observer = new IntegerArrayObserverImpl(mathService);
        array.addObserver(observer);

        array.add(10);
        array.add(20);

        Optional<ArrayParameters> params = warehouse.getParameters(array);
        assertFalse(params.isPresent());
    }

    @Test
    void testArrayStatisticsObserverWithEmptyArray() {
        IntegerArray array = new IntegerArray();
        array.setId(3L);

        IntegerArrayObserverImpl observer = new IntegerArrayObserverImpl(mathService);
        array.addObserver(observer);

        Optional<ArrayParameters> params = warehouse.getParameters(array);
        assertFalse(params.isPresent());
    }
}
