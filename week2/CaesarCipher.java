import java.util.Scanner;

public class CaesarCipher {
    public static void main(String ... args) {
        Scanner in = new Scanner(System.in);
	  int N = in.nextInt();
	  String str, result;
	  int shifts;
	  int ascii[];
	  for(int i = 0; i < N; i++) {
		str = in.next();
		shifts = in.nextInt();
		result = "";
		ascii = new int[str.length()];
		for(int j = 0; j < str.length(); j++) {
		    if((int)str.charAt(j) - shifts >= 65) {
			  ascii[j] = (int)str.charAt(j) - shifts;
		    } else {
                    ascii[j] = 91 - (65 - ((int)str.charAt(j) - shifts));
		    }
		    result += (char)ascii[j];
		}
		System.out.println(result);
	  }
    }
}