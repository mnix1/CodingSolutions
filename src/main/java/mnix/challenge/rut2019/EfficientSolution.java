package mnix.challenge.rut2019;

import java.util.HashMap;
import java.util.Map;

class EfficientSolution implements Solution {
    @Override
    public int solution(int[] A, int K) {
        if (A.length == K) {
            return K;
        }
        Map<Integer, Integer> countOfAges = new HashMap<>(A.length);
        Map<Integer, Integer> previousIndexOfAges = new HashMap<>(A.length);
        int largestAge = 0;
        int countOfLargestAge = 0;
        for (int index = A.length - 1; index >= 0; index--) {
            int age = A[index];
            A[index] = previousIndexOfAges.getOrDefault(age, index);
            previousIndexOfAges.put(age, index);
            int count = countOfAges.getOrDefault(age, 0) + 1;
            if (count > countOfLargestAge) {
                largestAge = age;
                countOfLargestAge = count;
            }
            countOfAges.put(age, count);
        }
        int best = Math.min(A.length, 1 + K);
        int count = countOfAges.get(largestAge);
        int staringIndex = previousIndexOfAges.get(largestAge);
        int possibleBest = Math.min(A.length, count + K);
        if (best < possibleBest) {
            best = findBest(A, K, staringIndex, best);
        }
        countOfAges.remove(largestAge);
        for (Integer age : countOfAges.keySet()) {
            count = countOfAges.get(age);
            staringIndex = previousIndexOfAges.get(age);
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
        int gap;
        while (toIndex != nextIndex) {
            gap = nextIndex - toIndex - 1;
            remainingK -= gap;
            int result;
            if (remainingK >= 0) {
                result = nextIndex - fromIndex + remainingK + 1;
                toIndex = nextIndex;
                nextIndex = A[nextIndex];
            } else {
                if (gap > K) {
                    result = toIndex - fromIndex + 1;
                    fromIndex = nextIndex;
                    toIndex = nextIndex;
                    nextIndex = A[nextIndex];
                    remainingK = K;
                } else {
                    int newFromIndex = A[fromIndex];
                    gap = newFromIndex - fromIndex - 1;
                    fromIndex = newFromIndex;
                    remainingK += gap;
                    while (remainingK < 0) {
                        newFromIndex = A[fromIndex];
                        gap = newFromIndex - fromIndex - 1;
                        fromIndex = newFromIndex;
                        remainingK += gap;
                    }
                    result = nextIndex - fromIndex + remainingK + 1;
                    toIndex = nextIndex;
                    nextIndex = A[nextIndex];
                }
            }
            best = Math.min(A.length, Math.max(best, result));
        }
        return best;
    }
}
