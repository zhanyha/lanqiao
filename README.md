# 基础算法总结

## 一：插入排序
### 1. 直接插入排序

```java
	public void insertSort(int[] arr, int len) {
        int i, j;
        for (i = 2; i < len; i++) {
            if (arr[i] < arr[i - 1]) {
                arr[0] = arr[i];//arr[0]为哨兵，不作排序的元素
                for (j = i - 1; arr[j] > arr[0]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = arr[0];
            }
        }
    }
```

### 2. 折半插入排序

```java
	public void insertSort02(int[] arr, int len) {
        int i, j, low, high, mid = 0;
        for (i = 2; i < len; i++) {
            if (arr[i] < arr[i - 1]) {
                low = 1;
                high = i;
                arr[0] = arr[i];//arr[0]不作为排序元素
                while (low <= high) {//二分搜索，注意临界条件
                    mid = low + ((high - low) >> 1);
                    if (arr[mid] < arr[0]) low = mid + 1;
                    else high = mid - 1;
                }
                for (j = i - 1; j >= high + 1; j--)
                    arr[j + 1] = arr[j];
                arr[high + 1] = arr[0];
            }
        }
    }
```

### 3. 希尔排序
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200507001343375.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2lkZWZpbmVk,size_16,color_FFFFFF,t_70)

```java
	public void shellSort(int[] arr, int len) {
        int i, j, tmp;
        for (int dk = len / 2; dk >= 1; dk /= 2) //步长,最小为1
            for (i = dk; i < len; i++)          // 接下来就是直接插入排序
                if (arr[i] < arr[i - dk]) {
                    tmp = arr[i];                //暂存于tmp中
                    for (j = i - dk; j >= 0 && arr[j] > tmp; j -= dk)
                        arr[j + dk] = arr[j];
                    arr[j+dk] = tmp;
                }
    }
```

##  交换排序
### 1. 冒泡排序

```java
	 public void bubbleSort(int[] arr, int len) {
        int i, j;
        boolean flag = false;
        for (i = len - 1; i >= 0; i--) {
            for (j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if(!flag)
                break;
        }
    }
```
### 2. 快速排序

	双向扫描分区法

==注意临界条件的判断==
```java
import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pos = partition(nums, start, end);
            quickSort(nums, start, pos - 1);
            quickSort(nums, pos + 1, end);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int base = start;
        int left = base + 1;
        int right = end;
        while(left <= right){//在我的算法中，临界条件全部是left<=right,一定要注意。
            while (left <= right && nums[left] <= nums[base]){
                left++;
            }
            while (left <= right && nums[right] >= nums[base]){
                right--;
            }
            if(left < right)
                swap(nums,left,right);
        }
        swap(nums,base,right);
        return right;
    }

    private void swap(int[] nums, int base, int right) {
        int t = nums[base];
        nums[base] = nums[right];
        nums[right] = t;
    }
}
```
==可优化的地方：== 优化的地方在于`base`的取值


## 选择排序
### 1. 简单选择排序
**思想：** 每`i`趟在下标为`i`的后面数组中的数字找找到最小的数字，并且与`arr[i]`比较。如果小就交换。
这样每次就确定了第`i`个数的位置，以后都不改变
```java
 	public void selectSort(int[] arr, int n) {
        int min;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            if (min != i) swap(arr, min, i);
        }
    }
```
### 2. 堆排序

1. 什么是堆
   **概念：** 二叉堆是一个完全二叉树
   **特性:**
   `1)`. 父节点的键值总是大于等于（或者小于等于）任何一个子节点的键值
   `2)`. 每个节点的左右子树都是一个二叉堆（要么是大顶堆要么是小顶堆）

2. 思想：
   **2.1**  把数组大/小顶堆化（因为叶子结点不具有孩子节点，所以已经满足堆的要求了。所以要从`A.lenth/2 - 1 `的位置开始调用辅助构造方法来保证该节点作为根节点时，对于整个堆来说，这个局部时大顶堆或者小顶堆）
   **2.2** 设计辅助构造大小顶堆的方法
   传入数组，局部根节点的索引，和数组最后节点的索引。来保证局部是大/小顶堆
   **2.3.** 让根节点每次都和最后一个元素交换，但是比较完一次后，数组的最后一个元素要减 `1` 。然后调用辅助构造大/小顶堆的方法，重新构造出一个长度减1的大/小顶堆。这样数组从最后一个位置开始依次往前被填充有序数据。直到整个数组有序

