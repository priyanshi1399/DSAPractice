public class FindTheOriginalType {

    public static void main(String [] args){
        String  word = "aabbccdd";
        int k=8;
        possibleStringCount(word,k);
    }

    public static int possibleStringCount(String word,int k) {
        int n=word.length();
        int count=1;
        int i=0;
        int j=1;
        while(i<n && j<n){
            if (word.charAt(i)==word.charAt(j)){
                count++;
            }
            i++;
            j++;
        }

        int res=(int)((k)%(Math.pow(10,9)+7));
        return res;
    }
}
