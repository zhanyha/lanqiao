import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] split = line.split("");
		String[] input = new String[11];
		int spLen = split.length;
		int inLen = split.length;
		int j = -1;
		int sum = 0;
		for (int i = 0; i < spLen; i++) {
			if(!split[i].equals("-")){
				input[++j] = split[i];
			}
		}
		for (int i = 1; i < inLen - 1; i++) {
			int num = Integer.parseInt(input[i]);
			sum+=num*i;
		}
		int check = Integer.parseInt(input[inLen - 1]);
		int s = sum%11;
		if(s == check){
			System.out.println("Right");
		}else{
			if(s==0)
				split[spLen - 1] = "X";
			else
				split[spLen - 1] = ""+s;
			for (String string : split) {
				System.out.print(string);
			}
		}
		sc.close();
	}

}