package mnix.challenge.tec2019;

public class EfficientSolution implements Solution {
    @Override
    public String solution(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        long[][] sumA = new long[N][M];
        sumA[0][0] = A[0][0];
        for (int m = 1; m < M; m++) {
            sumA[0][m] = sumA[0][m - 1] + A[0][m];
        }
        for (int n = 1; n < N; n++) {
            sumA[n][0] = sumA[n - 1][0] + A[n][0];
            for (int m = 1; m < M; m++) {
                sumA[n][m] = Math.max(sumA[n - 1][m], sumA[n][m - 1]) + A[n][m];
            }
        }
        int n = N - 1;
        int m = M - 1;
        StringBuilder reversedSequenceBuilder = new StringBuilder(N + M - 1);
        reversedSequenceBuilder.append(A[n][m]);
        while (n != 0 && m != 0) {
            if (sumA[n][m - 1] > sumA[n - 1][m]) {
                reversedSequenceBuilder.append(A[n][m - 1]);
                m--;
            } else {
                reversedSequenceBuilder.append(A[n - 1][m]);
                n--;
            }
        }
        while (n != 0) {
            reversedSequenceBuilder.append(A[n - 1][m]);
            n--;
        }
        while (m != 0) {
            reversedSequenceBuilder.append(A[n][m - 1]);
            m--;
        }
        return reversedSequenceBuilder.reverse().toString();
    }
}
