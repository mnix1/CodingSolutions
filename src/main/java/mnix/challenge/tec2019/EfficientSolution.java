package mnix.challenge.tec2019;

import java.math.BigInteger;

import static java.math.BigInteger.TEN;
import static java.math.BigInteger.ZERO;

public class EfficientSolution implements Solution {
    @Override
    public String solution(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        BigInteger[][] sumA = new BigInteger[N + 1][M + 1];
        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                sumA[n][m] = ZERO;
            }
        }
        for (int n = 1; n <= N; n++) {
            for (int m = 1; m <= M; m++) {
                BigInteger upValue = sumA[n - 1][m];
                BigInteger leftValue = sumA[n][m - 1];
                if (upValue.compareTo(leftValue) > 0) {
                    sumA[n][m] = upValue;
                    sumA[n][m - 1] = ZERO;
                } else {
                    sumA[n][m] = leftValue;
                    sumA[n - 1][m] = ZERO;
                }
                sumA[n - 1][m - 1] = null;
                sumA[n][m] = sumA[n][m].multiply(TEN).add(BigInteger.valueOf(A[n - 1][m - 1]));
            }
        }
        return sumA[N][M].toString();
    }
}
