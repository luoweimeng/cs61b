package synthesizer;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer x = new ArrayRingBuffer(4);
        x.enqueue(33.1); // 33.1 null null  null
        x.enqueue(44.8); // 33.1 44.8 null  null
        x.enqueue(62.3); // 33.1 44.8 62.3  null
        x.enqueue(-3.4); // 33.1 44.8 62.3 -3.4
        x.dequeue();     // 44.8 62.3 -3.4  null (returns 33.1)
        assertEquals(x.peek(), (Object) 44.8);
    }

    @Test
    public void iteratorTest() {
        ArrayRingBuffer x = new ArrayRingBuffer(4);
        x.enqueue(33.1); // 33.1 null null  null
        x.enqueue(44.8); // 33.1 44.8 null  null
        x.enqueue(62.3); // 33.1 44.8 62.3  null
        x.enqueue(-3.4); // 33.1 44.8 62.3 -3.4
        x.dequeue();     // 44.8 62.3 -3.4  null (returns 33.1)
        Iterator iter = x.iterator();
        if (iter.hasNext())
            assertEquals(iter.next(), 44.8);

        if (iter.hasNext())
            assertEquals(iter.next(), 62.3);

        if (iter.hasNext())
            assertEquals(iter.next(), -3.4);

        assertFalse(iter.hasNext());
    }
    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
