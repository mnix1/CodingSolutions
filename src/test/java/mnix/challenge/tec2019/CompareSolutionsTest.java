package mnix.challenge.tec2019;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class CompareSolutionsTest {

    @Test
    void randomElements() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int[][] A = generateRandomA(random.nextInt(9) + 1, random.nextInt(9) + 1);
            System.out.println("randomElements i=" + i);
            assertSameResult(A);
        }
    }

    private void assertSameResult(int[][] A) {
        String allSequencesSolutionResult = new AllSequencesSolution().solution(A);
        String efficientSolutionResult = new EfficientSolution().solution(A);
        Assertions.assertEquals(allSequencesSolutionResult.chars().sum(), efficientSolutionResult.chars().sum());
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
