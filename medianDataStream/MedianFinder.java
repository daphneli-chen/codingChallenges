class MedianFinder {
    PriorityQueue<Integer> low; //should contain the lower half of the numbers
    PriorityQueue<Integer> high; //should contain the upper half of the numbers
    
    // when you add a number if it's greater than the min of the high, add to the high
    // if it's less than the max of the low, add to the low
    // your low should at most have 1 more than the high, we'll just have that be the rule so
    // looking at the sizes, if the low is now 2 greater than the high pop off the greatest element and add to the high
    //if the high is 1 greater than the low you want to add the min of the high to the low

    /** initialize your data structure here. */
    public MedianFinder() {
        low = new PriorityQueue<>(11, new Comparator<Integer>() {
            @Override 
            public int compare(Integer a, Integer b) {
                return b-a;
            }
        }); //this creates a max heap 
        high = new PriorityQueue<>();
        
    }
    
    public void addNum(int num) {
        if (low.isEmpty()) {
            low.add(num);
            return;
        }
        if (low.size() == high.size()) { //we can just add one to low if needed
            if (num > high.peek()) {
                int transfer = high.poll();
                low.add(transfer);
                high.add(num);
            } else {
                low.add(num); // just add it to low
            }
        } else {
            if (num < low.peek()) {
                int transfer = low.poll();
                high.add(transfer);
                low.add(num);
            } else { //can just add to high
                high.add(num);
            }
            
        }
    }
    
    public double findMedian() {
        if (low.size() == high.size()) {
            return (1.0*(low.peek() + high.peek()))/2.0;
        } else {
            return low.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */