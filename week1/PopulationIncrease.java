import java.util.Scanner;

public class PopulationIncrease {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int PA, PB, count = 0;
        double G1, G2;
        for(int i = 0; i < T; i++) {
            PA = in.nextInt();
            PB = in.nextInt();
            G1 = in.nextDouble();
            G2 = in.nextDouble();
            while(PA <= PB) {
                ++count;
                PA = PA + (int)(PA * G1 / 100);
                PB = PB + (int)(PB * G2 / 100);
                if(count > 100) {
                    break;
                }
            }
            if(count > 100) {
                System.out.println("Mais de 1 seculo.");
            } else {
                System.out.println(count + " anos.");
            }
            count = 0;
        }
    }
}