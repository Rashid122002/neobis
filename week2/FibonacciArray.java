import java.util.Scanner;

public class FibonacciArray
{
    public static void main(String ... rashid)
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int[] nums = new int[T];
        long[] fibNums = new long[T];
        for(int i = 0; i < T; i++) {
            nums[i] = in.nextInt();
            fibNums[i] = Fib(nums[i]);
        }
        in.close();
        for(int i = 0; i < T; i++) {
            System.out.println("Fib(" + nums[i] + ") = " + fibNums[i]);
        }
    }

    public static long Fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }
        long n0 = 0;
        long n1 = 1;
        long n2;
        for (int i = 2; i <= n; i++) {
            n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
        }
        return n1;
    }
}