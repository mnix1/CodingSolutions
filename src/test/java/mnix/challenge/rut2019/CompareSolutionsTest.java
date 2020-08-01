package mnix.challenge.rut2019;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

class CompareSolutionsTest {

    @Test
    void fewSmallElements() {
        for (int i = 0; i < 100000; i++) {
            int[] A = generateRandomA(7, 10);
            int K = generateRandomK(A.length);
            System.out.println("A=" + Arrays.toString(A) + ";K=" + K);
            assertSameResult(A, K);
        }
    }

    @Test
    void fewBigElements() {
        for (int i = 0; i < 100000; i++) {
            int[] A = generateRandomA(7, 100000);
            int K = generateRandomK(A.length);
            System.out.println("A=" + Arrays.toString(A) + ";K=" + K);
            assertSameResult(A, K);
        }
    }

    @Test
    void muchSmallElements() {
        for (int i = 0; i < 100000; i++) {
            int[] A = generateRandomA(15, 10);
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
        int K = 1000;
        assertSameResultWithProfiling(A, K);
    }

    @Test
    void bigASameElementsSmallK() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i / 12;
        }
        int K = 10;
        assertSameResultWithProfiling(A, K);
    }

    @Test
    void bigASameElementsBigK() {
        int[] A = new int[100000];
        for (int i = 0; i < A.length; i++) {
            A[i] = i / 2;
        }
        int K = 10000;
        assertSameResultWithProfiling(A, K);
    }

    private void assertSameResultWithProfiling(int[] A, int K) {
        Stopwatch timer = Stopwatch.createStarted();
        int improvedNaiveSolutionResult = new ImprovedNaiveSolution().solution(A, K);
        Stopwatch improvedNaiveExecutionTime = timer.stop();
        timer = Stopwatch.createStarted();
        int efficientSolutionResult = new EfficientSolution().solution(A, K);
        Stopwatch efficientExecutionTime = timer.stop();
        System.out.println("improvedNaiveExecutionTime=" + improvedNaiveExecutionTime + "; efficientExecutionTime=" + efficientExecutionTime);
        Assertions.assertEquals(efficientSolutionResult, improvedNaiveSolutionResult);
    }

    private void assertSameResult(int[] A, int K) {
        int naiveSolutionResult = new NaiveSolution().solution(A, K);
        Assertions.assertEquals(new UglyComplicatedSolution().solution(A, K), naiveSolutionResult);
        Assertions.assertEquals(new ImprovedNaiveSolution().solution(A, K), naiveSolutionResult);
        Assertions.assertEquals(new NiceSolution().solution(A, K), naiveSolutionResult);
        Assertions.assertEquals(new EfficientSolution().solution(A, K), naiveSolutionResult);
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
