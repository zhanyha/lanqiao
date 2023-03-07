
public class Data {

	public static void main(String[] args) {
		int N = (int) (Math.random()*15);
		int K = (int) (Math.random()*100);
		System.out.printf("%d %d\n",N,K);
		for (int i = 0; i < N; i++) {
			System.out.print((int)(Math.random()*150)+" ");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print((int)(Math.random()*N)+" ");
		}
	}

}
