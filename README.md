# �����㷨�ܽ�

## һ����������
### 1. ֱ�Ӳ�������

```java
	public void insertSort(int[] arr, int len) {
        int i, j;
        for (i = 2; i < len; i++) {
            if (arr[i] < arr[i - 1]) {
                arr[0] = arr[i];//arr[0]Ϊ�ڱ������������Ԫ��
                for (j = i - 1; arr[j] > arr[0]; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = arr[0];
            }
        }
    }
```

### 2. �۰��������

```java
	public void insertSort02(int[] arr, int len) {
        int i, j, low, high, mid = 0;
        for (i = 2; i < len; i++) {
            if (arr[i] < arr[i - 1]) {
                low = 1;
                high = i;
                arr[0] = arr[i];//arr[0]����Ϊ����Ԫ��
                while (low <= high) {//����������ע���ٽ�����
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

### 3. ϣ������
![���������ͼƬ����](https://img-blog.csdnimg.cn/20200507001343375.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2lkZWZpbmVk,size_16,color_FFFFFF,t_70)

```java
	public void shellSort(int[] arr, int len) {
        int i, j, tmp;
        for (int dk = len / 2; dk >= 1; dk /= 2) //����,��СΪ1
            for (i = dk; i < len; i++)          // ����������ֱ�Ӳ�������
                if (arr[i] < arr[i - dk]) {
                    tmp = arr[i];                //�ݴ���tmp��
                    for (j = i - dk; j >= 0 && arr[j] > tmp; j -= dk)
                        arr[j + dk] = arr[j];
                    arr[j+dk] = tmp;
                }
    }
