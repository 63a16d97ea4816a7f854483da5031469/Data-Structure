

剑指offer，需要看，这个对面试很有帮助。有一些题目是剑指offer上的。


需要练习在白板的编译器上写code，锻炼不出错的能力。


需要练习写Pseudo-Code的能力，以此来提高自己的编程能力。


坚持，坚持，再坚持。。。。。这个是秘诀。































 











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








