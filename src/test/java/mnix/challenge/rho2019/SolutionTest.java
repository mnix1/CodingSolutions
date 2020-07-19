package mnix.challenge.rho2019;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class SolutionTest {
    protected Solution solution;

    @Test
    void testCase1() {
        Assertions.assertEquals(solution.solution(new int[]{2, 0, 2, 2, 1, 0}), 12);
    }

    @Test
    void testCase2() {
        Assertions.assertEquals(solution.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 8}), 45);
    }

    @Test
    void testCase3() {
        Assertions.assertEquals(solution.solution(new int[]{4, 4, 4, 4, 4, 4, 4}), 21);
    }

    @Test
    void testCase4() {
        Assertions.assertEquals(solution.solution(new int[]{1, 1}), 3);
    }

    @Test
    void testCase5() {
        Assertions.assertEquals(solution.solution(new int[]{2, 0, 2, 2, 1, 0, 5, 6, 7, 8, 9}), 37);
    }

    @Test
    void testCase6() {
        Assertions.assertEquals(solution.solution(new int[]{10, 10, 0, 10, 0, 1, 2, 3, 4, 5, 0}), 12);
    }

}