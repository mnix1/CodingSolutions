package mnix.challenge.tec2019;

import java.util.*;
import java.util.stream.Collectors;

class NaiveSolution implements Solution {
    @Override
    public String solution(int[][] A) {
        int bestSum = 0;
        int[] bestSequence = null;
        for (int[] sequence : findSequences(A)) {
            int sum = Arrays.stream(sequence).sum();
            if (sum > bestSum) {
                bestSequence = sequence;
                bestSum = sum;
            }
        }
        return sequenceToString(bestSequence);
    }

    private long uniqueSequencesCount(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        long[][] possibilityCount = new long[N][M];
        for (int n = 0; n < N; n++) {
            if (n == 0) {
                for (int m = 0; m < M; m++) {
                    possibilityCount[n][m] = 1;
                }
            } else {
                for (int m = 0; m < M; m++) {
                    if (m == 0) {
                        possibilityCount[n][m] = 1;
                    } else {
                        possibilityCount[n][m] = possibilityCount[n][m - 1] + possibilityCount[n - 1][m];
                    }
                }
            }
        }
        return possibilityCount[N - 1][M - 1];
    }

    private Collection<int[]> findSequences(int[][] A) {
        Set<String> stringMoves = new HashSet<>();
        List<int[]> moves = new ArrayList<>();
        int N = A.length;
        int M = A[0].length;
        long uniqueSequencesCount = uniqueSequencesCount(A);
        Random random = new Random();
        while (moves.size() < uniqueSequencesCount) {
            int sequenceLength = 0;
            int[] sequence = new int[N + M - 2];
            int n = N - 1;
            int m = M - 1;
            while (n > 0 && sequenceLength != sequence.length) {
                int index = random.nextInt(sequence.length);
                if (sequence[index] != 0) {
                    continue;
                }
                sequence[index] = 1;
                n--;
                sequenceLength++;
            }
            while (m > 0 && sequenceLength != sequence.length) {
                int index = random.nextInt(sequence.length);
                if (sequence[index] != 0) {
                    continue;
                }
                sequence[index] = 9;
                m--;
                sequenceLength++;
            }
            String stringSequence = sequenceToString(sequence);
            if (!stringMoves.contains(stringSequence)) {
                stringMoves.add(stringSequence);
                moves.add(sequence);
            }
        }
        Collection<int[]> sequences = findSequences(A, moves);
        return sequences;
    }

    private Collection<int[]> findSequences(int[][] A, List<int[]> moves) {
        return moves.stream().map(move -> {
            int n = 0;
            int m = 0;
            int[] sequence = new int[A.length + A[0].length - 1];
            int digit = A[n][m];
            sequence[0] = digit;
            for (int i = 0; i < move.length; i++) {
                int direction = move[i];
                if (direction == 1) {
                    n++;
                } else {
                    m++;
                }
                digit = A[n][m];
                sequence[i + 1] = digit;
            }
            return sequence;
        }).collect(Collectors.toList());
    }

    private String sequenceToString(int[] sequence) {
        return Arrays.stream(sequence)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
    }
}
