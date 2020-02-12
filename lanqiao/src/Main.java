import java.util.Scanner;

public class Main {

	/**
	 * scanner的使用 接受从控制台输入的信息
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入您的姓名：");
		String name = input.next();
		System.out.println("请输入您的号码：");
		int num = input.nextInt();
		System.out.println(name + "您好！您的等待号码为：" + num);

	}
}