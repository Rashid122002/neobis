public class SequenceIJ {
 
    public static void main(String[] args) {
        double i;
        for(i = 0.0; i <= 2; i += 0.2) {
            i = Double.parseDouble(String.format("%.1f", i));
            if((i * 10) % 10 == 0) {
                System.out.println("I=" + (int)i + " J=" + (int)(1 + i));
                System.out.println("I=" + (int)i + " J=" + (int)(2 + i));
                System.out.println("I=" + (int)i + " J=" + (int)(3 + i));
            } else {
                System.out.println("I=" + String.format("%.1f", i) + " J=" + String.format("%.1f", 1 + i));
                System.out.println("I=" + String.format("%.1f", i) + " J=" + String.format("%.1f", 2 + i));
                System.out.println("I=" + String.format("%.1f", i) + " J=" + String.format("%.1f", 3 + i));
            }
        }
    }
}