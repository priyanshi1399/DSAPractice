public class ShiftLetter {

    public static void main(String [] args){
       String s = "ruu";
       int [] shifts = {26,9,17};
       shiftingLetters(s,shifts);
    }

    public static String shiftingLetters(String s, int[] shifts) {
        int n=shifts.length;
        int [] prefixArray=new int[n];
        prefixArray[n-1]=shifts[n-1]%26;
        for(int i=n-2;i>=0;i--){
            prefixArray[i]=(prefixArray[i+1]+shifts[i])%26;
        }

        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=(char)('a'+(s.charAt(i)-'a'+prefixArray[i])%26);
            str.append(ch);
        }
        return str.toString();
    }
}