```

##  ��������
### 1. ð������

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
### 2. ��������

	˫��ɨ�������

==ע���ٽ��������ж�==
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
        while(left <= right){//���ҵ��㷨�У��ٽ�����ȫ����left<=right,һ��Ҫע�⡣
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
==���Ż��ĵط���== �Ż��ĵط�����`base`��ȡֵ


## ѡ������
### 1. ��ѡ������
**˼�룺** ÿ`i`�����±�Ϊ`i`�ĺ��������е��������ҵ���С�����֣�������`arr[i]`�Ƚϡ����С�ͽ�����
����ÿ�ξ�ȷ���˵�`i`������λ�ã��Ժ󶼲��ı�
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
### 2. ������

1. ʲô�Ƕ�
   **���** �������һ����ȫ������
   **����:**
   `1)`. ���ڵ�ļ�ֵ���Ǵ��ڵ��ڣ�����С�ڵ��ڣ��κ�һ���ӽڵ�ļ�ֵ
   `2)`. ÿ���ڵ��������������һ������ѣ�Ҫô�Ǵ󶥶�Ҫô��С���ѣ�

2. ˼�룺
   **2.1**  �������/С���ѻ�����ΪҶ�ӽ�㲻���к��ӽڵ㣬�����Ѿ�����ѵ�Ҫ���ˡ�����Ҫ��`A.lenth/2 - 1 `��λ�ÿ�ʼ���ø������췽������֤�ýڵ���Ϊ���ڵ�ʱ��������������˵������ֲ�ʱ�󶥶ѻ���С���ѣ�
   **2.2** ��Ƹ��������С���ѵķ���
   �������飬�ֲ����ڵ�����������������ڵ������������֤�ֲ��Ǵ�/С����
   **2.3.** �ø��ڵ�ÿ�ζ������һ��Ԫ�ؽ��������ǱȽ���һ�κ���������һ��Ԫ��Ҫ�� `1` ��Ȼ����ø��������/С���ѵķ��������¹����һ�����ȼ�1�Ĵ�/С���ѡ�������������һ��λ�ÿ�ʼ������ǰ������������ݡ�ֱ��������������

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
        if (rch > len) {//˵�����Һ���
            if (lch > len) {//˵��Ҳ�����ӣ���ô����Ҷ�ӽڵ�
                return;
            }
            //��������,�����Һ���
            if (nums[lch] < nums[root])
                return;
            swap(nums, lch, root);
            maxHeapize(nums, lch, len);//���Ӽ������µ���
        } else {
            //˵�������Һ���,ע�ⲻ����ֻ���Һ��ӣ�û�����ӵ������
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

### �鲢����ͻ�������
### 1. �鲢����

1. �Ϳ������������

   1.���ðѴ�ĺ�С�ķ���
   2.��Ҫ�µĸ����ռ䣨����ԭ���飩
   3.�鲢������������ǿ��ֱ�Ƚ���������ͷλ��

`merge`�Ĳ���
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
        // �Ƚ����������ֵ�Ԫ�أ��ĸ�С�����Ǹ�Ԫ������temp��
        while (p1 <= mid && p2 <= R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // �����ѭ���˳��󣬰�ʣ���Ԫ���������뵽temp��
        // ��������whileֻ��һ����ִ��
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= R) {
            temp[i++] = arr[p2++];
        }
        // �����յ�����Ľ�����Ƹ�ԭ����
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



### 2. ��������

**˼��**
��һ�ΰ���λ�����������ַ��䵽0~9��Ͱ����Ȼ���Ͱ
�ڶ��ΰ�ʮλ�����������ַ��䵽0~9��Ͱ����Ȼ���Ͱ������������������
> ͨ������ʮ��������

```cpp
class Solution {
    public int[] radixSort(int[] nums) {
        int[] res = fixAndGetMaxLen(nums);//�������������ڸ�����������ȵ�������
        int min = res[0];
        int size = res[1];
        int[][] buckets = new int[10][nums.length];
        int[] p = new int[10];//��¼ÿ��Ͱ�����һ��Ԫ�ص�λ��
        int n = 1;
        for (int i = 0; i < size; i++) {//����n�ΰ��ؼ�������, ��ȡ�ķ�ʽ��LSD�����Ϊ���ȣ�
            for (int j = 0; j < nums.length; j++) {
                int m = (nums[j] / n) % 10;
                buckets[m][p[m]] = nums[j];
                p[m]++;//ָ��Ͱ�д���һ������λ��
            }
            int index = 0;
            for (int j = 0; j < p.length; j++)
                if (p[j] != 0) {
                    for (int k = 0; k < p[j]; k++)
                        nums[index++] = buckets[j][k];
                    p[j] = 0;//�൱����ո�Ͱ��Ԫ��
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
                nums[i] -= min;//ÿ������ȥ��С���Ǹ�������ʹ��������ÿ������ >=0
            max -= min; //��Ӧ�������е����ֵҲҪ��ȥmin�����������������Сֵ��
        }
        return new int[]{min, (max + "").length()};//����max�Ǽ�λ�� �� min
    }
}
```

## Ͱ����ͼ�������
### 1. ��������
**˼��**

	�������ֵӳ�䵽һ�������ռ�������ϣ�ÿ�� +1��
**ȱ��**

	��������ر��ϡ�裬��ô���˷Ѵ����Ŀռ�
```java
class Solution {
    public int[] sortArray(int[] nums) {
        countSort(nums);
        return nums;
    }

