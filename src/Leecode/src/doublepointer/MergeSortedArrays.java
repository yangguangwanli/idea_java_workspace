package doublepointer;

public class MergeSortedArrays {
//			Input:
//			nums1 = [1,2,3,0,0,0], m = 3
//			nums2 = [2,5,6],       n = 3
//
//			Output: [1,2,2,3,5,6]

	
//  题目描述：把归并结果存到第一个数组上。
//  需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值
	public static void main(String[] args) {

	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		//传入的m、n为数组长度，index为下标
		int index1 = m - 1, index2 = n - 1;
		//m+n-1是归并到数组1后的数组长度
		int indexMerge = m + n - 1;
		//只要数组2还有值就继续循环
		while (index2 >= 0) {
			//说明数组1的所有元素已经放完了，剩下的按数组2顺序放入
			if (index1 < 0) {
				nums1[indexMerge--] = nums2[index2--];
			//数组2放完了，就放数组1剩下的数
			} else if (index2 < 0) {
				nums1[indexMerge--] = nums1[index1--];
				//以上为特殊情况，以下是循环比较两个数组的数值，再顺序放入
			} else if (nums1[index1] > nums2[index2]) {
				nums1[indexMerge--] = nums1[index1--];
			} else {
				nums1[indexMerge--] = nums2[index2--];
			}
		}
	}

}
