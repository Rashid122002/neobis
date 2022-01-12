import java.io.IOException;
import java.util.Scanner;

public class LogicalSequence2 {
 
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int X = in.nextInt();
        int Y = in.nextInt();
        int count = 0;
        for(int i = 1; i <= Y; i++) {
            ++count;
            if(count == X) {
                count = 0;
                System.out.println(i);
            } else{
                System.out.print(i + " ");
            }
        }
    }
}