    private void countSort(int[] nums) {
        int[] store = new int[100001];//���￪��100001��ԭ������Ŀ��˵�������ݴ�С�ķ�Χ��[-50000��50000];
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
### 2. Ͱ����
**˼��**

�������е�������һ����������򣨲��̶������䵽һЩͰ���С���֤Ͱ�е�����������ģ�Ȼ�����γ�Ͱ����Ͱ�а�����ȡ������
**˵����**
Ͱ������ǶԼ�������ĸĽ���������������Ķ���ռ��ȴ���СԪ��ֵ�����Ԫ��ֵ���������򼯺���Ԫ�ز������ε����ģ����Ȼ�пռ��˷������Ͱ�������������������˷����������Сֵ�����ֵ֮���ÿһ��λ������ռ䣬����Ϊ��Сֵ�����ֵ֮��ÿһ���̶���������ռ䣬����������Ԫ��ֵ��С����������µĿռ��˷������

```cpp
import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        bucketSort(nums);
        return nums;
    }

    public void bucketSort(int[] nums) {
        //1.�����ֵ��ͬ�ڼ���Ԫ���ڼ���Ͱ
        int len = nums.length;
        Node[] buckets = new Node[len];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        if(min < 0){//������
            for (int i = 0; i < nums.length; i++)
                nums[i] -= min;
            max -= min;
        }
        //2.��Ͱ
        for (int i = 0; i < nums.length; i++) {
            //�õ�ÿ��Ԫ��Ӧ���ڼ���Ͱ��  e*len/(max+1)
            int index = nums[i] * len / (max + 1);
            if (buckets[index] == null) {//�����Ͱ�л�û��Ԫ��
                buckets[index] = new Node(nums[i]);
            } else {//��Ͱ�ж��Ԫ�أ�Ӧ�ð������
                insertTo(buckets[index], nums[i]);//��ͷָ���Ҫ�����Ԫ�ش������
            }

        }
        int index = 0;
        //3.��Ͱ
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
            if (p.data > e) {//�ҵ���һ������e��Ԫ�ص�λ��
                pre.next = newNode;
                newNode.next = p;
                return;
            }
            pre = p;
            p = p.next;
        }
        //���һֱ�����һ��Ԫ��Ҳû�д��ڵ�ǰԪ��
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

## һ��λ����

### 1 ���䵥���Ǹ���

**��������**��`1-1000`��`1000`�������ں���`1001`��Ԫ�ص������У�ֻ��Ψһ��һ��Ԫ��ֵ�ظ���������ֻ����һ�Ρ�ÿ������Ԫ��ֻ�ܷ���һ�Σ����һ���㷨�������ҳ���;���ø����洢�ռ䣬�ܷ����һ���㷨ʵ��?

> ����˼·�� ��ͬ���������Ϊ0��Ҳ���ǿ��Ե������Ǿͽ���Щ������һ��1-1000���ֵ��������ʣ�µ����־����ظ����ֵ����֡�

### 2 ���������1�ĸ���

**��������** �� *L191*

> ����˼·��n&n-1��ȥ�������ַ��������һ��1��ֱ��n����0

### 3 �ж�һ�����ǲ���2�������η�?

?	����˼·��2�������η��Ķ�������ֻ����1��1������n&n-1���ֱ�ӵ���0����2�������η���

### 4 ����һ�����Ķ����Ƶ���żλ

?	����˼·��&�����ܱ��������ƴ��е�ԭ��01���Ⱥ�010101...0101��ԭ������λ�ı������ٺ�1010....1010��ԭ��ż��λ�����ֱ�����һ������һλ��һ������һλ������������ɡ�

### 5 ��һ��double���͵�С��ת��Ϊ�����Ʊ�ʾ

?	���ϳ���2

### 6 ֻ����һ�ε�����

#### 	6.1 L136 ���ֶ�ε����ֵĴ�����Ϊ2��

?		����˼·��ȫ��������㼴��

#### 	6.2 L137

?		����һ���������� `nums` ����ĳ��Ԫ�ؽ�����һ�� �⣬����ÿ��Ԫ�ض�ǡ���� ���� �������ҳ��������Ǹ�ֻ������һ�ε�Ԫ�ء�

### 7 λ�����ܽ�

1. `10`����ͬ��`10`������������λ�ļӷ���һ����`0`
2. `2`����ͬ��`2`������������λ�ļӷ���һ����`0`
3. `k`����ͬ��k������������λ�ļӷ���һ����`0`
4. `java`�еĽ���ת��`api`
   ?	`valueOf`
   ?	`toString(int i, int radix)`



## �����㷨����

### 1 ��������

#### 1.1 �������

?	��ʽ1��`a,begin,end`

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

��ʽ2���������

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

#### 1.2 �������������

���룺

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
˼�룺
ƽ������ף����û�к����ԵĻ��ֳ�������ķ���������˼�����һ����������������ԭ����

#### 1.3 ȫ��������

```java
import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] data = "ABC".toCharArray();
        fullPermutation(data,0);
        sc.close();
    }

