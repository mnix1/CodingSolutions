package mnix.challenge.rut2019;

import java.util.HashMap;
import java.util.Map;

class EfficientSolution implements Solution {
    @Override
    public int solution(int[] A, int K) {
        if (A.length == K) {
            return K;
        }
        Map<Integer, Integer> countOfAge = new HashMap<>(A.length);
        Map<Integer, Integer> previousIndexOfAge = new HashMap<>(A.length);
        int maxCountAge = 0;
        int maxCount = 0;
        for (int index = A.length - 1; index >= 0; index--) {
            int age = A[index];
            A[index] = previousIndexOfAge.getOrDefault(age, index);
            previousIndexOfAge.put(age, index);
            int count = countOfAge.getOrDefault(age, 0) + 1;
            if (count > maxCount) {
                maxCountAge = age;
                maxCount = count;
            }
            countOfAge.put(age, count);
        }
        int best = Math.min(A.length, 1 + K);
        int count = countOfAge.get(maxCountAge);
        int staringIndex = previousIndexOfAge.get(maxCountAge);
        int possibleBest = Math.min(A.length, count + K);
        if (best < possibleBest) {
            best = findBest(A, K, staringIndex, best);
        }
        countOfAge.remove(maxCountAge);
        for (Integer age : countOfAge.keySet()) {
            count = countOfAge.get(age);
            staringIndex = previousIndexOfAge.get(age);
            possibleBest = Math.min(A.length, count + K);
            if (best < possibleBest) {
                best = findBest(A, K, staringIndex, best);
            }
        }
        return best;
    }

    private int findBest(int[] A, int K, int fromIndex, int best) {
        int remainingK = K;
        int toIndex = fromIndex;
        int nextIndex = A[toIndex];
        int gaps;
        while (toIndex != nextIndex) {
            gaps = nextIndex - toIndex - 1;
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
                } else if (gaps == K) {
                    fromIndex = toIndex;
                    if (fromIndex == A[fromIndex - 1]) {
                        fromIndex--;
                    }
                } else {
                    fromIndex = A[fromIndex];
                    toIndex = fromIndex;
                    nextIndex = A[toIndex];
                }
            }
            best = Math.min(A.length, Math.max(best, result));
        }
        return best;
    }
}
