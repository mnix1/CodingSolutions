package mnix.challenge.rut2019;

class ImprovedNaiveSolution implements Solution {
    @Override
    public int solution(int[] A, int K) {
        if (A.length == K) {
            return K;
        }
        int best = Math.min(A.length, 1 + K);
        int index = 0;
        while (index < A.length - 1) {
            int possibleBest = Math.min(A.length, A.length - index + K);
            if (best >= possibleBest) {
                return best;
            }
            int nextIndex = index + 1;
            int remainingK = K;
            int innerIndex = index + 1;
            while (innerIndex < A.length) {
                if (A[innerIndex] != A[index]) {
                    if (remainingK == 0) {
                        break;
                    }
                    remainingK--;
                } else if (remainingK == K) {
                    nextIndex++;
                }
                innerIndex++;
            }
            int count = innerIndex - index + Math.min(remainingK, index);
            best = Math.max(best, count);
            index = nextIndex;
        }
        return best;
    }
}
