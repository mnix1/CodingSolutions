package mnix.challenge.pal2020;

class EfficientSolution implements Solution {
    public int solution(int[] H) {
        int N = H.length;
        int[] maxToEnd = maxToEnd(H);
        int[] maxFromStart = maxFromStart(H);
        int minArea = maxToEnd[0] * N;
        for (int i = 0; i < N - 1; i++) {
            int leftArea = maxFromStart[i] * (i + 1);
            int rightArea = maxToEnd[i + 1] * (N - i - 1);
            minArea = Math.min(minArea, leftArea + rightArea);
        }
        return minArea;
    }

    private int[] maxFromStart(int[] H) {
        int[] maxHeightFromStart = new int[H.length];
        maxHeightFromStart[0] = H[0];
        for (int i = 1; i < H.length; i++) {
            maxHeightFromStart[i] = Math.max(maxHeightFromStart[i - 1], H[i]);
        }
        return maxHeightFromStart;
    }

    private int[] maxToEnd(int[] H) {
        int[] maxHeightToEnd = new int[H.length];
        maxHeightToEnd[H.length - 1] = H[H.length - 1];
        for (int i = H.length - 2; i >= 0; i--) {
            maxHeightToEnd[i] = Math.max(maxHeightToEnd[i + 1], H[i]);
        }
        return maxHeightToEnd;
    }
}
