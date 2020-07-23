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
}