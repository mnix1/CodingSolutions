package mnix.challenge.rut2019;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class SolutionTest {
    protected Solution solution;

    @Test
    void testCase1() {
        assertEquals(solution.solution(new int[]{1, 1, 3, 4, 3, 3, 4}, 2), 5);
    }

    @Test
    void testCase2() {
        assertEquals(solution.solution(new int[]{4, 5, 5, 4, 2, 2, 4}, 0), 2);
    }

    @Test
    void testCase3() {
        assertEquals(solution.solution(new int[]{1, 3, 3, 2}, 2), 4);
    }

    @Test
    void testCase4() {
        assertEquals(solution.solution(new int[]{1, 1, 2, 1, 3, 1, 3, 4, 1, 1, 1, 1, 5, 1}, 2), 7);
    }

    @Test
    void testCase5() {
        assertEquals(solution.solution(new int[]{1, 3, 5, 3, 2, 3, 2, 2, 3, 1, 1, 8, 3}, 3), 6);
    }

    @Test
    void testCase6() {
        assertEquals(solution.solution(new int[]{1, 2, 3, 4, 5, 6, 1, 1, 1, 1, 1, 1, 1}, 5), 13);
    }

    @Test
    void testCase7() {
        assertEquals(solution.solution(new int[]{1, 2, 3, 4, 5, 6, 1, 1, 1, 1, 1, 1, 1}, 4), 11);
    }

    @Test
    void testCase8() {
        assertEquals(solution.solution(new int[]{1, 2, 3, 4, 5, 1}, 4), 6);
    }

    @Test
    void testCase9() {
        assertEquals(solution.solution(new int[]{3, 3, 1}, 2), 3);
    }

    @Test
    void testCase10() {
        assertEquals(solution.solution(new int[]{1, 6, 2, 1, 4, 5, 1, 1, 3}, 0), 2);
    }

    @Test
    void testCase11() {
        assertEquals(solution.solution(new int[]{5, 3, 4, 4, 1, 3, 3, 6, 6}, 3), 6);
    }

    @Test
    void testCase12() {
        assertEquals(solution.solution(new int[]{1, 4, 6, 3, 2, 4, 3, 3}, 1), 3);
    }

    @Test
    void testCase13() {
        assertEquals(solution.solution(new int[]{4, 5, 5, 2, 6, 4, 5, 3, 4}, 2), 4);
    }

    @Test
    void testCase14() {
        assertEquals(solution.solution(new int[]{6, 2, 1, 2, 4, 2, 2}, 1), 4);
    }

    @Test
    void testCase15() {
        assertEquals(solution.solution(new int[]{6, 6, 6, 1, 5, 2, 1, 6, 6}, 1), 4);
    }

    @Test
    void testCase16() {
        assertEquals(solution.solution(new int[]{4, 3, 4, 5, 6, 4, 4}, 2), 5);
    }

    @Test
    void testCase17() {
        assertEquals(solution.solution(new int[]{4, 2, 1, 3, 2, 4, 2, 2, 4}, 0), 2);
    }

    @Test
    void testCase18() {
        assertEquals(solution.solution(new int[]{1, 5, 3, 4, 3}, 3), 5);
    }

    @Test
    void testCase19() {
        assertEquals(solution.solution(new int[]{5, 3, 6, 1, 1, 1, 6, 2, 2}, 6), 9);
    }

    @Test
    void testCase20() {
        assertEquals(solution.solution(new int[]{3, 2, 1}, 1), 2);
    }

    @Test
    void testCase21() {
        assertEquals(solution.solution(new int[]{3, 2, 4, 2, 2, 5, 2, 2, 2}, 1), 6);
    }

    @Test
    void testCase22() {
        assertEquals(solution.solution(new int[]{2, 5, 3, 5, 6, 5, 3, 5, 5}, 2), 6);
    }
    @Test
    void testCase23() {
        assertEquals(solution.solution(new int[]{2, 1, 1, 2, 2, 2, 2, 4, 7, 5, 2, 2}, 3), 9);
    }
}