```java
import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--)
            maxHeapize(nums, i, len - 1);
        while (len > 0) {
            len -= 1;
            swap(nums, 0, len);
            maxHeapize(nums, 0, len - 1);
        }
    }

    private void maxHeapize(int[] nums, int root, int len) {
        int lch = root * 2 + 1;
        int rch = root * 2 + 2;
        if (rch > len) {//说明无右孩子
            if (lch > len) {//说明也无左孩子，那么就是叶子节点
                return;
            }
            //存在左孩子,而无右孩子
            if (nums[lch] < nums[root])
                return;
            swap(nums, lch, root);
            maxHeapize(nums, lch, len);//左孩子继续向下调整
        } else {
            //说明有左右孩子,注意不存在只有右孩子，没有左孩子的情况。
            int max = Math.max(nums[lch], nums[rch]);
            if (nums[root] >= max) return;
            if (nums[lch] > nums[rch]) {
                swap(nums, lch, root);
                maxHeapize(nums, lch, len);
            } else {
                swap(nums, rch, root);
                maxHeapize(nums, rch, len);
            }
        }
    }
    private void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
```

### 归并排序和基数排序
### 1. 归并排序

1. 和快速排序的区别

   1.不用把大的和小的分区
   2.需要新的辅助空间（拷贝原数组）
   3.归并排序的有序性是靠分别比较两个区的头位置

`merge`的参数
`void merge(arr,start,mid,end)`
```java
import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = start + ((end - start) >> 1);
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }

    public void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 2, 6, 9, 8, 7};
        System.out.println(Arrays.toString(new Solution().sortArray(nums)));
    }
}
```



### 2. 基数排序

**思想**
第一次按个位数将各个数字分配到0~9号桶当中然后出桶
第二次按十位数将各个数字分配到0~9号桶当中然后出桶。。。。。依次类推
> 通常用于十进制数字

```cpp
class Solution {
    public int[] radixSort(int[] nums) {
        int[] res = fixAndGetMaxLen(nums);//基数排序解决存在负数的情况，先调整数组
        int min = res[0];
        int size = res[1];
        int[][] buckets = new int[10][nums.length];
        int[] p = new int[10];//记录每个桶的最后一个元素的位置
        int n = 1;
        for (int i = 0; i < size; i++) {//进行n次按关键字排序, 采取的方式：LSD（最低为优先）
            for (int j = 0; j < nums.length; j++) {
                int m = (nums[j] / n) % 10;
                buckets[m][p[m]] = nums[j];
                p[m]++;//指向桶中存下一个数的位置
            }
            int index = 0;
            for (int j = 0; j < p.length; j++)
                if (p[j] != 0) {
                    for (int k = 0; k < p[j]; k++)
                        nums[index++] = buckets[j][k];
                    p[j] = 0;//相当于清空该桶中元素
                }
            n *= 10;
        }
        if(min < 0)
            for (int i = 0; i < nums.length; i++)
                nums[i] += min;
        return nums;
    }

    private int[] fixAndGetMaxLen(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        if (min < 0) {
            for (int i = 0; i < nums.length; i++)
                nums[i] -= min;//每个数减去最小的那个负数。使得数组中每个数都 >=0
            max -= min; //相应的数组中的最大值也要减去min，才是现在数组的最小值。
        }
        return new int[]{min, (max + "").length()};//返回max是几位数 与 min
    }
}
```

## 桶排序和计数排序
### 1. 计数排序
**思想**

	把数组的值映射到一个辅助空间的索引上，每次 +1；
**缺点**

	如果数据特别的稀疏，那么会浪费大量的空间
```java
class Solution {
    public int[] sortArray(int[] nums) {
        countSort(nums);
        return nums;
    }

    private void countSort(int[] nums) {
        int[] store = new int[100001];//这里开辟100001的原因是题目中说明了数据大小的范围是[-50000，50000];
        for (int i = 0; i < nums.length; i++)
            store[nums[i] + 50000]++;
        int current = 0;
        for (int i = 0; i < store.length; i++) {
            if (store[i] != 0) {
                while (store[i]!=0) {
                    nums[current++] = i - 50000;
                    store[i]--;
                }
            }
        }
    }
    
}
```
### 2. 桶排序
**思想**

