package mnix.challenge.rut2019;

import java.util.HashMap;
import java.util.Map;

class EfficientSolution implements Solution {
    @Override
    public int solution(int[] A, int K) {
        if (A.length == K) {
            return K;
        }
        Map<Integer, Integer> countOfAge = new HashMap<>();
        Map<Integer, Integer> previousIndexOfAge = new HashMap<>();
        for (int index = A.length - 1; index >= 0; index--) {
            int age = A[index];
            A[index] = previousIndexOfAge.getOrDefault(age, index);
            previousIndexOfAge.put(age, index);
            countOfAge.compute(age, (key, oldValue) -> oldValue == null ? 1 : oldValue + 1);
        }
        int best = Math.min(A.length, 1 + K);
        for (Integer age : previousIndexOfAge.keySet()) {
            int possibleBest = Math.min(A.length, countOfAge.get(age) + K);
            if (best >= possibleBest) {
                continue;
            }
            int fromIndex = previousIndexOfAge.get(age);
            int remainingK = K;
            int toIndex = fromIndex;
            int nextIndex = A[toIndex];
            while (toIndex != nextIndex) {
                int gaps = nextIndex - toIndex - 1;
                remainingK -= gaps;
                int result;
                if (remainingK >= 0) {
                    result = nextIndex - fromIndex + remainingK + 1;
                    toIndex = nextIndex;
                    nextIndex = A[nextIndex];
                } else {
                    result = toIndex - fromIndex + 1;
                    remainingK = K;
                    if (gaps > K) {
                        fromIndex = nextIndex;
                        toIndex = nextIndex;
                        nextIndex = A[nextIndex];
                    } else {
                        fromIndex = A[fromIndex];
                        toIndex = fromIndex;
                        nextIndex = A[toIndex];
                    }
                }
                best = Math.min(A.length, Math.max(best, result));
            }
        }
        return best;
    }
}
