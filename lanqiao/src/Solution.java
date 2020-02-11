import java.util.Scanner;
/**
 * https://leetcode-cn.com/problems/path-sum/
* @author zhanyuhao
* @version ����ʱ�䣺2020��2��9�� ����12:22:02
* ��˵��: ����һ����������һ��Ŀ��ͣ��жϸ������Ƿ���ڸ��ڵ㵽Ҷ�ӽڵ��·����
* ����·�������нڵ�ֵ��ӵ���Ŀ��͡�
  */
class Solution {
	private static class Node<E>{
		E val;
		Node<E> left;
		Node<E> right;
	}
	static String[] chs = null;
	static int cur=-1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();sc.nextLine();
		chs = sc.nextLine().split(",");
		
		Node<Integer> root = create();
		System.out.println(hasPathSum(root, n));
		sc.close();
	}
	public static Node<Integer> create(){
		++cur;
		if(chs[cur].equals("#")) {
			return null;
		}
		Node<Integer> p = new Node<Integer>();
		p.val = Integer.parseInt(chs[cur]);
		p.left = create();
		p.right = create();
		return p;
	}
    public static boolean hasPathSum(Node<Integer> root, int sum) {
        if(root == null) return false;
        int target = sum - root.val;
        if(target ==0 && root.left==null&&root.right==null){
            return true;
        }
        return hasPathSum(root.left,target) || hasPathSum(root.right,target);
    }
}