将数组中的数按照一定的运算规则（不固定）分配到一些桶当中。保证桶中的数据是有序的，然后依次出桶（从桶中把数据取出来）
**说明：**
桶排序更是对计数排序的改进，计数排序申请的额外空间跨度从最小元素值到最大元素值，若待排序集合中元素不是依次递增的，则必然有空间浪费情况。桶排序则是弱化了这种浪费情况，将最小值到最大值之间的每一个位置申请空间，更新为最小值到最大值之间每一个固定区域申请空间，尽量减少了元素值大小不连续情况下的空间浪费情况。

```cpp
import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        bucketSort(nums);
        return nums;
    }

    public void bucketSort(int[] nums) {
        //1.找最大值，同于计算元素在几号桶
        int len = nums.length;
        Node[] buckets = new Node[len];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        if(min < 0){//处理负数
            for (int i = 0; i < nums.length; i++)
                nums[i] -= min;
            max -= min;
        }
        //2.入桶
        for (int i = 0; i < nums.length; i++) {
            //得到每个元素应该在几号桶里  e*len/(max+1)
            int index = nums[i] * len / (max + 1);
            if (buckets[index] == null) {//如果该桶中还没有元素
                buckets[index] = new Node(nums[i]);
            } else {//该桶有多个元素，应该按序插入
                insertTo(buckets[index], nums[i]);//把头指针和要插入的元素传入参数
            }

        }
        int index = 0;
        //3.出桶
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                Node p = buckets[i];
                while (p != null) {
                    if(min < 0)
                        nums[index++] = p.data + min;
                    else
                        nums[index++] = p.data;
                    p = p.next;
                }
            }
        }

    }

    private void insertTo(Node head, int e) {
        Node p = head.next;
        Node pre = head;
        Node newNode = new Node(e);
        while (p != null) {
            if (p.data > e) {//找到第一个大于e的元素的位置
                pre.next = newNode;
                newNode.next = p;
                return;
            }
            pre = p;
            p = p.next;
        }
        //如果一直到最后一个元素也没有大于当前元素
        if (pre.data > e) {
            int tmp = newNode.data;
            newNode.data = pre.data;
            pre.data = tmp;
            pre.next = newNode;
            newNode.next = p;
        } else {
            pre.next = newNode;
        }
    }

}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
```

## 一、位运算

### 1 找落单的那个数

**问题描述**：`1-1000`这`1000`个数放在含有`1001`个元素的数组中，只有唯一的一个元素值重复，其它均只出现一次。每个数组元素只能访问一次，设计一个算法，将它找出来;不用辅助存储空间，能否设计一个算法实现?

> 解题思路： 相同的数字异或为0，也就是可以抵消。那就将这些数字与一个1-1000数字的数组异或，剩下的数字就是重复出现的数字。

### 2 求二进制中1的个数

**问题描述** ： *L191*

> 解题思路：n&n-1消去二进制字符串的最后一个1，直到n等于0

### 3 判断一个数是不是2的整数次方?

?	解题思路：2的整数次方的二进制数只会有1个1，所以n&n-1如果直接等于0就是2的整数次方。

### 4 交换一个数的二进制的奇偶位

?	解题思路：&运算能保留二进制串中的原来01，先和010101...0101把原来奇数位的保留，再和1010....1010把原来偶数位的数字保留，一个左移一位，一个右移一位，异或起来即可。

### 5 将一个double类型的小数转换为二进制表示

?	不断乘以2

### 6 只出现一次的数字

#### 	6.1 L136 出现多次的数字的次数均为2次

?		解题思路：全部异或运算即可

#### 	6.2 L137

?		给你一个整数数组 `nums` ，除某个元素仅出现一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。

### 7 位运算总结

1. `10`个相同的`10`进制数做不进位的加法，一定是`0`
2. `2`个相同的`2`进制数做不进位的加法，一定是`0`
3. `k`个相同的k进制数做不进位的加法，一定是`0`
4. `java`中的进制转换`api`
   ?	`valueOf`
   ?	`toString(int i, int radix)`



