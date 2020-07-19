package mnix.challenge.rho2019;

import java.util.HashMap;
import java.util.Map;

class EfficientSolution implements Solution {

    @Override
    public int solution(int[] T) {
        int validVacations = 0;
        for (int a = 0; a < T.length - 1; a++) {
            int aTarget = T[a];
            Map<Integer, Integer> notCorrectTargets = new HashMap<>();
            int notCorrect = 1;
            if (aTarget != a) {
                notCorrectTargets.put(aTarget, 1);
            }
            for (int b = a + 1; b < T.length; b++) {
                int bTarget = T[b];
                if (notCorrectTargets.containsKey(b)) {
                    notCorrect -= notCorrectTargets.get(b);
                }
                boolean inRange = a <= bTarget && bTarget <= b;
                if (!inRange) {
                    if (notCorrectTargets.containsKey(bTarget)) {
                        notCorrectTargets.put(bTarget, notCorrectTargets.get(bTarget) + 1);
                    } else {
                        notCorrectTargets.put(bTarget, 1);
                    }
                    notCorrect++;
                } else if (b == bTarget) {
                    notCorrect++;
                }
                if (notCorrect <= 1) {
                    validVacations++;
                }
            }
        }
        return validVacations + T.length;
    }
}
