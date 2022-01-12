import java.util.Scanner;

public class WeightedAverages {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int weights[] = new int[]{2, 3, 5};
        int sumOfWeights = 0;
        for(int i = 0; i < 3; i++) {
            sumOfWeights += weights[i];
        }
        int N = in.nextInt();
        double a[][] = new double[N][N];
        double averages[] = new double[N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                a[i][j] = in.nextDouble();
                averages[i] += a[i][j] * weights[j];
            }
        }
        for(int i = 0; i < N; i++) {
            System.out.println(String.format("%.1f", averages[i] / sumOfWeights));
        }
    }
}