## 二、算法基础

### 1 基础问题

#### 1.1 数组求和

?	方式1，`a,begin,end`

```java
import java.util.*;

class Main{
	static int f(int[]a,int begin,int end) {
		if(begin>=end) return 0;
		int x = f(a,begin+1,end);
		return x+a[begin];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = {1,2,3,4,5};
		System.out.println(f(a,0,a.length));
	}		

}
```

方式2，折中求解

```java
import java.util.*;
class Main{
	static int f(int[]a,int begin,int end) {
		if(begin == end) {
			return a[begin];
		}else {
			int mid = (begin+end)/2;
			int left = f(a,begin,mid);
			int right = f(a,mid+1,end);
			return left+right;
		}
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {1,2,3,4,5};
        System.out.println(f(a,0,a.length-1));
    }
}
```

#### 1.2 求组合数的问题

代码：

```java
import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = combination(5,3);
        System.out.println(x);
        sc.close();
    }

    private static int combination(int n, int m) {
        if(n<m) return 0;
        if(n==m) return 1;
        if(m==0) return 1;
        return combination(n-1,m-1)+combination(n-1,m);
    }
}
```
思想：
平地起风雷，如果没有很明显的划分成子问题的方法，可以思考外加一个想象的条件来拆分原问题

#### 1.3 全排列问题

```java
import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] data = "ABC".toCharArray();
        fullPermutation(data,0);
        sc.close();
    }

    private static void fullPermutation(char[] data,int k) {//k是开始位置
        if(k==data.length) {
            for(int i=0;i<data.length;i++) {
                System.out.print(data[i]+" ");
            }
            System.out.println();
        }
        for(int i=k;i<data.length;i++) {
            {char tmp = data[i];data[i] = data[k];data[k] = tmp;}
            fullPermutation(data,k+1);
            {char tmp = data[i];data[i] = data[k];data[k] = tmp;}//回溯
        }
    }
}
```

#### 1.4 求最大子序列问题

##### 1.5 小白上楼梯问题

#### 1.6 旋转数组的最小数字问题

?		改造二分法

#### 1.7 在有空有序字符串数组中查找

#### 1.8 求最长子序列

#### 1.9 设计一个高效的求解a的n次幂的方法

### 2 算法时间复杂度分析

$T(n) = 2T(n-1) + O(1)$ ,那么时间复杂度就是$O(2^n)$
$T(n) = T(n-1)+T(n-2)+O(1) $,那么时间复杂度就是$O(2^n)$
若规模n没1次减为原来规模的一半，那么时间复杂度为$O(lgn)$，没2次减半，则为$O(2lgn)$ ........以此类推
$T(n) = T(n-1) + O(1)$  ,那么时间复杂度就是$O(n)$





### 3 多维数组与矩阵

#### 问题

?		**问题1：顺时针打印数组**
?		**问题2：清空0所在的行和列**

```java
import java.util.ArrayList;
import java.util.List;

class Answer{
	List<Integer> col;
	List<Integer> row;
}
public class 问题2_清空0所在的行和列 {
    public static void main(String[] args) {
        int[][] arr = new int[][] {
            {1,1,1,1},
            {1,0,1,1},
            {1,1,0,1},
            {1,1,1,1},
        };
        Answer answer = solution(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(answer.col.contains(j)||answer.row.contains(i)) {
                    System.out.print(0+" ");
                }
                else {
                    System.out.print(arr[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    private static Answer solution(int[][] arr) {
        Answer ans = new Answer();
        ans.col = new ArrayList<Integer>();
        ans.row = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i][j] == 0) {
                    ans.col.add(j);
                    ans.row.add(i);
                }
            }
        }
        return ans;
    }
}
```
**问题3：Z形打印数组**
**问题4：边界为1的最大子矩阵**
方式1：O(n^4)
思路
扫描每一个位置的一圈
方式2：O(n?)
思路
打表，先把给定的二位数组打表，记录在该点的右边和下边分别一共有多少个连续的1（用三位数组存储，从左下方开始统计）
**问题5：求最大子数组的累加和**
思路：
如果某个区间的和为复数，那么它一定不可能出现在最大求和的区间内。
**问题6：求最大子矩阵的累加和**
思路：
从起始行开始按列累加，将二位数组压缩成一维数组，调用问题5中的一位数组求最大和的方法。直到起始行大于矩阵的最后一行时，循环结束

