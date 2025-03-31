class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int maxValue = Integer.MIN_VALUE, currMax = Integer.MIN_VALUE;
		for (int i = 0; i < values.length; i++) {
			maxValue = Math.max(maxValue, currMax + values[i] - i);
			currMax = Math.max(currMax, values[i] + i);
		}
		return maxValue;
    }
}