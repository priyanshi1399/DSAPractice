public class DIString {


    public static void main(String [] args){
        String pattern="IIIDIDDD";
        int n = pattern.length();
        char[] num = new char[n + 1];

        // Initialize num as "1234..." (n+1 characters)
        for (int i = 0; i <= n; i++) {
            num[i] = (char) ('1' + i);
        }
    }
}
