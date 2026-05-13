package by.darkimpulsepoint.task1.entity;

import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerArrayTest {

    @Test
    void testAddAndGet() {
        IntegerArray array = new IntegerArray();
        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals(3, array.size());
        int[] elements = array.getElements();
        assertEquals(10, elements[0]);
        assertEquals(20, elements[1]);
        assertEquals(30, elements[2]);
    }

    @Test
    void testSet() throws SimpleArrayException {
        IntegerArray array = new IntegerArray();
        array.add(10);
        array.add(20);
        array.add(30);

        array.set(1, 25);

        int[] elements = array.getElements();
        assertEquals(25, elements[1]);
    }

    @Test
    void testGetOutOfBounds() {
        IntegerArray array = new IntegerArray();
        array.add(10);

        int[] elements = array.getElements();
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            int val = elements[5];
        });
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            int val = elements[-1];
        });
    }

    @Test
    void testSetOutOfBounds() {
        IntegerArray array = new IntegerArray();
        array.add(10);

        assertThrows(SimpleArrayException.class, () -> array.set(5, 100));
        assertThrows(SimpleArrayException.class, () -> array.set(-1, 100));
    }

    @Test
    void testAutoResize() {
        IntegerArray array = new IntegerArray(2);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);

        assertEquals(4, array.size());
        int[] elements = array.getElements();
        assertEquals(1, elements[0]);
        assertEquals(4, elements[3]);
    }

    @Test
    void testToArray() {
        IntegerArray array = new IntegerArray();
        array.add(10);
        array.add(20);
        array.add(30);

        int[] result = array.toArray();

        assertArrayEquals(new int[]{10, 20, 30}, result);
    }

    @Test
    void testEquals() {
        IntegerArray array1 = new IntegerArray();
        array1.add(10);
        array1.add(20);

        IntegerArray array2 = new IntegerArray();
        array2.add(10);
        array2.add(20);

        IntegerArray array3 = new IntegerArray();
        array3.add(10);
        array3.add(30);

        assertEquals(array1, array2);
        assertNotEquals(array1, array3);
    }

    @Test
    void testHashCode() {
        IntegerArray array1 = new IntegerArray();
        array1.add(10);
        array1.add(20);

        IntegerArray array2 = new IntegerArray();
        array2.add(10);
        array2.add(20);

        assertEquals(array1.hashCode(), array2.hashCode());
    }

    @Test
    void testToString() {
        IntegerArray array = new IntegerArray();
        assertEquals("[]", array.toString());

        array.add(10);
        array.add(20);
        array.add(30);

        assertEquals("[10, 20, 30]", array.toString());
    }

    @Test
    void testIdGetterSetter() {
        IntegerArray array = new IntegerArray();
        assertNull(array.getId());

        array.setId(123L);
        assertEquals(123L, array.getId());
    }
}
