
// https://leetcode.com/problems/moving-average-from-data-stream/ 

public class MovingAverageData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingAverage m = new MovingAverage(3);
		System.out.println(m.next(1)); //= 1;
		System.out.println(m.next(10)); //= (1 + 10) / 2
		System.out.println(m.next(3)); //= (1 + 10 + 3) / 3
		System.out.println(m.next(5)); //= (10 + 3 + 5) / 3

	}

}

class MovingAverage {
	int[] data;
	int nextIndex;
	int sum;
	int windowLength;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        data = new int[size];
        nextIndex = 0;
        sum = 0;
    }
    
    public double next(int val) {
    		if (windowLength <=0 || windowLength <= 2) windowLength++; 
        sum = sum - data[nextIndex];
    		data[nextIndex] = val;
    		sum = sum + data[nextIndex];
    		double avg = (double)sum/windowLength;
    		nextIndex = (nextIndex + 1) % windowLength;
    		return avg;
        
    }
}
