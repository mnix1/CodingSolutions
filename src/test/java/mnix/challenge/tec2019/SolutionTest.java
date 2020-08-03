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
        assertEquals(solution.solution(generateA(5, 5)), "167895627");
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

    @Test
    void testCase11() {
        assertEquals(solution.solution(generateA(5, 6)), "1789678963");
    }

    @Test
    void testCase12() {
        assertEquals(solution.solution(new int[][]{
                {9, 5, 5, 1, 1},
                {2, 1, 6, 1, 1},
                {9, 1, 4, 1, 1},
                {9, 5, 9, 1, 1},
                {1, 1, 4, 5, 3},
        }), "955649453");
    }

    @Test
    void testCase13() {
        assertEquals(solution.solution(new int[][]{
                {5, 1, 9, 5, 8, 9, 7},
                {4, 7, 6, 1, 4, 1, 5},
        }), "54761415");
    }

    @Test
    void testCase14() {
        assertEquals(solution.solution(new int[][]{
                {5, 7, 2, 6, 3, 7, 1, 8, 5, 5},
                {8, 8, 5, 5, 1, 1, 4, 2, 3, 3},
                {6, 5, 3, 3, 3, 3, 8, 5, 8, 8},
                {1, 3, 2, 2, 7, 3, 4, 4, 4, 1},
                {1, 9, 4, 7, 4, 2, 4, 6, 3, 5},
                {7, 1, 7, 2, 9, 9, 9, 2, 3, 1},
                {1, 7, 8, 4, 5, 2, 7, 2, 3, 6},
                {2, 3, 7, 2, 6, 8, 2, 2, 5, 8},
                {9, 1, 6, 9, 1, 5, 4, 9, 9, 4},
                {5, 1, 3, 5, 1, 5, 6, 8, 9, 1},
        }), "5885533749997249991");
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