package mnix.challenge.rut2019;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

class CompareSolutionsTest {

    @Test
    void fewSmallElements() {
        for (int i = 0; i < 1000; i++) {
            int[] A = generateRandomA(3, 4);
            int K = generateRandomK(A.length);
            System.out.println("A=" + Arrays.toString(A) + ";K=" + K);
            assertSameResult(A, K);
        }
    }

    @Test
    void fewBigElements() {
        for (int i = 0; i < 1000; i++) {
            int[] A = generateRandomA(5, 100000);
            int K = generateRandomK(A.length);
            System.out.println("A=" + Arrays.toString(A) + ";K=" + K);
            assertSameResult(A, K);
        }
    }

    @Test
    void muchSmallElements() {
        for (int i = 0; i < 1000; i++) {
            int[] A = generateRandomA(9, 6);
            int K = generateRandomK(A.length);
            System.out.println("A=" + Arrays.toString(A) + ";K=" + K);
            assertSameResult(A, K);
        }
    }

    @Test
    void aLotOfBigElements() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("aLotOfBigElements i=" + i);
            int[] A = generateRandomA(100000, 100000);
            int K = generateRandomK(A.length);
            assertSameResultWithProfiling(A, K);
        }
    }

    @Test
    void bigADifferentElementsSmallK() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i % 10000;
        }
        int K = 10;
        assertSameResultWithProfiling(A, K);
    }

    @Test
    void bigADifferentElementsBigK() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i % 10000;
        }
        int K = 10000;
        assertSameResultWithProfiling(A, K);
    }

    @Test
    void bigASameElementsSmallK() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i % 10;
        }
        int K = 10;
        assertSameResultWithProfiling(A, K);
    }

    @Test
    void bigASameElementsBigK() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i % 10;
        }
        int K = 10000;
        assertSameResultWithProfiling(A, K);
    }

    private void assertSameResultWithProfiling(int[] a, int k) {
        Stopwatch timer = Stopwatch.createStarted();
        int uglyComplicatedSolutionResult = new UglyComplicatedSolution().solution(a, k);
        System.out.println("first uglyComplicatedSolutionResult took " + timer.stop());
        timer = Stopwatch.createStarted();
        int naiveSolutionResult = new NaiveSolution().solution(a, k);
        System.out.println("first naiveSolutionResult took " + timer.stop());
        timer = Stopwatch.createStarted();
        naiveSolutionResult = new NaiveSolution().solution(a, k);
        System.out.println("second naiveSolutionResult took " + timer.stop());
        timer = Stopwatch.createStarted();
        uglyComplicatedSolutionResult = new UglyComplicatedSolution().solution(a, k);
        System.out.println("second uglyComplicatedSolutionResult took " + timer.stop());
        Assertions.assertEquals(uglyComplicatedSolutionResult, naiveSolutionResult);
    }

    private void assertSameResult(int[] A, int K) {
        Assertions.assertEquals(new UglyComplicatedSolution().solution(A, K), new NaiveSolution().solution(A, K));
    }

    private int[] generateRandomA(int N, int maxElement) {
        Random random = new Random();
        int[] H = new int[random.nextInt(N) + 1];
        for (int i = 0; i < H.length; i++) {
            H[i] = random.nextInt(maxElement) + 1;
        }
        return H;
    }

    private int generateRandomK(int max) {
        return new Random().nextInt(max);
    }
}
