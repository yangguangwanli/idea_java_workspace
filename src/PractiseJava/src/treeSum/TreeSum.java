package treeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//参考学习
public class TreeSum {
//给定一个n个元素的数组，是否存在a，b，c三个元素，使用得a+b+c=0，
//找出所有符合这个条件的三元组

//思路
//1. 先将数组排序
//
//2.循环遍历数组元素，采用双指针法，如：当前元素下标为 i ，则低指针为  i+1， 高指针为 arr.length - 1 .
//
//3. 如果三下标所对应元素的和 大于0，则 高指针减小一，如果和小于0则低指针加一， 否则 则等于 0。
//
//4. 如果等于0，再判断有没有重复元素

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new LinkedList<>();
		if (nums != null && nums.length > 2) {
			// 先对数组进行排序
			Arrays.sort(nums);
			// i表示假设取第i个数作为结果
			for (int i = 0; i < nums.length - 2;) {
				// 第二个数可能的起始位置
				int j = i + 1;
				// 第三个数可能是结束位置
				int k = nums.length - 1;
				while (j < k) {
					// 如果找到满足条件的解
					if (nums[j] + nums[k] + nums[i] == 0) {
						// 将结果添加到结果含集中
						List<Integer> list = new ArrayList<>(3);
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);
						result.add(list);

						// 移动到下一个位置，找下一组解
						k--;
						j++;

						// 从左向右找第一个与之前处理的数不同的数的下标，避免重复数据
						while (j < k && nums[j] == nums[j - 1]) {
							j++;
						}
						// 从右向左找第一个与之前处理的数不同的数的下标，避免重复数据
						while (j < k && nums[k] == nums[k + 1]) {
							k--;
						}
					}
					// 和大于0
					else if (nums[j] + nums[k] + nums[i]> 0) {
						k--;
						// 从右向左找第一个与之前处理的数不同的数的下标，避免重复数据
						while (j < k && nums[k] == nums[k + 1]) {
							k--;
						}
					}
					// 和小于0
					else {
						j++;
						// 从左向右找第一个与之前处理的数不同的数的下标，避免重复数据
						while (j < k && nums[j] == nums[j - 1]) {
							j++;
						}
					}
				}

				// 指向下一个要处理的数
				i++;
				// 从左向右找第一个与之前处理的数不同的数的下标，仍然是避免重复的数据
				while (i < nums.length - 2 && nums[i] == nums[i - 1]) {
					i++;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(arr));
	}
}