### 4 字符串处理

java字符串和c/c++的区别
问题
**问题1_判断有无重复字符**
采用计数排序的思路


```java
package com.zyh.lanqiao.string;

public class 问题1_判断有无重复字符 {
    public static void main(String[] args) {
        String str = "abchegf";
        if(solution(str)) {
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    private static boolean solution(String str) {
        int[] help = new int[128];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(help[c] == 0)
                help[c]++;
            else
                return false;
        }
        return true;
	}
}
```

**问题2_反转字符串**
方式1
代码

```java
package com.zyh.lanqiao.string;

public class 问题2_反转字符串 {
    public static void main(String[] args) {
        String str = "abcdefg";
        reverseString(str);
    }

    private static void reverseString(String str) {
        char[] chars = str.toCharArray();
        int q = 0;
        int r = str.length() - 1;
        char tmp='c';
        while(q<r) {
            tmp = chars[q];
            chars[q] = chars[r];
            chars[r] = tmp;
            q++;
            r--;
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+" ");
        }
    }
}
```

方式2 API的调用

```java
	
private static void reverseString2(String str) {
	StringBuilder sb = new StringBuilder(str);
	sb.reverse();
	System.out.println(sb.toString());
}
```

**问题3_变形词问题**
思路1
先排序，然后比较两个字符数组是否完全一摸一样
代码

```java
private static boolean solution1(String ss, String sp) {
	char[] cs1 = ss.toCharArray();
	Arrays.sort(cs1);
	char[] cs2 = sp.toCharArray();
	Arrays.sort(cs2);
	if(Arrays.equals(cs1, cs2)) {
		return true;
	}
	return false;
}
```

?			思路2
?				开辟一个与ACSII范围大的数组，先统计第一个字符串出现的次数，后面遇到就减1，减到负数就返回false
?					代码

```java
private static boolean solution2(String ss, String sp) {
	int[] help = new int[128];
	for (int i = 0; i < ss.length(); i++) {
		help[ss.charAt(i)]++;
	}
	for (int i = 0; i < sp.length(); i++) {
		if(help[sp.charAt(i)] <= 0 ) {
			return false;
		}
		help[sp.charAt(i)]--;
	}

	return true;
}
```

**问题4_替换空格**
方式1
方式2 API的调用
代码


```java
public class 问题4_替换空格 {
    public static void main(String[] args) {
        String str = "https://baidu.com?s=hello world";
        str = solution(str);
        System.out.println(str);
    }

    private static String solution(String str) {
        str  = str.replaceAll("\\s", "%20");
        return str;
    }
}
```

**问题5_压缩字符串**



?				代码
?

```java
import java.util.*;

public class 问题4_替换空格 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String upperCase = line.toUpperCase();
        char[] a = upperCase.toCharArray();
        int[] res = new int[24];
        for (int i = 0; i < a.length; i++) {
            if(i+1<a.length&&a[i] == a[i+1]){
                res[a[i]-65]++;
            }else{
                res[a[i]-65]++;
                System.out.print("("+a[i]+","+res[a[i]-65]+")");
                res[a[i]-65] = 0;
            }
        }
        	sc.close();
}
```

**问题6_判断两个字符串字符集是否相同**
方式1
hashMap
代码

```java
private static boolean solution1(String s1, String s2) {
    int[] help = new int[128];
    int tmp = 0;
    for (int i = 0; i < s1.length(); i++) {
        tmp = s1.charAt(i);
        if(help[tmp] <=0) {
            help[tmp]++;
        }
    }
    for (int i = 0; i < s2.length(); i++) {
        tmp = s2.charAt(i);
        help[tmp]--;
        if(help[tmp] < 0)
            return false;
    }
    return true;
}
```

?				方式2
?					类似变形词问题，但是只要出现就变为1，重复的不管。
?						代码
?

