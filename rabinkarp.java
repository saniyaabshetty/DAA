import java.util.Scanner;

public class rabinkarp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String text = sc.nextLine();
        System.out.println("Enter the pattern: ");
        String pattern = sc.nextLine();

        int patternHash = pattern.hashCode(); 

        
        for (int i = 0; i <= text.length() - pattern.length(); i++) {
            String window = text.substring(i, i + pattern.length()); 
            if (patternHash == window.hashCode() && pattern.equals(window)) {
                System.out.println("Pattern found at index: " + i);
            }
        }
    }
}
