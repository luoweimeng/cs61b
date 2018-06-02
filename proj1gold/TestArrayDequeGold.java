import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;


public class TestArrayDequeGold {
    @Test
    public void randomizedTest() {
        Random rand = new Random();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        for (int i = 0; i < 20; i++) {
            int index = StdRandom.uniform(3);
            switch (index) {
                case 0:
                    int addnum = StdRandom.uniform(10);
                    sad.addFirst(addnum);
                    ads.addFirst(addnum);
                    break;
                case 1:
                    addnum = StdRandom.uniform(10);
                    sad.addLast(addnum);
                    ads.addLast(addnum);
                    break;
                case 2:
                    if (!ads.isEmpty()) {
                        int sadRm = sad.removeFirst();
                        int adsRm = ads.removeFirst();
                        assertEquals(sadRm, adsRm);
                    }
                    break;
                case 3:
                    if (!ads.isEmpty()) {
                        int sadRm = sad.removeLast();
                        int adsRm = ads.removeLast();
                        assertEquals(sadRm, adsRm);
                    }
                    break;
            }
            for(int j = 0; j < ads.size(); j++) {
                assertEquals(ads.get(j), sad.get(j));
            }
        }
    }
}
