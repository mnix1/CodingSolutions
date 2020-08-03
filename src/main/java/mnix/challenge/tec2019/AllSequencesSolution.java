package mnix.challenge.tec2019;

import java.util.*;
import java.util.stream.Collectors;

class AllSequencesSolution implements Solution {
    @Override
    public String solution(int[][] A) {
        String bestSequence = "";
        for (String sequence : findSequences(A)) {
            if (sequence.compareTo(bestSequence) > 0) {
                bestSequence = sequence;
            }
        }
        return bestSequence;
    }

    private long uniqueSequencesCount(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        long[][] possibilityCount = new long[N][M];
        for (int m = 0; m < M; m++) {
            possibilityCount[0][m] = 1;
        }
        for (int n = 1; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (m == 0) {
                    possibilityCount[n][m] = 1;
                } else {
                    possibilityCount[n][m] = possibilityCount[n][m - 1] + possibilityCount[n - 1][m];
                }
            }
        }
        return possibilityCount[N - 1][M - 1];
    }

    private Collection<String> findSequences(int[][] A) {
        Set<String> stringMoves = new HashSet<>();
        List<int[]> moves = new ArrayList<>();
        int N = A.length;
        int M = A[0].length;
        long uniqueSequencesCount = uniqueSequencesCount(A);
        Random random = new Random();
        while (moves.size() < uniqueSequencesCount) {
            int[] sequence = new int[N + M - 2];
            int n = N - 1;
            while (n > 0) {
                int index = random.nextInt(sequence.length);
                if (sequence[index] != 0) {
                    continue;
                }
                sequence[index] = 1;
                n--;
            }
            String stringSequence = sequenceToString(sequence);
            if (!stringMoves.contains(stringSequence)) {
                stringMoves.add(stringSequence);
                moves.add(sequence);
            }
        }
        return findSequences(A, moves);
    }

    private Collection<String> findSequences(int[][] A, List<int[]> moves) {
        return moves.stream().parallel()
                .map(move -> {
                    int n = 0;
                    int m = 0;
                    StringBuilder sequence = new StringBuilder(A.length + A[0].length - 1);
                    sequence.append(A[n][m]);
                    for (int direction : move) {
                        if (direction == 1) {
                            n++;
                        } else {
                            m++;
                        }
                        sequence.append(A[n][m]);
                    }
                    return sequence.toString();
                }).collect(Collectors.toList());
    }

    private String sequenceToString(int[] sequence) {
        return Arrays.stream(sequence)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining());
    }
}
