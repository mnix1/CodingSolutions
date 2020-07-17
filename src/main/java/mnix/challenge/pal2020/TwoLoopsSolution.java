package mnix.challenge.pal2020;

class TwoLoopsSolution implements Solution {
    public int solution(int[] H) {
        int N = H.length;
        int minTotalArea = Integer.MAX_VALUE;
        int maxLeftHeight = 0;
        for (int leftIndex = 0; leftIndex < N; leftIndex++) {
            maxLeftHeight = Math.max(maxLeftHeight, H[leftIndex]);
            int leftWidth = leftIndex + 1;
            int leftArea = area(leftWidth, maxLeftHeight);
            int rightArea = rightArea(H, leftIndex, leftWidth);
            minTotalArea = Math.min(minTotalArea, leftArea + rightArea);
        }
        return minTotalArea;
    }

    private int rightArea(int[] H, int leftIndex, int leftWidth) {
        int maxRightHeight = 0;
        for (int rightIndex = leftIndex + 1; rightIndex < H.length; rightIndex++) {
            maxRightHeight = Math.max(maxRightHeight, H[rightIndex]);
        }
        int rightWidth = H.length - leftWidth;
        return area(rightWidth, maxRightHeight);
    }

    private int area(int width, int height) {
        return width * height;
    }
}
