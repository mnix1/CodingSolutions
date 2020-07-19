package mnix.challenge.rho2019;

import java.util.HashSet;
import java.util.Set;

class NaiveSolution implements Solution {
    @Override
    public int solution(int[] T) {
        Link[] links = generateLinks(T);
        int acceptedVacations = 0;
        for (int a = 0; a < T.length; a++) {
            for (int b = a; b < T.length; b++) {
                if (acceptedVacation(links, a, b)) {
                    acceptedVacations++;
                }
            }
        }
        return acceptedVacations;
    }

    private boolean acceptedVacation(Link[] links, int a, int b) {
        if (a == b) {
            return true;
        }
        for (int i = a; i < b; i++) {
            if (!hasLinkTo(links, i, i + 1, -1, a, b)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasLinkTo(Link[] links, int sourceIndex, int targetIndex, int checkedIndex, int minIndex, int maxIndex) {
        if (links[sourceIndex].hasLink(targetIndex)) {
            return true;
        }
        for (int neighbourIndex : links[sourceIndex].links) {
            if (neighbourIndex == checkedIndex || neighbourIndex < minIndex || neighbourIndex > maxIndex) {
                continue;
            }
            if (hasLinkTo(links, neighbourIndex, targetIndex, sourceIndex, minIndex, maxIndex)) {
                return true;
            }
        }
        return false;
    }

    private Link[] generateLinks(int[] T) {
        Link[] links = new Link[T.length];
        for (int i = 0; i < T.length; i++) {
            links[i] = new Link();
        }
        for (int i = 0; i < T.length; i++) {
            int targetNodeIndex = T[i];
            links[i].addLink(targetNodeIndex);
            links[targetNodeIndex].addLink(i);
        }
        return links;
    }

    static class Link {
        Set<Integer> links = new HashSet<>();

        void addLink(int i) {
            links.add(i);
        }

        boolean hasLink(int i) {
            return links.contains(i);
        }
    }
}
