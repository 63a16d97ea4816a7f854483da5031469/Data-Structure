
/*
 * 
https://juejin.im/post/5cac107ee51d456e7079f1d5



13 June 2020 at 3:52 pm


对题目易错地方进行总结:


对题目的实现思路进行几句话总结:


从这道题目学到了什么，哪些地方需要提升? :




 * 
 */


// 总结一下就是，计数排序只能用在取值范围不大的场景，而且只能为非负整数排序

//a是数组A， n为数组a的大小。假设数组中的元素都为非负数
public void countingSort(int[] a, int n) {
	if (n <= 1) {
		return;
	}
	//查找数组中数据的范围
	int max = a[0];
	for (int i = 1; i < n; i++) {
		if (max < a[i]) {
			max = a[i];
		}
	}

	//申请一个计数数组
	int[] c = new int[max + 1];
	for (int i = 0; i < n; ++i) {
		c[a[i]]++;
	}

	//依次累加
	for (int i = 1; i < max; i++) {
		c[i] = c[i - 1] + c[i];
	}

	//临时数组r，存储排序之后的结果
	int[] r = new int[n];
	//计数排序的关键步骤
	for (int i = n - 1; i > 0; i--) {
		int index = c[a[i]] - 1;
		r[index] = a[i];
		c[a[i]]--;
	}
}




















