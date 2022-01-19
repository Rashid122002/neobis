import java.util.Scanner;

public class Huaauhahhuahau {
    public static void main(String ... args) {
	  Scanner in = new Scanner(System.in);
   	  String s = in.next();
	  String vrl = "";
	  String vlr = "";
	  int j = s.length() - 1;
	  for(int i = 0; i < s.length(); i++) {
		if(s.charAt(i) == 'a' || s.charAt(i) == 'e' ||
		    s.charAt(i) == 'i' || s.charAt(i) == 'o' ||
		    s.charAt(i) == 'u') {
		    vrl += s.charAt(i);
		}
	      if(s.charAt(j) == 'a' || s.charAt(j) == 'e' ||
		    s.charAt(j) == 'i' || s.charAt(j) == 'o' ||
		    s.charAt(j) == 'u') {
		    vlr += s.charAt(j);
		}
		--j;
	  }
	  if(vrl.equals(vlr)) {
		System.out.println("S");
	  } else {
		System.out.println("N");
 	  }
    }
}