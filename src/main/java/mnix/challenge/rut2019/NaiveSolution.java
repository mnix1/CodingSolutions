package mnix.challenge.rut2019;

class NaiveSolution implements Solution {
    @Override
    public int solution(int[] A, int K) {
        if (A.length == K) {
            return K;
        }
        int max = 0;
        for (int index = 0; index < A.length; index++) {
            int remainingK = K;
            int innerIndex = index + 1;
            while (innerIndex < A.length) {
                if (A[innerIndex] != A[index]) {
                    remainingK--;
                    if (remainingK < 0) {
                        break;
                    }
                }
                innerIndex++;
            }
            int count = innerIndex - index;
            if (remainingK > 0 && index > 0) {
                count = count + Math.min(remainingK, index);
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