```java
public class 问题6_判断两个字符串字符集是否相同 {
    public static void main(String[] args) {
        String s1 = "here are you";
        String s2 = "herayou";
        System.out.println(solution(s1,s2));
    }

    private static boolean solution(String s1, String s2) {
        int[] help = new int[128];
        int tmp = 0;
        for (int i = 0; i < s1.length(); i++) {
            tmp = s1.charAt(i);
            if(help[tmp] <=0) {
                help[tmp]++;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            tmp = s2.charAt(i);
            help[tmp]--;
            if(help[tmp] < 0)
                return false;
        }
        return true;
    }
}
```

**问题7_旋转词**

代码

	输入：s1:ABCCD,s2:BCCD
*输出：YES
*思路：两个s1拼接一定包含s2


```java
public class 问题7_旋转词 {

    public static void main(String[] args) {
        String s1 = "ABCCD";
        String s2 = "BCCD";
        System.out.println(solution(s1,s2));
    }

    private static boolean solution(String s1, String s2) {
        s1.concat(s1);
        return s1.contains(s2);
    }

}
```

**问题8_字符串按单词进行翻转**

输入：here are you

输出：you are here

思路
将整个字符串先按字符整个翻转，在按照空格按单词翻转回来即可

```java
public class 问题8_字符串按单词进行翻转 {

   public static void main(String[] args) {
        String str = "here are you";
        System.out.println(str);
        str = solution(str);
        System.out.println(str);
   }

   private static String solution(String str) {
        str = reverseString(str);
        String[] strs = str.split("\\s");
        StringBuilder res  = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            res.append(reverseString(strs[i])+" " );
        }
        return res.toString();
   }
    
   private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        str = sb.reverse().toString();
        return str;
   }
}
```
**问题9_去掉k个连续的‘0’**

方式1

?		正则表达式

```java
public class 问题9_去掉k个连续的0 {
    public static void main(String[] args) {
        String str = "10001001";
        int k = 2;
        System.out.println(str);
        str = solution(str,k);
        System.out.println(str);
    }

    private static String solution(String str,int k) {
        String regex="0{"+k+"}";
        str = str.replaceAll(regex, "");
        return str;
    }
}
```

方式2

?	扫描

**问题10_回文串**

输出所有的四位数的回文数比如1221

```java
public class 问题10_回文串数 {
    static int N =10;
    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.println(i+""+j+""+j+""+i);
            }
        }
    }

}
```



### 5 字符串匹配

#### 5.1 算法

##### RabinKarp

> hash算法，就是设计一种算法给字符串用一个值来代替它
> 滚动hash，当不匹配时，没必要重新计算另一个子串的值，只需要先乘以随机种子，在减去第一个字符的随机种子的n次方

##### KMP

暴力算法

思路

> 两个指针，一 个指向源字符串，一个指向模式串。

?

kmp
思路

> 暴力算法的可优化地方在于，由于第一次失配的情况已经匹配过了下一次要匹配的部分情况，所以会有重复匹配的问题。
>
> 优化：除了失配字符串的下标，从该下标往前，计算出最大的前缀和后缀字符串的最大匹配数（除了字符串本身），下一次可以直接最大匹配数的下一个字符的下标开始匹配。即模式串的j位失配了，调用next[j]得到模式串游标应该移动到哪一位上k
> 说明：比如"babab"的前缀有b,ba,bab,baba,babab,后缀有b,ab,bab,abab,babab



#### 5.2 后缀数组

思路
子串一定是某个后缀的前缀
后缀数组中每个后缀字符串都是带有后缀字符的起始位置的
求出源字符串的所有的后缀字符串，得到后缀字符串数组，堆后缀字符串数组进行排序，调用二分查找，比较后缀字符串和模式串，但是因为子串一定是某个后缀的前缀，所以每次比较的长度要是模式串的长度，如果匹配成功返回，后缀字符串的起始位置





### 6 数学问题

巧用进制——砝码称重问题
nim问题
求和公式必备

等差数列求和
等比数列求和
平方与立方和
平方和：n(n+1)(2n+2)  / 6
立方和：n? *（n+1）?  /  2
几何级数
x^(n+1)  -  1  /
辗转相除法/欧几里得算法
贝祖等式
模线性方程
逆元
质因数分解
求第十万零二个素数
幂运算
把幂转化成二进制，变成取舍的问题