    private static void fullPermutation(char[] data,int k) {//k�ǿ�ʼλ��
        if(k==data.length) {
            for(int i=0;i<data.length;i++) {
                System.out.print(data[i]+" ");
            }
            System.out.println();
        }
        for(int i=k;i<data.length;i++) {
            {char tmp = data[i];data[i] = data[k];data[k] = tmp;}
            fullPermutation(data,k+1);
            {char tmp = data[i];data[i] = data[k];data[k] = tmp;}//����
        }
    }
}
```

#### 1.4 ���������������

##### 1.5 С����¥������

#### 1.6 ��ת�������С��������

?		������ַ�

#### 1.7 ���п������ַ��������в���

#### 1.8 ���������

#### 1.9 ���һ����Ч�����a��n���ݵķ���

### 2 �㷨ʱ�临�Ӷȷ���

$T(n) = 2T(n-1) + O(1)$ ,��ôʱ�临�ӶȾ���$O(2^n)$
$T(n) = T(n-1)+T(n-2)+O(1) $,��ôʱ�临�ӶȾ���$O(2^n)$
����ģnû1�μ�Ϊԭ����ģ��һ�룬��ôʱ�临�Ӷ�Ϊ$O(lgn)$��û2�μ��룬��Ϊ$O(2lgn)$ ........�Դ�����
$T(n) = T(n-1) + O(1)$  ,��ôʱ�临�ӶȾ���$O(n)$





### 3 ��ά���������

#### ����

?		**����1��˳ʱ���ӡ����**
?		**����2�����0���ڵ��к���**

```java
import java.util.ArrayList;
import java.util.List;

