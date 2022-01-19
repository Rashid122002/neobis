import java.util.Scanner;

public class Combiner {
    public static void main(String ... args) {
        Scanner in = new Scanner(System.in);
	  int N = in.nextInt();
	  String str1, str2;
	  for(int i = 0; i < N; i++) {
	      str1 = in.next();
	      str2 = in.next();
		int k;
		String result = "";
		if(str1.length() < str2.length()) {
  		    for(k = 0; k < str1.length(); k++) {
		        result += str1.charAt(k) + "" + str2.charAt(k);
		    }
		    result += str2.substring(k, str2.length());
		} else if(str1.length() > str2.length()) {
		    for(k = 0; k < str2.length(); k++) {
			  result += str1.charAt(k) + "" + str2.charAt(k);
		    }
		    result += str1.substring(k, str1.length());
		} else {
		    for(k = 0; k < str1.length(); k++) {
			  result += str1.charAt(k) + "" + str2.charAt(k);
		    }
		}
		System.out.println(result);
	  }
    }
}