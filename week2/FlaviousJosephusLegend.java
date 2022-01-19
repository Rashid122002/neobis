import java.util.Scanner;

public class FlaviousJosephusLegend {
    public static void main(String ... args) {
	  Scanner in = new Scanner(System.in);
	  int NC = in.nextInt();
	  int n, k, last;
	  for(int i = 1; i <= NC; i++) {
		n = in.nextInt();
		k = in.nextInt();
		last = 0;
		for(int j = 2; j <= n; j++) {
		    last = (last + k) % j;
		}
		System.out.println("Case " + i + ": " + (last + 1));
	  }
    }
}