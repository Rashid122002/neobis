import java.io.IOException;
import java.util.Scanner;

public class ColumnInArray {
 
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        double M[][] = new double[12][12];
        int C = in.nextInt();
        if(C >= 0 && C <= 11) {
            char T = in.next().charAt(0);
            for(int i = 0; i < M.length; i++) {
                for(int j = 0; j < M[i].length; j++) {
                    M[i][j] = in.nextDouble();
                }
            }
            double sum = 0.;
            for(int i = 0; i < M.length; i++) {
                sum += M[i][C];
            }
            if(T == 'S') {
                System.out.println(String.format("%.1f", sum));
            } else if(T == 'M') {
                sum /= 12;
                System.out.println(String.format("%.1f", sum));
            }
        }
    }
}