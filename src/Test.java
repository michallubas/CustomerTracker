import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i=0;
		while (i<10) {
		Random random = new Random();
		int randomId=random.nextInt(3)+1;
		System.out.println(randomId);
		i++;
		}
	}

}
