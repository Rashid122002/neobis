import java.util.Scanner;

public class PerfectNumber {
    public static void main(String ... args) {
        Scanner in = new Scanner(System.in);
	  int sum, temp;
	  int N = in.nextInt();
	  for(int i = 0; i < N; i++) {
	      sum = 0;
		temp = in.nextInt();
	      for(int j = 1; sum < temp; j++) {
		    sum += j;
		}
		if(sum == 1) {
		    System.out.println(temp + " nao eh perfeito");
		} else if(sum == temp) {
		    System.out.println(temp + " eh perfeito");
		} else {
		    System.out.println(temp + " nao eh perfeito");
		}
	  }
    }
}