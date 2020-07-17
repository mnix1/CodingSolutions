package mnix.challenge.pal2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

class CompareSolutionsTest {

    @Test
    void compareEfficientWithTwoLoopsFewSmallElements() {
        for (int i = 0; i < 1000; i++) {
            int[] H = generateRandomH(3, 4);
            System.out.println(Arrays.toString(H));
            assertSameResult(H);
        }
    }

    @Test
    void compareEfficientWithTwoLoopsFewBigElements() {
        for (int i = 0; i < 1000; i++) {
            int[] H = generateRandomH(5, 10000);
            System.out.println(Arrays.toString(H));
            assertSameResult(H);
        }
    }

    @Test
    void compareEfficientWithTwoLoopsMuchSmallElements() {
        for (int i = 0; i < 100; i++) {
            int[] H = generateRandomH(1000, 10);
            assertSameResult(H);
        }
    }

    @Test
    void compareEfficientWithTwoLoopsMuchBigElements() {
        for (int i = 0; i < 100; i++) {
            int[] H = generateRandomH(10000, 10000);
            assertSameResult(H);
        }
    }

    @Test
    void compareEfficientWithTwoLoopsALotOfBigElements() {
        int[] H = generateRandomH(1000000, 10000);
        assertSameResult(H);
    }

    private void assertSameResult(int[] H) {
        Assertions.assertEquals(new EfficientSolution().solution(H), new TwoLoopsSolution().solution(H));
    }

    private int[] generateRandomH(int N, int maxHeight) {
        Random random = new Random();
        int[] H = new int[random.nextInt(N) + 1];
        for (int i = 0; i < H.length; i++) {
            H[i] = random.nextInt(maxHeight) + 1;
        }
        return H;
    }
}