class Answer{
	List<Integer> col;
	List<Integer> row;
}
public class ����2_���0���ڵ��к��� {
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
**����3��Z�δ�ӡ����**
**����4���߽�Ϊ1������Ӿ���**
��ʽ1��O(n^4)
˼·
ɨ��ÿһ��λ�õ�һȦ
��ʽ2��O(n?)
˼·
����ȰѸ����Ķ�λ��������¼�ڸõ���ұߺ��±߷ֱ�һ���ж��ٸ�������1������λ����洢�������·���ʼͳ�ƣ�
**����5���������������ۼӺ�**
˼·��
���ĳ������ĺ�Ϊ��������ô��һ�������ܳ����������͵������ڡ�
**����6��������Ӿ�����ۼӺ�**
˼·��
����ʼ�п�ʼ�����ۼӣ�����λ����ѹ����һά���飬��������5�е�һλ���������͵ķ�����ֱ����ʼ�д��ھ�������һ��ʱ��ѭ������

### 4 �ַ�������

java�ַ�����c/c++������
����
**����1_�ж������ظ��ַ�**
���ü��������˼·


```java
package com.zyh.lanqiao.string;

public class ����1_�ж������ظ��ַ� {
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

**����2_��ת�ַ���**
��ʽ1
����

```java
package com.zyh.lanqiao.string;

public class ����2_��ת�ַ��� {
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

��ʽ2 API�ĵ���

```java
	
private static void reverseString2(String str) {
	StringBuilder sb = new StringBuilder(str);
	sb.reverse();
	System.out.println(sb.toString());
}
```

**����3_���δ�����**
˼·1
������Ȼ��Ƚ������ַ������Ƿ���ȫһ��һ��
����

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

?			˼·2
?				����һ����ACSII��Χ������飬��ͳ�Ƶ�һ���ַ������ֵĴ��������������ͼ�1�����������ͷ���false
?					����

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

**����4_�滻�ո�**
��ʽ1
��ʽ2 API�ĵ���
����


```java
public class ����4_�滻�ո� {
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

**����5_ѹ���ַ���**



?				����
?

```java
import java.util.*;

public class ����4_�滻�ո� {
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

**����6_�ж������ַ����ַ����Ƿ���ͬ**
��ʽ1
hashMap
����

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

?				��ʽ2
?					���Ʊ��δ����⣬����ֻҪ���־ͱ�Ϊ1���ظ��Ĳ��ܡ�
?						����
?

```java
public class ����6_�ж������ַ����ַ����Ƿ���ͬ {
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

**����7_��ת��**

����

	���룺s1:ABCCD,s2:BCCD
*�����YES
*˼·������s1ƴ��һ������s2


```java
public class ����7_��ת�� {

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

**����8_�ַ��������ʽ��з�ת**

���룺here are you

�����you are here

˼·
�������ַ����Ȱ��ַ�������ת���ڰ��տո񰴵��ʷ�ת��������

```java
public class ����8_�ַ��������ʽ��з�ת {

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
**����9_ȥ��k�������ġ�0��**

��ʽ1

?		������ʽ

```java
public class ����9_ȥ��k��������0 {
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

��ʽ2

?	ɨ��

**����10_���Ĵ�**

������е���λ���Ļ���������1221

```java
public class ����10_���Ĵ��� {
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



### 5 �ַ���ƥ��

#### 5.1 �㷨

##### RabinKarp

> hash�㷨���������һ���㷨���ַ�����һ��ֵ��������
> ����hash������ƥ��ʱ��û��Ҫ���¼�����һ���Ӵ���ֵ��ֻ��Ҫ�ȳ���������ӣ��ڼ�ȥ��һ���ַ���������ӵ�n�η�

##### KMP

�����㷨

˼·

> ����ָ�룬һ ��ָ��Դ�ַ�����һ��ָ��ģʽ����

?

kmp
˼·

> �����㷨�Ŀ��Ż��ط����ڣ����ڵ�һ��ʧ�������Ѿ�ƥ�������һ��Ҫƥ��Ĳ�����������Ի����ظ�ƥ������⡣
>
> �Ż�������ʧ���ַ������±꣬�Ӹ��±���ǰ�����������ǰ׺�ͺ�׺�ַ��������ƥ�����������ַ�����������һ�ο���ֱ�����ƥ��������һ���ַ����±꿪ʼƥ�䡣��ģʽ����jλʧ���ˣ�����next[j]�õ�ģʽ���α�Ӧ���ƶ�����һλ��k
> ˵��������"babab"��ǰ׺��b,ba,bab,baba,babab,��׺��b,ab,bab,abab,babab



#### 5.2 ��׺����

˼·
�Ӵ�һ����ĳ����׺��ǰ׺
��׺������ÿ����׺�ַ������Ǵ��к�׺�ַ�����ʼλ�õ�
���Դ�ַ��������еĺ�׺�ַ������õ���׺�ַ������飬�Ѻ�׺�ַ�������������򣬵��ö��ֲ��ң��ȽϺ�׺�ַ�����ģʽ����������Ϊ�Ӵ�һ����ĳ����׺��ǰ׺������ÿ�αȽϵĳ���Ҫ��ģʽ���ĳ��ȣ����ƥ��ɹ����أ���׺�ַ�������ʼλ��





### 6 ��ѧ����

���ý��ơ��������������
nim����
��͹�ʽ�ر�

�Ȳ��������
�ȱ��������
ƽ����������
ƽ���ͣ�n(n+1)(2n+2)  / 6
�����ͣ�n? *��n+1��?  /  2
���μ���
x^(n+1)  -  1  /
շת�����/ŷ������㷨
�����ʽ
ģ���Է���
��Ԫ
�������ֽ�
���ʮ�����������
������
����ת���ɶ����ƣ����ȡ�������