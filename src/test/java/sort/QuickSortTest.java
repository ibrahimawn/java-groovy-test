package sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSortTest {

    private static final Logger LOG = LoggerFactory.getLogger(QuickSortTest.class);
    private static final int ARRAY_SIZE = 10000;
    private static final int[] NUMBERS = generateRandomNumbers(ARRAY_SIZE);

    @Test
    public void testJava() {
        final long start = System.currentTimeMillis();
        JavaQuickSort.quickSort(NUMBERS);
        final long time = System.currentTimeMillis() - start;
        LOG.info("Java time = [{}] ms", time);
    }

    @Test
    public void testGroovy() {
        final long start = System.currentTimeMillis();
        GroovyQuickSort.quickSort(NUMBERS);
        final long time = System.currentTimeMillis() - start;
        LOG.info("Groovy time = [{}] ms", time);
    }

    @Test
    public void testGroovyCS() {
        final long start = System.currentTimeMillis();
        GroovyCSQuickSort.quickSort(NUMBERS);
        final long time = System.currentTimeMillis() - start;
        LOG.info("GroovyCS time = [{}] ms", time);
    }


    private static int[] generateRandomNumbers(int length) {
        List<Integer> result = new ArrayList<>(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            result.add(random.nextInt(length));
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
