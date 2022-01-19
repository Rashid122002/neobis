import java.util.Scanner;

public class PrimeNumber {
    public static void main(String ... args) {
        Scanner in = new Scanner(System.in);
	  boolean flag;
	  int X;
	  int N = in.nextInt();
	  for(int i = 0; i < N; i++) {
		flag = true;
		X = in.nextInt();
		for(int j = 2; j < X; j++) {
		    if(X % j == 0) {
		        flag = false;
		    }
		}
		if(flag) {
		    System.out.println(X + " eh primo");
		} else {
		    System.out.println(X + " nao eh primo");
		}
	  }
    }
}