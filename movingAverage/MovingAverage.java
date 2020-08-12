class MovingAverage {
    /**
    * O(n) runtime where n is the size of the window
    * O(1) space complexity (uses a circular array)
    **/
    private int maxSize;
    private int[] elements;
    private int currSize = 0; //the current number of elements in the stream
    private int nextIndex = 0; //the next index to write an element to

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        assert size > 0;
        maxSize = size;
        elements = new int[size];
    }

    public double next(int val) {
        if (nextIndex > maxSize - 1) {
            nextIndex = 0; //looping around to write over old data no longer in the window
        }
        elements[nextIndex] = val;
        nextIndex++;
        if (currSize < maxSize) {
            currSize++;
        }

        int sum = 0;
        for (int i = 0; i < currSize; i++) {
            sum += elements[i];
        }
        return (sum * 1.0)/(float)currSize;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
