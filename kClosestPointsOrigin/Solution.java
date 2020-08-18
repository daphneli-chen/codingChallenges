class Solution {
    int[][] points;
    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        quickselect(0, points.length -1, K);
        return Arrays.copyOfRange(points, 0, K);
    }
    
    
    private void quickselect(int low, int high, int k) {
        if (low >= high) return;
        int pivotIndex = low + (int)((float)(high - low) * Math.random());
        //swap last element with pivot element
        int[] pivot = points[pivotIndex];
        swap(pivotIndex, high);
        
        int swapTo = low - 1;
        for (int i = low; i < high; i++) {
            if (compare(points[i], pivot) <= 0) {
                swapTo++;
                swap(swapTo, i);
            }
        }
        pivotIndex = swapTo + 1;
        swap(pivotIndex, high); //puts pivot in correct position
        int leftLength = pivotIndex - low + 1;
        if (k < leftLength ) { // sorted too many, need to sort on left swide
            quickselect(low, pivotIndex -1, k);
        } else if (k > leftLength) {
            quickselect(pivotIndex + 1, high, k - leftLength);
        }
        
    }

    
    private int compare(int[] point1, int[] point2) {
        double dist1 = Math.sqrt(Math.pow(point1[0], 2) + Math.pow(point1[1], 2));
        double dist2 = Math.sqrt(Math.pow(point2[0], 2) + Math.pow(point2[1], 2));
        double diff = dist1 - dist2;
        if (diff > 0) return 1;
        else if (diff < 0) return -1;
        else return 1;
    }
    
    private void swap(int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}