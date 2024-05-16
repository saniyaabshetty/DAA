public class stringnaive {
  
    static void naiveStringMatch(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;

      
            for (j = 0; j < patternLength; j++) {
                if (text.charAt(i + j) != pattern.charAt(j))
                    break; 
            }

            if (j == patternLength) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAAABAA";
        String pattern = "AABA";
        System.out.println("Text: " + text);
        System.out.println("Pattern: " + pattern);
        System.out.println("Matching positions:");
        naiveStringMatch(text, pattern);
    }
}

