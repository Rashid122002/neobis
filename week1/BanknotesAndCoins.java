import java.io.IOException;
import java.util.Scanner;

public class BanknotesAndCoins {
 
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        double N = in.nextDouble();
        int n = (int)N;
        int hundreds = n / 100;
        int fifties = n % 100 / 50;
        int twenties = n % 100 % 50 / 20;
        int tens = n % 100 % 50 % 20 / 10;
        int fives = n % 100 % 50 % 20% 10 / 5;
        int twos = n % 100 % 50 % 20% 10 % 5 / 2;
        int ones = n % 100 % 50 % 20% 10 % 5 % 2 / 1;
        n = (int)(N * 100);
        n %= 100;
        int fifty = n / 50;
        int tf = n % 50 / 25;
        int ten = n % 50 % 25 / 10;
        int five = n % 50 % 25 % 10 / 5;
        int one = n % 50 % 25 % 10 % 5 / 1;
        System.out.println("NOTAS:");
        System.out.println(hundreds + " nota(s) de R$ 100.00");
        System.out.println(fifties + " nota(s) de R$ 50.00");
        System.out.println(twenties + " nota(s) de R$ 20.00");
        System.out.println(tens + " nota(s) de R$ 10.00");
        System.out.println(fives + " nota(s) de R$ 5.00");
        System.out.println(twos + " nota(s) de R$ 2.00");
        System.out.println("MOEDAS:");
        System.out.println(ones + " moeda(s) de R$ 1.00");
        System.out.println(fifty + " moeda(s) de R$ 0.50");
        System.out.println(tf + " moeda(s) de R$ 0.25");
        System.out.println(ten + " moeda(s) de R$ 0.10");
        System.out.println(five + " moeda(s) de R$ 0.05");
        System.out.println(one + " moeda(s) de R$ 0.01");
    }
}