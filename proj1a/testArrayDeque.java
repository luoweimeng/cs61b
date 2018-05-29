import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;

public class testArrayDeque {
    @Test
    public void testAddFirst() {
        ArrayDeque<String> array = new ArrayDeque<>();
        for (char c = 'a'; c <= 'z'; c++) {
            array.addFirst(String.valueOf(c));
        }
        array.printDeque();
        assertEquals("z", array.get(0));
        assertEquals("a", array.get(25));
        assertEquals(26, array.size());
    }

    @Test
    public void testAddLast() {
        ArrayDeque<String> array = new ArrayDeque<>();
        for (char c = 'a'; c <= 'z'; c++) {
            array.addLast(String.valueOf(c));
        }
        array.printDeque();
        assertEquals("a", array.get(0));
        assertEquals("z", array.get(25));
        assertEquals(26, array.size());
    }

    @Test
    public void testRemoveFirst() {
        ArrayDeque<String> array = new ArrayDeque<>();
        for (char c = 'a'; c <= 'z'; c++) {
            array.addLast(String.valueOf(c));
        }
        assertEquals("a", array.removeFirst());
        assertEquals("b", array.removeFirst());
        assertEquals(24, array.size());
    }


    public static void main(String[] args) {

    }
}
