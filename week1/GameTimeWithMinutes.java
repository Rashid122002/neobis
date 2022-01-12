import java.util.Scanner;

public class GameTimeWithMinutes {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ihour = in.nextInt();
        int iminute = in.nextInt();
        int fhour = in.nextInt();
        int fminute = in.nextInt();
        int duration = (fhour * 60 + fminute) - (ihour * 60 + iminute);
        if(duration > 0) {
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", duration / 60, duration % 60);
        } else if(duration <= 0) {
            System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", (24 * 60 + duration) / 60, (24 * 60 + duration) % 60);
        }
    }
}