import java.util.Iterator;
import java.util.PriorityQueue;

class KthLargest {
    final PriorityQueue<Integer> q ;
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>(k);
        for(int i: nums) {
            add(i);
        }
    }

    public int add(int val) {
        if(q.size() < k) {
            q.add(val);
        }
        else if(q.peek() < val) {
            q.remove();
            q.add(val);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{2, 4, 5, 8});
        System.out.println(kthLargest.add(10));
    }
}