class Solution {
    public int climbStairs(int n) {
        int[] numSteps = new int[n];
        for (int i = 0; i < numSteps.length; i++) {
            if (i == 0) {
                numSteps[i] = 1;
                continue;
            } else if (i == 1) {
                numSteps[i] = 2;
                continue;
            }
            numSteps[i] = numSteps[i-1] + numSteps[i-2]; 
        }
        return numSteps[n -1];
    }
}