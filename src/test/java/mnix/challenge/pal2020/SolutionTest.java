package mnix.challenge.pal2020;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;


abstract class SolutionTest {
    protected Solution solution;

    @Test
    void testCase1() {
        Assertions.assertEquals(solution.solution(new int[]{3, 1, 4}), 10);
    }

    @Test
    void testCase2() {
        Assertions.assertEquals(solution.solution(new int[]{5, 3, 2, 4}), 17);
    }

    @Test
    void testCase3() {
        Assertions.assertEquals(solution.solution(new int[]{5, 3, 5, 2, 1}), 19);
    }

    @Test
    void testCase4() {
        Assertions.assertEquals(solution.solution(new int[]{7, 7, 3, 7, 7}), 35);
    }

    @Test
    void testCase5() {
        Assertions.assertEquals(solution.solution(new int[]{1, 1, 7, 6, 6, 6}), 30);
    }

    @Test
    void maxArea() {
        int[] H = new int[100000];
        Arrays.fill(H, 10000);
        Assertions.assertEquals(solution.solution(H), 100000 * 10000);
    }

    @Test
    void oneElement() {
        Assertions.assertEquals(solution.solution(new int[]{1}), 1);
    }

    @Test
    void testCaseRandom1() {
        int[] H = new int[]{2, 4, 4};
        Assertions.assertEquals(solution.solution(H), 10);
    }

    @Test
    void testCaseRandom2() {
        int[] H = new int[]{9269, 7263, 1790};
        Assertions.assertEquals(solution.solution(H), 20328);
    }

    @Test
    void testCaseRandom3() {
        int[] H = new int[]{8959, 713, 5803, 5041, 7021, 2308, 9655, 7287, 512, 8411, 8228, 5252, 5211, 3111, 106, 5898, 5281, 5968, 2380, 3422, 7233, 3460, 3124, 7889, 4879, 6003, 9161, 5690, 5808, 1654, 3674, 5327, 8225, 8287, 4170, 1875, 2100, 988, 8760, 5417, 9144, 5958, 2441, 982, 9683, 4182, 9076};
        Assertions.assertEquals(solution.solution(H), 450757);
    }

    @Test
    void testCaseRandom4() {
        int[] H = new int[]{4, 3, 1};
        Assertions.assertEquals(solution.solution(H), 9);
    }

}