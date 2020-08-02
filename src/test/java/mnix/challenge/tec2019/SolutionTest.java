package mnix.challenge.tec2019;


import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class SolutionTest {
    protected Solution solution;

    @Test
    void testCase1() {
        assertEquals(solution.solution(generateA(2, 2)), "134");
    }

    @Test
    void testCase2() {
        assertEquals(solution.solution(generateA(3, 3)), "14789");
    }

    @Test
    void testCase3() {
        assertThat(Set.of("1567837", "1594567")).contains(solution.solution(generateA(4, 4)));
    }

    @Test
    void testCase4() {
        assertEquals(solution.solution(generateA(5, 5)), "167849567");
    }

    @Test
    void testCase5() {
        assertThat(Set.of("17896789639", "17896396789")).contains(solution.solution(generateA(6, 6)));
    }

    @Test
    void testCase6() {
        assertEquals(solution.solution(generateA(7, 7)), "1897897897864");
    }

    @Test
    void testCase7() {
        assertEquals(solution.solution(generateA(6, 3)), "14789369");
    }

    @Test
    void testCase8() {
        assertEquals(solution.solution(generateA(6, 9)), "12345678999999");
    }

    @Test
    void testCase9() {
        assertEquals(solution.solution(new int[][]{{9, 9, 7}, {9, 7, 2}, {6, 9, 5}, {9, 1, 2}}), "997952");
    }

    @Test
    void testCase10() {
        assertEquals(solution.solution(generateA(10, 10)), "1234567891234567891");
    }

    private int[][] generateA(int N, int M) {
        int next = 1;
        int[][] A = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                A[n][m] = next;
                next = (next % 9) + 1;
            }
        }
        return A;
    }
}