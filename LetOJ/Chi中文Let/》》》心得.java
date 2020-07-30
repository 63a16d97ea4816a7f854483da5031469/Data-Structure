





 剑指offer，需要看，这个对面试很有帮助。有一些题目是剑指offer上的。








































 











public class Solution {
	public boolean Find(int target, int[][] array) {
		int col = array[0].length;
		int row = array.length;
		int i = 0;
		int j = col - 1;
		while (i<= row - 1 && j >= 0) {
			if (array[i][j] == target) {
				return true;
			} else if (array[i][j]<target) {
				i++;
			} else if (array[i][j] > target) {
				j--;
			}
		}
		return false;
	}
}








