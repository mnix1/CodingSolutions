package mnix.challenge.rut2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NiceSolution implements Solution {
    @Override
    public int solution(int[] A, int K) {
        if (A.length == K) {
            return K;
        }
        Map<Integer, List<Integer>> ageToBooksIndexes = new HashMap<>();
        for (int index = 0; index < A.length; index++) {
            int bookAge = A[index];
            List<Integer> booksIndexes = ageToBooksIndexes.getOrDefault(bookAge, new ArrayList<>());
            booksIndexes.add(index);
            ageToBooksIndexes.put(bookAge, booksIndexes);
        }
        int best = Math.min(A.length, 1 + K);
        for (List<Integer> sameAgeBooksIndexes : ageToBooksIndexes.values()) {
            best = findBest(A.length, K, sameAgeBooksIndexes, best);
        }
        return best;
    }

    private int findBest(int N, int K, List<Integer> indexes, int best) {
        int possibleBest = Math.min(N, indexes.size() + K);
        if (best >= possibleBest) {
            return best;
        }
        int index = 0;
        while (index < indexes.size()) {
            int remainingK = K;
            int innerIndex = index + 1;
            while (innerIndex < indexes.size()) {
                int gaps = indexes.get(innerIndex) - indexes.get(innerIndex - 1) - 1;
                remainingK -= gaps;
                if (remainingK < 0) {
                    break;
                }
                innerIndex++;
            }
            int result = innerIndex - index + K;
            best = Math.min(N, Math.max(best, result));
            index++;
        }
        return best;
    }
}
