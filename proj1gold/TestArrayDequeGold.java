//Task1

import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

public class TestArrayDequeGold {
    StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
    ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
    StringBuilder sb = new StringBuilder();

    @Test
    public void testTwoFiles() {

        for (int i = 0; i < 1000; i += 1) {
            int operation = StdRandom.uniform(4);
            Integer value = StdRandom.uniform(114154);

            switch (operation) {
                case 0:
                    sad.addFirst(value);
                    ads.addFirst(value);
                    sb.append("addFirst(" + value + ")\n");
                    break;

                case 1:
                    sad.addLast(value);
                    ads.addLast(value);
                    sb.append("addLast(" + value + ")\n");
                    break;

                case 2:
                    if (!sad.isEmpty() && !ads.isEmpty()) {
                        Integer expected = ads.removeFirst();
                        Integer actual = sad.removeFirst();
                        sb.append("removeFirst()\n");
                        assertEquals(sb.toString(), expected, actual);
                    }
                    break;

                case 3:
                    if (!sad.isEmpty() && !ads.isEmpty()) {
                        Integer expected = ads.removeLast();
                        Integer actual = sad.removeLast();
                        sb.append("removeLast()\n");
                        assertEquals(sb.toString(), expected, actual);
                    }
                    break;

            }

        }


    }
}
