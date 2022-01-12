import java.util.Scanner;

public class Banknotes {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        if(N > 0 && N < 1000000) {
            System.out.println(N);
            int hundreds = N / 100;
            int fifties = N % 100 / 50;
            int twenties = N % 100 % 50 / 20;
            int tens = N % 100 % 50 % 20 / 10;
            int fives = N % 100 % 50 % 20% 10 / 5;
            int twos = N % 100 % 50 % 20% 10 % 5 / 2;
            int ones = N % 100 % 50 % 20% 10 % 5 % 2 / 1;
            System.out.println(hundreds + " nota(s) de R$ 100,00");
            System.out.println(fifties + " nota(s) de R$ 50,00");
            System.out.println(twenties + " nota(s) de R$ 20,00");
            System.out.println(tens + " nota(s) de R$ 10,00");
            System.out.println(fives + " nota(s) de R$ 5,00");
            System.out.println(twos + " nota(s) de R$ 2,00");
            System.out.println(ones + " nota(s) de R$ 1,00");
        }
        in.close();
    }
}