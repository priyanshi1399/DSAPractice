public class TruncateSentence {


    public static String truncateString(String s,int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
            if (count == k) {
                return s.substring(0, i);
            }
        }
    return s;
    }
        public static void main (String[]args){
            String s = "What is the solution to this problem";
            int k = 4;
            String ans = truncateString(s, k);

        }
    }
