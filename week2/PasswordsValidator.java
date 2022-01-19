import java.util.Scanner;

public class PasswordsValidator {
    public static void main(String ... args) {
        Scanner in = new Scanner(System.in);
	  String S;
	  int check, upperCaseCount, lowerCaseCount, numberCount;
	  while(in.hasNext()) {
		S = in.nextLine();
		check = 0;
		upperCaseCount = 0;
	      lowerCaseCount = 0;
		numberCount = 0;
		if(S.length() >= 6 && S.length() <= 32) {
		    for(int i = 0; i < S.length(); i++) {
			  if((int)(S.charAt(i)) >= 0 && (int)(S.charAt(i)) < 48 || 
                        (int)(S.charAt(i)) > 57 && (int)(S.charAt(i)) < 65 || 
                        (int)(S.charAt(i)) > 90 && (int)(S.charAt(i)) < 97 || 
				(int)(S.charAt(i)) > 122 && (int)(S.charAt(i)) <= 127) {
				check = check + 1;
			  }
			  if(Character.isUpperCase(S.charAt(i))) {
				upperCaseCount = upperCaseCount + 1;
			  }
			  if(Character.isLowerCase(S.charAt(i))) {
				lowerCaseCount = lowerCaseCount + 1;
			  }
			  if(isNumeric(S.charAt(i))) {
				numberCount = numberCount + 1;
			  }
		    }
		    if(check == 0) {
			  if(upperCaseCount > 0 && lowerCaseCount > 0 && numberCount > 0) {
				System.out.println("Senha valida.");
			  } else {
			  	System.out.println("Senha invalida.");
		        }
		    } else {
			  System.out.println("Senha invalida.");
		    }
		} else {
		    System.out.println("Senha invalida.");
		}
	  }
    }
    public static boolean isNumeric(char ch) { 
        try {  
            Integer.parseInt(ch + "");  
            return true;
  	  } catch(NumberFormatException e){  
    		return false;  
  	  }  
    }
}