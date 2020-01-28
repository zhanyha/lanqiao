import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int d;
		for (int i = 0; i < N; i++) {
			d = sc.nextInt();
			System.out.println(solution(d));
		}
		sc.close();
	}
	/**
	 * ������ʽ
	 * @param n
	 * @return
	 */
	private static int solution(int n) {
		int[] arr = new int[n];
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i < arr.length; i++) {
			arr[i] = arr[i-1] + arr[i - 2];
		}
		return arr[n-1];
	}
	/**
	 * �ݹ鷽ʽ
	 * @param n
	 * @return
	 */
	private static int recursion(int n) {
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 3;
		return recursion(n-1)+recursion(n-2);
	}

}