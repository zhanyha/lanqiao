import java.util.Scanner;

public class Main {

	/**
	 * scanner��ʹ�� ���ܴӿ���̨�������Ϣ
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("����������������");
		String name = input.next();
		System.out.println("���������ĺ��룺");
		int num = input.nextInt();
		System.out.println(name + "���ã����ĵȴ�����Ϊ��" + num);

	}
}