package leetcode.top100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/k-closest-points-to-origin/submissions/
public class KCloset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{1,3}, {5,1},{4,2},{2,-2}};
		int[][] result = kClosest(points, 1);
		Arrays.copyOfRange(result, 0, 1);
	}

	public static int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][2];
        Arrays.sort(points, new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		double d1 = Math.sqrt((o1[0] * o1[0]) + (o1[1] * o1[1]));
        		double d2 = Math.sqrt((o2[0] * o2[0]) + (o2[1] * o2[1]));
        		if (d1 < d2) return -1;
        		if (d1 == d2) return 0;
        		return 1;
        	}
        }); 
        for (int i=0; i < K; i++) {
        		result[i] = points[i];
        }
        return result;
    }
	
	public static int[][] kClosest2(int[][] points, int K) {
		int[][] result = new int[K][2];
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return ((o1[0] * o1[0]) + (o1[1] * o1[1])) - ((o2[0] * o2[0]) + (o2[1] * o2[1]));
			}
		});
		for (int i=0; i < points.length; i++) {
			q.add(points[i]);
		}
		for (int i = 0; i < K; i++) {
			result[i] = q.poll();
		}
		return result;
	}
}
