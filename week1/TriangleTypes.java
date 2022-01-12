import java.io.IOException;
import java.util.Scanner;

public class TriangleTypes {
 
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        double sides[] = new double[3];
        for(int i = 0; i < sides.length; i++) {
            sides[i] = in.nextDouble();
        }
        for(int i = 0; i < sides.length; i++) {
            for(int j = 0; j < sides.length - 1; j++) {
                if(sides[j] < sides[j+1]) {
                    double temp = sides[j];
                    sides[j] = sides[j+1];
                    sides[j+1] = temp;
                }
            }
        }
        double A = sides[0];
        double B = sides[1];
        double C = sides[2];
        if(A > 0 && B > 0 && C > 0) {
            double D = Math.max(Math.max(A, B), C);
            double temp;
            if(D == B) {
                temp = A;
                A = B;
                B = temp;
            } else if(D == C) {
                temp = A;
                A = B;
                B = temp;
            }
            if(B + C <= A) {
                System.out.println("NAO FORMA TRIANGULO");
            } else if(Math.pow(B, 2) + Math.pow(C, 2) == Math.pow(A, 2)) {
                System.out.println("TRIANGULO RETANGULO");
            } else if((Math.pow(B, 2) + Math.pow(C, 2)) < Math.pow(A, 2)) {
                System.out.println("TRIANGULO OBTUSANGULO");
            } else if((Math.pow(B, 2) + Math.pow(C, 2)) > Math.pow(A, 2)) {
                System.out.println("TRIANGULO ACUTANGULO");
            }
            if(A == B && A == C && B == C) {
                System.out.println("TRIANGULO EQUILATERO");
            }
            if(A == B && A != C) {
                System.out.println("TRIANGULO ISOSCELES");
            } else if(A == C && A != B) {
                System.out.println("TRIANGULO ISOSCELES");
            } else if(B == C && B != A){
                System.out.println("TRIANGULO ISOSCELES");
            }
        }
    }
}