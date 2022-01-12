import java.util.Scanner;

public class Grenais {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int response, inter, gremio;
        int countGames = 0, interwins = 0, gremiowins = 0, empates = 0;
        while(true) {
            inter = in.nextInt();
            gremio = in.nextInt();
            System.out.println("Novo grenal (1-sim 2-nao)");
            response = in.nextInt();
            countGames++;
            if(inter > gremio) {
                interwins++;
            } else if(inter < gremio) {
                gremiowins++;
            } else {
                empates++;
            }
            if(response == 2) {
                break;
            }
        }
        System.out.println(countGames + " grenais");
        System.out.println("Inter:" + interwins);
        System.out.println("Gremio:" + gremiowins);
        System.out.println("Empates:" + empates);
        if(interwins > gremiowins) {
            System.out.println("Inter venceu mais");
        } else if(interwins < gremiowins) {
            System.out.println("Gremio venceu mais");
        } else {
            System.out.println("Não houve vencedor");
        }
    }
 
}