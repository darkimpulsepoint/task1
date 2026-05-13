package by.darkimpulsepoint.task1.observer;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayObserverTest {

    private static class TestObserver implements IntegerArrayObserver {
        private int updateCount = 0;
        private IntegerArray lastArray;

        @Override
        public void update(IntegerArray array) {
            updateCount++;
            lastArray = array;
        }

        public int getUpdateCount() {
            return updateCount;
        }

        public IntegerArray getLastArray() {
            return lastArray;
        }
    }

    @Test
    void testObserverNotifiedOnAdd() {
        IntegerArray array = new IntegerArray();
        TestObserver observer = new TestObserver();

        array.addObserver(observer);
        array.add(10);

        assertEquals(1, observer.getUpdateCount());
        assertEquals(array, observer.getLastArray());
    }

    @Test
    void testObserverNotifiedOnSet() throws SimpleArrayException {
        IntegerArray array = new IntegerArray();
        array.add(10);

        TestObserver observer = new TestObserver();
        array.addObserver(observer);

        array.set(0, 20);

        assertEquals(1, observer.getUpdateCount());
    }

    @Test
    void testMultipleObservers() {
        IntegerArray array = new IntegerArray();
        TestObserver observer1 = new TestObserver();
        TestObserver observer2 = new TestObserver();

        array.addObserver(observer1);
        array.addObserver(observer2);

        array.add(10);
        array.add(20);

        assertEquals(2, observer1.getUpdateCount());
        assertEquals(2, observer2.getUpdateCount());
    }

    @Test
    void testRemoveObserver() {
        IntegerArray array = new IntegerArray();
        TestObserver observer = new TestObserver();

        array.addObserver(observer);
        array.add(10);

        assertEquals(1, observer.getUpdateCount());

        array.removeObserver(observer);
        array.add(20);

        assertEquals(1, observer.getUpdateCount());
    }

    @Test
    void testAddNullObserver() {
        IntegerArray array = new IntegerArray();
        array.addObserver(null);

        array.add(10);
    }

    @Test
    void testAddDuplicateObserver() {
        IntegerArray array = new IntegerArray();
        TestObserver observer = new TestObserver();

        array.addObserver(observer);
        array.addObserver(observer);

        array.add(10);

        assertEquals(1, observer.getUpdateCount());
    }
}
