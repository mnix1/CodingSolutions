package mnix.challenge.rut2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UglyComplicatedSolution implements Solution {
    @Override
    public int solution(int[] A, int K) {
        if (A.length == K) {
            return K;
        }
        Map<Integer, List<Integer>> ageIndexes = new HashMap<>();
        for (int index = 0; index < A.length; index++) {
            int age = A[index];
            List<Integer> indexes = ageIndexes.getOrDefault(age, new ArrayList<>());
            indexes.add(index);
            ageIndexes.put(age, indexes);
        }
        return ageIndexes.values().stream()
                .sorted((a, b) -> -Integer.compare(a.size(), b.size()))
                .reduce(Math.min(A.length, 1 + K), (best, indexes) -> findBest(A.length, K, indexes, best), Math::max);
    }

    private int findBest(int N, int K, List<Integer> indexes, int best) {
        int bestPossibleResultForAge = Math.min(N, indexes.size() + K);
        if (best >= bestPossibleResultForAge) {
            return best;
        }
        return Math.max(best, new BestResultFinder(N, K, indexes).find());
    }

    static class BestResultFinder {
        private int bestResult = 0;
        private int actualResult = 1;
        private int nextElementToReplace = 0;
        private int missingElement;
        private int missingElements;
        private int remainingReplacements;
        private final int N;
        private final int K;
        private final List<Integer> elements;
        private final int[] resultBeforeElementReplacement;

        BestResultFinder(int N, int K, List<Integer> elements) {
            this.elements = elements;
            this.N = N;
            this.K = K;
            this.resultBeforeElementReplacement = new int[K];
        }

        int find() {
            remainingReplacements = K;
            maybeReplaceFirstElement();
            for (int i = 1; i < elements.size(); i++) {
                missingElements = elements.get(i) - elements.get(i - 1) - 1;
                if (missingElements == 0) {
                    actualResult++;
                } else if (remainingReplacements > 0) {
                    replaceAvailableBooks();
                    if (missingElement == missingElements) {
                        actualResult++;
                    } else {
                        swapReplacementsOfBooks();
                    }
                } else if (K == 0) {
                    actualResult = 1;
                } else {
                    missingElement = 0;
                    swapReplacementsOfBooks();
                }
                updateBestResult();
            }
            return Math.max(bestResult, Math.min(actualResult + remainingReplacements, N));
        }

        private void updateBestResult() {
            bestResult = Math.max(bestResult, actualResult);
        }

        private void increaseNextElementToReplace() {
            nextElementToReplace = (nextElementToReplace + 1) % K;
        }

        private void maybeReplaceFirstElement() {
            if (elements.get(0) == 1 && remainingReplacements > 0) {
                resultBeforeElementReplacement[nextElementToReplace] = 0;
                remainingReplacements--;
                increaseNextElementToReplace();
                actualResult++;
            }
        }

        private void replaceAvailableBooks() {
            missingElement = 0;
            while (remainingReplacements > 0 && missingElement < missingElements) {
                resultBeforeElementReplacement[nextElementToReplace] = actualResult;
                increaseNextElementToReplace();
                actualResult++;
                remainingReplacements--;
                missingElement++;
                updateBestResult();
            }
        }

        private void swapReplacementsOfBooks() {
            while (missingElement < missingElements) {
                actualResult -= resultBeforeElementReplacement[nextElementToReplace];
                for (int k = 0; k < K; k++) {
                    if (k != nextElementToReplace) {
                        resultBeforeElementReplacement[k] -= resultBeforeElementReplacement[nextElementToReplace] + 1;
                    }
                }
                resultBeforeElementReplacement[nextElementToReplace] = actualResult - 1;
                missingElement++;
                increaseNextElementToReplace();
                updateBestResult();
            }
            if (missingElement == missingElements) {
                actualResult++;
            }
        }
    }
}
