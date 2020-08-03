package mnix.challenge.tec2019;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

class CompareSolutionsTest {

    @Test
    void randomElements() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int[][] A = generateRandomA(random.nextInt(12) + 1, random.nextInt(12) + 1);
            System.out.println("randomElements i=" + i + ";A=" + Arrays.deepToString(A));
            assertSameResult(A);
        }
    }

    @Test
    void efficientPerformance() {
        for (int i = 0; i < 1000; i++) {
            Stopwatch timer = Stopwatch.createStarted();
            int[][] A = generateRandomA(1000, 1000);
            Stopwatch efficientExecutionTime = timer.stop();
            new EfficientSolution().solution(A);
            System.out.println("efficientExecutionTime=" + efficientExecutionTime);
        }
    }

    private void assertSameResult(int[][] A) {
        String allSequencesSolutionResult = new AllSequencesSolution().solution(A);
        String efficientSolutionResult = new EfficientSolution().solution(A);
        int allSequencesSolutionSum = allSequencesSolutionResult.chars().sum();
        int efficientSolutionSum = efficientSolutionResult.chars().sum();
        System.out.println("allSequencesSolutionResult=" + allSequencesSolutionResult + ";efficientSolutionResult=" + efficientSolutionResult);
        Assertions.assertEquals(allSequencesSolutionSum, efficientSolutionSum);
    }

    private int[][] generateRandomA(int N, int M) {
        Random random = new Random();
        int[][] A = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                A[n][m] = random.nextInt(9) + 1;
            }
        }
        return A;
    }
}
