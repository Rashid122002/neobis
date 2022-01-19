import java.util.Scanner;

public class CompareSubstring {
    public static void main(String ... args) {
	  Scanner in = new Scanner(System.in);
	  String str1, str2;
	  int istr1, istr2;
	  int temp = 0;
	  int len = 0;
	  while(in.hasNext()) {
		str1 = in.nextLine();
		str2 = in.nextLine();
		len = 0;
		temp = 0;
		for(int i = 0; i < str1.length(); i++) {
		    for(int j = 0; j < str2.length(); j++) {
			  if(str1.charAt(i) == str2.charAt(j)) {
				istr1 = i;
				istr2 = j;
				temp = 0;
				while(istr1 < str1.length()) {
				    if(istr2 >= str2.length()) {
					  istr1 = str1.length();
				    } else {
					  if(str1.charAt(istr1) == str2.charAt(istr2)) {
					      temp = temp + 1;
				        } else {
					  	istr1 = str1.length();
				        }
				    	  ++istr1;
				    	  ++istr2;
				    }                                                                                                                                                               
				}
			  }
			  if(temp > len) {                                  
				len = temp;
			  }
		    }
		}
		System.out.println(len);
	  }
    }
}